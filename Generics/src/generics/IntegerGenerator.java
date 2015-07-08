/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Random;


public class IntegerGenerator implements RandomGenerator<Integer> {
    
    private final Random rnd;
    
    public IntegerGenerator(){
        rnd = new Random();
    }
    
    public IntegerGenerator(int seed){
        rnd = new Random(seed);
    }
    
    @Override
    public Integer next(){
        return rnd.nextInt();
    }
    
}
