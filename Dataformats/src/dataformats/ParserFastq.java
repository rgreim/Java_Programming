/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataformats;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author rgreim
 */
public class ParserFastq extends Parser {

    @Override
    public void parse(String filepath) {
        
        Path path = Paths.get(filepath);

        if (filepath.endsWith(".gzip")) {

            try {

                GZIPInputStream gzin = new GZIPInputStream(new FileInputStream(filepath));
                Reader dec = new InputStreamReader(gzin);
                in = new BufferedReader(dec);

            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (filepath.endsWith(".fastq")) {

            try {

                in = Files.newBufferedReader(path);

            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            System.out.println("Neither a .gzip file nor a .fastq file could be found.");
        }

        while (hasNext()) {
            System.out.println(next());
        }

        try {

            in.close();

        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean hasNext() {
        
        try {
            return (in.readLine() != null);

        } catch (IOException ex) {
            Logger.getLogger(Parser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public String next() {
        String sequence = null;
        
        try {
            sequence = in.readLine();
            String garbage1 = in.readLine();
            String garbage2 = in.readLine();

        } catch (IOException ex) {
            Logger.getLogger(Parser.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
        return sequence;
    }
    
}
