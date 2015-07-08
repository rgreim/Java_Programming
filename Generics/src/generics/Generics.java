/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rgreim
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Double> liste = new ArrayList<>();
        liste.add(new Double(0));
        
        liste.add(20d);
        
        //Zugriff auf alle Elemente der Liste
        for (Double zahl : liste) {
        }
    }
    
}
