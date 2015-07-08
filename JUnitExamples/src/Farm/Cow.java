package Farm;

/**
 * JUnitExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class Cow {
    final private String ton = "Muh!";
    final private String tonGesund = ton;
    final private String tonKrank = "Muuuuuuuh!";

    private boolean krank = false;

    public Cow() {
        this(false);
    }

    public Cow(boolean krank) {
        this.krank = krank;
    }

    public String muh(){
        if (krank) {
            return tonKrank;
        }
        else {
            return tonGesund;
        }
    }
}
