import static org.junit.Assert.assertTrue;
import org.junit.Test;

    /**
    * Tests for the weight class.
    *
    * @author  Taylor Woehrle
    * @version 1.0
    */
public class WeightTest {

    /**
     * Tests the getValue method using a new weight.
     */
    @Test
    public void constructorAndGetValueTest() {
        Weight testW = new Weight(3);
        assertTrue(testW.getValue() == 3);
    }

    /**
     * Tests the compareTo method using 2 weights.
     */
    @Test
    public void testCompare() {
        Weight testW1 = new Weight(3);
        Weight testW2 = new Weight(5);
        assertTrue(testW1.compareTo(testW2) == -1);
        assertTrue(testW2.compareTo(testW1) == 1);
        assertTrue(testW1.compareTo(testW1) == 0);
    }

    /**
     * Tests the equals method using 2 of same weight.
     */
    @Test
    public void testEquals() {
        Weight testW = new Weight(3);
        assertTrue(testW.equals(testW));
    }
}
