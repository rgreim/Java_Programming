package ServerSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Socketfoo
 *
 * @author R.Greim
 * @version 0.1
 */
public class Client implements Runnable {

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("Sup, bro?");
            writer.flush();

            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
