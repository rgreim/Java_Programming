package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Motivsuche
 *
 * @author R.Greim
 * @version 0.1
 */
public class K_merCount {

    public void countKmer(List<K_mer> k_merList, String sequence, int kmerLength) {

        String kmerSub;
        int count = 0;
        Object key = "";
        Map map = new HashMap();
        map.put("bla", 50);
        map.put("bla2", 2);

        for (K_mer k : k_merList) {

            for (int i = 0; i < sequence.length() - kmerLength; i++) {
                kmerSub = sequence.substring(i, kmerLength + i);
                if (k.toString().equals(kmerSub)) {
                    count++;
                }
            }
            map.put(k.toString(), count);
            count = 0;
        }
        Iterator iterator = map.values().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
