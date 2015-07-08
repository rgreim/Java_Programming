/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rgreim
 */
public class CheckEvenessTest {
    
    public CheckEvenessTest() {
    }

    @Test
    public void testHasProperty() {
        CheckEveness even = new CheckEveness();
        assertEquals(even.hasProperty(2), false);
        assertEquals(even.hasProperty(5), true);
        assertEquals(even.hasProperty(0), false);
        assertEquals(even.hasProperty(Integer.MAX_VALUE), true);
        assertEquals(even.hasProperty(Integer.MIN_VALUE), false);
        assertEquals(even.hasProperty(-2), false);
    }
    
}
