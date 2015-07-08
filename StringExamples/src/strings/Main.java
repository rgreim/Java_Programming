package strings;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * StringExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("/home/rgreim/eo-vlokreeft_01.jpg");
        String path = file.getAbsolutePath();
        String cpath = null;
        try {
            cpath = file.getCanonicalPath(); //wichtig für Uebung03
        } catch (IOException e) {
            e.printStackTrace();
        }


        String ext = getFileExtension(path).toLowerCase();
        String mimeType = null;

        switch (ext) {      //effizienter als if/else!
            case "png": {
                mimeType = "image/png";
                break;
            }
            case "jpe":
            case "jpeg":
            case "jpg": {
                mimeType = "image/jpeg";
                break;
            }
            default: {
                System.out.println("Unknown MimeType detected!");
                break;
            }
        }

        //if (ext.equals("jpg")) {
        //    System.out.println("image/jpg");
        //}


        System.out.println("path = " + path);
        System.out.println("cpath = " + cpath);

        String request = "GET /index.html HTTP/1.1";
        StringTokenizer tokenizer = new StringTokenizer(request);

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    private static String getFileExtension(String path) {
        String[] tokens = path.split("\\.");
        //return tokens[tokens.length - 1];
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
