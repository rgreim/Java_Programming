/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.sequenzdesignpatterns;

import java.util.ArrayList;

/**
 * This class counts the input strings and notifies all observers.
 * 
 * @param input String
 * @author rgreim
 */
public class CountProcessor extends AbstractSequenceProcessor {
    int count = 0;

    @Override
    public void process(String seq) {
        count += 1;
        notifyObservers();
    }

    public int getCount() {
        return count;
    }
 
}
