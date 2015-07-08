package Miniweb.JUnit_Tests;

import Miniweb.HTTP;
import Miniweb.Main;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Webserver
 * HTTP-Tests
 *
 * @author Fabian Mueller (fmueller83@googlemail.com)
 * @version 0.3
 */
public class HTTPTest {
    @Test
    public void testOk200() throws Exception {
        String statusCode = "200";
        String statusMessage = "OK";
        String mimeType = "text/html";
        int contentSize = 60;
        Assert.assertEquals("Should return a " + statusCode + " " + statusMessage + ".",
                htmlHeader(statusCode, statusMessage, mimeType, contentSize),
                HTTP.ok200(mimeType, contentSize));
    }

    @Test
    public void testBadRequest400() throws Exception {
        String statusCode = "400";
        String statusMessage = "Bad Request";
        String mimeType = "text/html";
        assertEquals("Should return a " + statusCode + " " + statusMessage + ".",
                htmlFrame(statusCode, statusMessage, mimeType), HTTP.badRequest400());
    }

    @Test
    public void testForbidden403() throws Exception {
        String statusCode = "403";
        String statusMessage = "Forbidden";
        String mimeType = "text/html";
        assertEquals("Should return a " + statusCode + " " + statusMessage + ".",
                htmlFrame(statusCode, statusMessage, mimeType), HTTP.forbidden403());
    }

    @Test
    public void testNotFound404() throws Exception {
        String statusCode = "404";
        String statusMessage = "Not Found";
        String mimeType = "text/html";
        assertEquals("Should return a " + statusCode + " " + statusMessage + ".",
                htmlFrame(statusCode, statusMessage, mimeType), HTTP.notFound404());
    }

    @Test
    public void testInternalServerError500() throws Exception {
        String statusCode = "500";
        String statusMessage = "Internal Server Error";
        String mimeType = "text/html";
        assertEquals("Should return a " + statusCode + " " + statusMessage + ".",
                htmlFrame(statusCode, statusMessage, mimeType), HTTP.internalServerError500());
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
        header.append("Content-Length: "+ contentSize + "\n");
        header.append("Content-Language: de\n");
        header.append("Connection: close\n");
        header.append("Content-Type: " + mimeType + "\n");
        header.append("\n");
        return header.toString();
    }
}