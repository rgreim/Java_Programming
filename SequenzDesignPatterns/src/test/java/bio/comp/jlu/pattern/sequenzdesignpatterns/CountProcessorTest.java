/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.sequenzdesignpatterns;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author rgreim
 */
public class CountProcessorTest {

    public CountProcessorTest() {
    }

    @Test
    public void testCountCorrect() {
        CountProcessor cp = new CountProcessor();
        cp.processSequence("sfaag");
        cp.processSequence("agdgs");
        cp.processSequence("adgsg");
        assertEquals(cp.getCount(), 3);
    }
    
    public void testObserverIsNotified() {
        CountProcessor cp = new CountProcessor();
        Observer mock = mock(Observer.class);
        cp.addObserver(mock);
        cp.processSequence("sagds");
        
    }

}
