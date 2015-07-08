package ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socketfoo
 *
 * @author R.Greim
 * @version 0.1
 */
public class Server implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
            Socket clientSocket = serverSocket.accept();

            InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String clientIP = clientSocket.getInetAddress().toString();
            System.out.print("Client with IP " + clientIP + " connected");

            String message = reader.readLine();
            System.out.println(" and sent '" + message + "'.");

            reader.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
