/**
 * Editier-Distanz - Levenshtein
 *
 * @author R.Greim
 * @version 0.1
 */
public class Sequence {
    private String seq;
    private String seq2;

    public Sequence(String s) {
        this.seq = s;
    }

    public int levdist(Sequence s2) {
        seq2 = s2.getSeq();
        return levenshtein(seq.length(), seq2.length());
    }

    private static int lvd(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        return min(lvd(i - 1, j) + 1,
                lvd(i, j - 1) + 1,
                lvd(i - 1, j - 1) + ((seq.charAt(i - 1) == seq2.charAt(j - 1)) ? 0 : 1));

        return distance;
    }

    public String getSeq() {

        return seq;

    }
}
