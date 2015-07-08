package Miniweb;


import java.util.Scanner;

/**
 * Webserver
 *
 * @author R.Greim
 * @version 0.3
 */
public class Main {
    private static Thread server = null;
    static String documentRoot = System.getProperty("user.dir");
    public static String appName = "GarysAquariumServer";
    public static String version = "HTTP/1.1";


    public static void main(String[] args) {
        System.out.println(appName + " Version " + version + " by Robin Greim");
        System.out.println("Commands: (s)tart | (a)bort | (h)elp | (r)oot | (q)uit");
        System.out.println("> ");
        Scanner in = new Scanner(System.in);
        String com = "";

        while (true) {
            switch (com = in.next()) {
                case "start":
                case "s": {
                    startServer();
                    break;
                }
                case "abort":
                case "a": {
                    stopServer();
                    break;
                }
                case "help":
                case "h": {
                    printHelp();
                    break;
                }
                case "root":
                case "r": {
                    setRoot(in.next());
                    break;
                }
                case "quit":
                case "q": {
                    quitServer();
                    break;
                }
            }
            System.out.println("> ");
        }

    }

    private static void startServer() {
        if (server == null) {
            System.out.println("Hello, World!");
            server = new ServerThread("127.0.0.1", 8000);
            server.start();
        } else {
            if (server.isAlive() && server.getState() == Thread.State.RUNNABLE) {
                System.out.println("Server is already running! Please chose another command or exit the program.");
            } else {
                System.out.println("Serverstate is unknown. Server will get closed.");
                server.interrupt();
            }
        }

    }

    private static void stopServer() {
        if (server != null) {
            while (server.isAlive()) {
                server.interrupt();
            }
            server = null;
            System.out.println("Server is stopped.");
        } else {
            System.out.println("Server is not running at the moment.");

        }
    }

    private static void setRoot(String path) {
        System.out.println("Note: Please make sure to insert a valid directory. If not the program can act in an unusual way " +
                " or security issues may arise!");
        documentRoot = path;
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("(a)bort:    stops the server");
        System.out.println("(h)elp:     prints this help");
        System.out.println("(q)uit:     exits program");
        System.out.println("(r)oot:     change root path");
        System.out.println("(s)tart:    starts the server");
    }

    private static void quitServer() {
        System.out.println("Program exits now.");
        System.exit(0);
    }

}
