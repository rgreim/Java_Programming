package Farm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class CowTest {

    @Test
    public void testMuh() {
        assertEquals("Die Kuh sollte einen Kuh-Ton von sich geben", "Muh!", new Cow().muh());
    }

    @Test
    public void testKrank() {
        assertEquals("Diese Kuh sollte krank sein.", "Muuuuuuuh!", new Cow(true).muh());
    }

    @Test
    public void testGesund(){
     assertEquals("Diese Kuh sollte gesund sein.", "Muh!", new Cow().muh());
    }
}