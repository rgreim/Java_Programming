/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author rgreim
 */
public class CheckEveness implements Predicate<Integer>{


    @Override
    public boolean hasProperty(Integer t) {
            return t%2 != 0;
    }
}
