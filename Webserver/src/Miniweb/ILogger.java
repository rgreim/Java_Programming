package Miniweb;

/**
 * Webserver
 *
 * @author Fabian Mueller (fmueller83@googlemail.com)
 * @version 0.3
 */
public interface ILogger {

    /**
     * Prints a message to the output stream using a PrintWriter object .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    void print(String message);

    /**
     * Prints a message and adds a tailing <u > newLine </ u > to the output stream using a PrintWriter object .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    void println(String message);

    /**
     * Logs a message to the output stream .
     * <p>
     * Every message gets a single line .
     * <p>
     * Flushes the output buffer of the PrintWriter object .
     *
     * @param message the messages that is written to the output stream .
     */
    void log(String message);

    /**
     * Closes the PrintWriter object .
     */
    void close();
}

