/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Collection;

/**
 * Interface that creates a random Integer object.
 * @author rgreim
 */
public class ObjectList{
    IntegerGenerator ig = new IntegerGenerator();
    public <E extends Number> void Create (Collection<E> c){
        for (E e : c){
            
        }
    }
}
