package Farm;

import java.util.ArrayList;
import java.util.Random;

/**
 * JUnitExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class Chicken {

    public enum Color {
        BROWN, WHITE
    }

    private final Color color;
    private boolean full;

    public Color getColor() {
        return color;
    }

    public Chicken(Color color) {
        this.color = color;
        this.full = true;
    }

    public void feed() {
        this.full = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chicken)) return false;

        Chicken chicken = (Chicken) o;

        if (color != chicken.color) return false;

        return true;
    }

    public Egg[] legeEier() {
        //80%  : 1, 15% : 2, 5% : 3
        double dropChance = new Random().nextDouble();
        ArrayList<Egg> eggs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (i == 1 && dropChance < .8) break;
            if (i == 2 && dropChance < .95) break;

            eggs.add(legeEi());
            this.feed();
        }
        return eggs.toArray(new Egg[0]); //mach ein EggArray aus der ArrayList
    }

    public Egg legeEi() {
        if (full) {
            full = false;
            return new Egg(pickColor());
        }
        return null;
    }

    private Color pickColor() {
        Color eggColor = null;
        double eggColorChance = new Random().nextDouble();

        switch (color) {
            case BROWN:
                eggColor = eggColorChance < .85 ? Color.BROWN : Color.WHITE;
                break;
            case WHITE:
                eggColor = eggColorChance < .85 ? Color.WHITE : Color.BROWN;
                break;
            default:
                throw new Error("Chicken has unexpected and strange color.");
        }
        return null;
    }

}

class Egg {
    final private Chicken.Color color;

    public Egg(Chicken.Color color) {
        this.color = color;
    }

    public Chicken.Color getColor() {
        return color;
    }
}