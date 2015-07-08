/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author rgreim
 * @param <T>
 */
public interface Predicate<T extends Number> {

    public boolean hasProperty(T t);
}
