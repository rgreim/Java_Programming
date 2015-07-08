package Miniweb.JUnit_Tests;

import Miniweb.Logger;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Webserver
 * Logger-Tests
 *
 * @author Fabian Mueller (fmueller83@googlemail.com)
 * @version 0.3
 */
public class LoggerTest {
    private static final String fileName = "TEST.TXT";
    private File file;
    private Scanner scanner;
    private Logger logger;

    @org.junit.AfterClass
    public static void deleteFiles() {
        File file = new File(fileName);
        file.delete();
    }

    @org.junit.Before
    public void setUp() throws Exception {
        logger = new Logger(new FileOutputStream(new File(fileName)));
        file = new File(fileName);
        scanner = new Scanner(file);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        logger.close();
        scanner.close();
    }

    @org.junit.Test
    public void testPrint() throws Exception {
        String str = "Example String One";
        String str2 = "Example String Two";
        logger.print(str);
        logger.print("\n");
        logger.print(str2);
        logger.print("\n");
        logger.print("\n");
        assertEquals(scanner.nextLine(), str);
        assertEquals(scanner.nextLine(), str2);
        assertEquals(scanner.nextLine(), "");
    }

    @org.junit.Test
    public void testPrintln() throws Exception {
        String str = "Example String One";
        String str2 = "Example String Two";
        logger.println(str);
        logger.println(" ");
        logger.println(str2);
        assertEquals(scanner.nextLine(), str);
        assertEquals(scanner.nextLine(), " ");
        assertEquals(scanner.nextLine(), str2);
    }

    @org.junit.Test
    public void testLog() throws Exception {
        String str = "Example String One";
        String str2 = "Example String Two";
        logger.log(str);
        logger.log(" ");
        logger.log(str2);
        logger.log(" ");
        assertEquals(scanner.nextLine(), str);
        assertEquals(scanner.nextLine(), " ");
        assertEquals(scanner.nextLine(), str2);
        assertEquals(scanner.nextLine(), " ");
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testClose() throws Exception {
        String str = "Example String One";
        logger.close();
        logger.log(str);
        scanner.nextLine();
    }
}
