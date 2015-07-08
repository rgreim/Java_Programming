package strings;

import java.io.*;
import java.util.Scanner;

/**
 * StringExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class FileCopy {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("/home/rgreim/OOPIS_Termine.txt"));      //Byteweise lesen nicht mit Scanner! Direkt über Streams"

        // while(scanner.hasNextLine()) {
        //    System.out.println(scanner.nextLine());
        //}

        FileInputStream fileInputStream = new FileInputStream("/home/rgreim/uniprotDB_part.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/home/rgreim/faust2.txt");
        byte[] buffer = new byte [1024];        //buffer, da lesen von nur einem byte zu langwierig
        try {
            while (fileInputStream.available() > 0) {
                int bytesRead = fileInputStream.read(buffer, 0, buffer.length);
                fileOutputStream.write(buffer, 0, bytesRead);
                //System.out.println(fileInputStream.read());
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
