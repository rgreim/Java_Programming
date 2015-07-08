import util.K_mer;
import util.K_merCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Motivsuche
 *
 * @author R.Greim
 * @version 0.1
 */
public class Main {

    private static int kmerLength = 3;

    public static void main(String[] args) {
        List<K_mer> kmerList = new ArrayList<>();
        String file = "/home/rgreim/Uni/Studium - Bioinformatik/Semester 2/Innovative Algorithmen_Teil1/M-BS1-S1ab-ue/gene.fasta";
        String sequence = "";
        String bla = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((bla = in.readLine()) != null) {
                if(!bla.startsWith(">")) {
                    sequence = sequence + bla;
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        K_mer kmer = new K_mer(kmerLength);
        K_merCount kCount = new K_merCount();

        for (K_mer k : kmer){
            kmerList.add(k);
        }


        //for (K_mer k : kmerList){
         //   System.out.println(k.toString());
        //}

        kCount.countKmer(kmerList, sequence, kmerLength);
    }
}
