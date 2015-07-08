/**
 * Levenshtein_OOP
 *
 * @author R.Greim
 * @version 0.1
 */
public class Main {

    public static void main(String[] args) {
        Sequence s1 = new Sequence(s);
        Sequence s2 = new Sequence(t);
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        String seq1 = in.readLine();
        String seq2 = in.readLine();
        s1.setSequence(seq1);
        s2.setSequence(seq2);
        int levenshtein = s1.levdist(s2);
        System.out.println(levenshtein);
    }
}
