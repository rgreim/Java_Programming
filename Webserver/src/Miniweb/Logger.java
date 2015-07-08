package Miniweb;

import java.io.*;

/**
 * Webserver
 *
 * @author R.Greim
 * @version 0.3
 */
public class Logger implements ILogger {
    public static Logger errorLogger;
    public static Logger standardLogger;
    byte[] buffer = new byte[1024];

    static {
        try {
            standardLogger = new Logger(new FileOutputStream(new File("miniweb.log"), true));
            errorLogger = new Logger(new FileOutputStream(new File("miniweb.err"), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final OutputStream outputStream;
    private PrintWriter lPrint;
    /**
     * Prints a message to the output stream using a PrintWriter object .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    @Override
    public void print(String message) {
        lPrint.print(message);
        lPrint.flush();
    }

    /**
     * Prints a message and adds a tailing <u > newLine </ u > to the output stream using a PrintWriter object .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    @Override
    public void println(String message) {
        lPrint.println(message);
        lPrint.flush();
    }

    /**
     * Logs a message to the output stream .
     * <p>
     * Every message gets a single line .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    @Override
    public void log(String message) {
        lPrint.println(message);
        lPrint.flush();
    }

    /**
     * Closes the PrintWriter object .
     */
    @Override
    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This constructor creates a new Logger object .
     * <p>
     * All messages are written to the provided output stream .
     *
     * @param outputStream output stream to where all messages are written to
     */
    public Logger(OutputStream outputStream) {
        this.outputStream = outputStream;
        lPrint = new PrintWriter(outputStream);
    }

    /**
     * This counstructer creates a new Logger object .
     * <p>
     * All messages are written to System . out .
     */
    public Logger() {
        this(System.out);
    }

}
