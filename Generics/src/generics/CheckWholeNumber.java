/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;


public class CheckWholeNumber<T extends Number> implements Predicate<T> {

    @Override
    public boolean hasProperty(T t) {
        return !(t instanceof Double); 
    }
    
}
