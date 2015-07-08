package Miniweb;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

import static Miniweb.Logger.errorLogger;

/**
 * Webserver
 *
 * @author R.Greim
 * @version 0.3
 */
public class ClientHandler implements Runnable {
    private Socket socket;      //the client socket
    private String method;      //the http method (e.g. GET)
    private String path;        //the requested path (e.g. /index.html)
    private String version;     //the requested HTTP version (e.g. HTTP 1.1)
    private String host;        //the requested host (e.g. 127.0.0.1)
    private String documentRoot = Main.documentRoot;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            handleRequest();
        } catch (IOException e) {
            try {
                methodInternalServerError500();
            } catch (IOException e1) {
                errorLogger.log("Internal Server Error happened.");
            }
        }
    }

    /**
     * If the HTTP - Method is GET the requested file (/index.html) will be delivered .
     * Otherwise a 400 Bad Request will be sent to the client .
     * <p>
     * Example: GET /index.html HTTP/1.1
     *
     * @throws IOException in case something is wrong with the socket
     */
    private void handleRequest() throws IOException {
        InputStreamReader stream = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(stream);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        if (tokenizer.countTokens() == 3) {
            method = tokenizer.nextToken();
            path = tokenizer.nextToken();
            version = tokenizer.nextToken();
        }

        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equals("Host:")) {
                host = tokenizer.nextToken();
            }
        }

        switch (method) {
            case "GET": {
                methodGET();
                break;
            }
            // More HTTP-Methods to come
            // case "POST":
            // ...
            default: {
                badRequest400();
                break;
            }
        }
        socket.close();S
        reader.close();
    }

    /**
     * This method handles a GET - Request. 200 OK is the status code if everything
     * works as expected.
     * <p>
     * If the requested path is "/" the file "/index.html" will be delivered .
     * <p>
     * If the canonical parent path of the requested file does not start with
     * the DocumentRoot 403 Forbidden will be sent to the client.
     *
     * @throws IOException
     */
    private void methodGET() throws IOException {
        FileInputStream fileInputStream = null;
        String canonicalParentPath = null;
        String mimeType = null;
        File file = null;
        byte[] buffer = new byte[1024];

        // get the outputstream from socket
        OutputStream output = socket.getOutputStream();

        // if path == ’/ ’ then manually set it to ’/index.html’
        if (path.equals("/")) {
            path = documentRoot + "/index.html";
        } else {
            path = documentRoot + path;
        }

        // get the canonical parent path of of the requested file
        file = new File(path);

        try {
            canonicalParentPath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If the canonical parent path does not start with DocumentRoot send 403 Forbidden.
        if (!canonicalParentPath.startsWith(documentRoot)) {
            forbidden403();
        } else {

            // Try to open the FileInputStream of the requested file
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                // Send 404 Not Found
                fileNotFound404();
                fileInputStream.close();
            }

            // get the mime type of the requested file
            mimeType = getMimeType(file);

            // send HTTP-Header as utf-8 bytes
            String header = HTTP.ok200(mimeType, (int) file.length());
            output.write(header.getBytes(StandardCharsets.UTF_8));

            // send HTTP-Body with FileInputStream and FileOutputStream
            // Hint: Try to send the requested file byte by byte .
            //Use the methods read() and write();
            //Do not send the end-of-file signal ’-1 ’. Break the
            //loop instead.
            //Hint for the pros : Use the method read (byte[] buffer )
            //and rewrite the complete while-loop .
            while (fileInputStream.available() > 0) {
                int bytesRead = fileInputStream.read(buffer, 0, buffer.length);
                output.write(buffer, 0, bytesRead);
            }
            output.flush();
            // close all streams
            fileInputStream.close();
            output.close();
        }
    }


    private void sendErrorCode(String s) throws IOException {
        OutputStream output = socket.getOutputStream();
        output.write(s.getBytes());
        output.flush();
        output.close();
    }

    private void badRequest400() throws IOException {
        sendErrorCode(HTTP.badRequest400());
    }

    private void forbidden403() throws IOException {
        sendErrorCode(HTTP.forbidden403());
    }

    private void fileNotFound404() throws IOException {
        sendErrorCode(HTTP.notFound404());
    }

    private void methodInternalServerError500() throws IOException {
        sendErrorCode(HTTP.internalServerError500());
    }

    /**
     * Checks the extension of a file and returns the corresponding mime type .
     *
     * @param file a file
     * @return the mime type of the file
     */
    private String getMimeType(File file) {
        String mimeType = null;
        String extension = getFileExtension(path).toLowerCase();
        switch (extension) {
            case "html": {
                mimeType = "text/html";
                break;
            }
            case "png": {
                mimeType = "image/png";
                break;
            }
            case "gif": {
                mimeType = "image/gif";
                break;
            }
            case "jpe":
            case "jpeg":
            case "jpg": {
                mimeType = "image/jpeg";
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown Mime Type");
            }
        }
        return mimeType;
    }

    /**
     * Returns the file extension of the given file path.
     *
     * @param path a file path
     * @return file extension of the file path
     */
    private String getFileExtension(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }
}


