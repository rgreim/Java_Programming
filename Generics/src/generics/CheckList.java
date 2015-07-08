/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Collection;

/**
 *
 * @author rgreim
 */
public class CheckList {

    public <A extends Number> int CheckCollection(Collection<A> c, Predicate<A> p){
        int count = 0;
        for (A e : c)
            if (p.hasProperty(e))
                count++;
        
        return count;
    }
    
}
