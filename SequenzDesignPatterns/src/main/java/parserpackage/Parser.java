/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserpackage;

import java.io.BufferedReader;

import java.util.Iterator;


/**
 * Parses a .fastq file and extracts only the sequence.
 *
 * @author rgreim
 */
public abstract class Parser implements Iterator {

    BufferedReader in;

    public abstract void parse(String filepath);
      

    @Override
    public abstract boolean hasNext();

    @Override
    public abstract String next();

}
