package Miniweb;

/**
 * Webserver
 *
 * @author R.Greim
 * @version 0.3
 */
public class HTTP {

    private static String statusCode;
    private static String statusMessage;
    private static String mimeType;


    public static String ok200(String mimeType, int contentSize) {
        statusCode = "200";
        statusMessage = "OK";
        return htmlHeader(statusCode, statusMessage, mimeType, contentSize);
    }

    public static String badRequest400() {
        statusCode = "400";
        statusMessage = "Bad Request";
        mimeType = "text/html";
        return htmlFrame(statusCode, statusMessage, mimeType);
    }

    public static String forbidden403() {
        statusCode = "403";
        statusMessage = "Forbidden";
        mimeType = "text/html";
        return htmlFrame(statusCode, statusMessage, mimeType);
    }

    public static String notFound404() {
        statusCode = "404";
        statusMessage = "Not Found";
        mimeType = "text/html";
        return htmlFrame(statusCode, statusMessage, mimeType);
    }

    public static String internalServerError500() {
        statusCode = "500";
        statusMessage = "Internal Server Error";
        mimeType = "text/html";
        return htmlFrame(statusCode, statusMessage, mimeType);
    }

    private static String htmlFrame(String statusCode, String statusMessage, String mimeType) {
        String body
                = htmlBody(statusCode, statusMessage);
        String header = htmlHeader(statusCode, statusMessage, mimeType, body.length());
        return header + body;
    }

    private static String htmlBody(String statusCode, String statusMessage) {
        StringBuilder body = new StringBuilder();
        body.append("<!DOCTYPE HTML>\n");
        body.append("<html><head>\n");
        body.append("<title>" + statusCode + " " + statusMessage + "</title>\n");
        body.append("</head><body>\n");
        body.append("<h1>" + statusCode + " " + statusMessage + "</h1>\n");
        body.append("<hr>\n");
        body.append("<address>" + Main.appName + "/" + Main.version + "</address>\n");
        return body.toString();
    }

    private static String htmlHeader(String statusCode, String statusMessage,
                                     String mimeType, int contentSize) {
        StringBuilder header = new StringBuilder();
        header.append("HTTP/1.1 " + statusCode + " " + statusMessage + "\n");
        header.append("Server: " + Main.appName + "/" + Main.version + "\n");
        header.append("Content-Length : " + contentSize + "\n");
        header.append("Content-Language: de\n");
        header.append("Connection: close\n");
        header.append("Content-Type: " + mimeType + "\n");
        header.append("\n");
        return header.toString();
    }
}
