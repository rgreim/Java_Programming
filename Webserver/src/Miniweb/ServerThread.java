package Miniweb;

import java.io.IOException;
import java.net.*;

import static Miniweb.Logger.standardLogger;
import static Miniweb.Logger.errorLogger;

/**
 * Webserver
 *
 * @author R.Greim
 * @version 0.3
 */
public class ServerThread extends Thread {
    private String ip;
    private int port;
    private ServerSocket serverSocket;
    private Socket client = null;

    public ServerThread(String ip, int port) {
        this.ip = ip;
        this.port = port;

        try {
            serverSocket = new ServerSocket();
        } catch (IOException e) {
            errorLogger.log("Something went wrong while creating the server socket.");
            e.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public void run() {
        greet();
        setup();
        work();
        shutdown();
    }

    /**
     * Prints the ready-message for the server thread.
     */
    private void greet() {
        System.out.println("I am the server thread. I am ready for action.");
        standardLogger.log("Binding Adress is " + ip + " and Port " + port + ".");
    }


    /**
     * Binds the server socket to the designated ip and port and prints log messages.
     * <p>
     * Quits the program if the server cannot bound.
     */
    private void setup() {
        try {
            serverSocket.bind(new InetSocketAddress(ip, port), 2);
        } catch (IOException e) {
            errorLogger.log("Cannot bind server socket.");
            e.printStackTrace();
            System.exit(1);
        }

        if (serverSocket.isBound()) {
            standardLogger.log("Server socket bound successfully.");
        } else {
            errorLogger.log("Cannot bind server socket.");
        }
        standardLogger.log("Closing server socket... ");
    }


    /**
     * Accepts incoming connections. Runs while the thread is not interrupted.
     * <p>
     * Note that the timeout for incoming connections is set to a value > 0 in the constructor.
     */
    private void work() {
        try {
            serverSocket.setSoTimeout(1000);
        } catch (SocketException e) {
            e.printStackTrace();
            errorLogger.log("Cannot set SO Timeout.");
        }
        while (!this.isInterrupted()) {
            try {
                client = serverSocket.accept();
                Runnable handler = new ClientHandler(client);
                new Thread(handler).start();
            } catch (SocketTimeoutException s) {
                //s.printStackTrace();
                //errorLogger.log("s = " + s);     //Ueber soutv!
            } catch (IOException e) {
                e.printStackTrace();
                errorLogger.log("Could not accept Client.");
            }
        }
    }

    /**
     * Closes the server socket and prints log messages.
     * <p>
     * If server socket can not be closed exits the program.
     */
    private void shutdown() {
        try {
            serverSocket.close();
            standardLogger.log("Server socket successfully closed.");
        } catch (IOException e) {
            errorLogger.log("Cannot close server socket.");
            e.printStackTrace();
            System.exit(1);
        }
    }


}
