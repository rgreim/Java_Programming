package Farm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * JUnitExamples
 *
 * @author R.Greim
 * @version 0.1
 */
public class ChickenTest {

    private ArrayList<Chicken> chickHouse;

    @Before
    public void setUp() {
        this.chickHouse = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            chickHouse.add(new Chicken(Chicken.Color.BROWN));
            chickHouse.add(new Chicken(Chicken.Color.WHITE));
        }

    }

    @Test
    public void testEquals() {
        Chicken chickA = new Chicken(Chicken.Color.BROWN);
        Chicken chickB = new Chicken(Chicken.Color.BROWN);
        Chicken chickC = new Chicken(Chicken.Color.WHITE);

        assertTrue("Diese Hühner müssen gleich sein.", chickA.equals(chickB));
        assertFalse("Diese Hühner müssen verschieden sein.", chickA.equals(chickC));
        assertTrue("Dieselben Hühner müssen gleich sein.", chickA.equals(chickA));

        chickB.legeEi();
        assertTrue("Diese Hühner müssen gleich sein.", chickA.equals(chickB));

        assertFalse("Das Huhn und die Kuh dürfen nicht gleich sein.", chickA.equals(new Cow()));
    }

}