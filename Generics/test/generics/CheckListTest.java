/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rgreim
 */
public class CheckListTest {

    @Test
    public void testCheckList() {
        CheckList check = new CheckList();
        CheckEveness even = new CheckEveness();
        List<Integer> l = Arrays.asList(1, 22, 24, 2, 3, 15);
        assertEquals(check.CheckCollection(l, even), 3);
    }
    
    @Test
    public void testCheckWholeNumber(){
        CheckWholeNumber check = new CheckWholeNumber();
        CheckList list = new CheckList();
        List<Number> d = Arrays.asList(1, 2.5, 3, 0.1);
        assertEquals(list.CheckCollection(d, check), 2);
    }
}
