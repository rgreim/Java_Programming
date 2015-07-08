/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataformats;


/**
 *
 * @author rgreim
 */
public class Main {

    public static void main(String[] args) {
     Parser parserfastq = new ParserFastq();
        parserfastq.parse(args[0]);
     ParserFasta parserfasta = new ParserFasta();
     parserfastq.parse(args[0]);
    }

}
