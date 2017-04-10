import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;
/**
* Tests for the family class.
*
* @author  Taylor Woehrle
* @version 1.0
*/
public class FamilyTest {

    /**
    * tests for sorting
    */
    @Test
    public void testSorting() {
        ArrayList<Weight> testWList = new ArrayList<Weight>();
        testWList.add(new Weight(1));
        testWList.add(new Weight(4));
        testWList.add(new Weight(5));
        Family sortFam = new Family();
        sortFam.addWeight(new Weight(4));
        sortFam.addWeight(new Weight(1));
        sortFam.addWeight(new Weight(5));
        Iterator<Weight> itr = sortFam.iterator();
        for (int i = 0; i < testWList.size(); i++) {
             assertEquals(testWList.get(i).getValue(), itr.next().getValue());
        }
    }

    /**
     * Tests empty constructor inserts weight 1
     * and the getIterator method.
     */
    @Test
    public void testEmptyConstruct() {
        Family testFam = new Family();
        Iterator<Weight> itr = testFam.iterator();
        while (itr.hasNext()) {
             assertEquals(new Weight(1).getValue(), itr.next().getValue());
        }
    }

    /**
     * Tests the parameterized constructor inserts the weight 1.
     */
    @Test
    public void paramConstruct() {
        Collection<Weight> weights = new ArrayList<>();
        weights.add(new Weight(2));
        weights.add(new Weight(3));
        Family testFam = new Family(weights);
        ArrayList<Weight> testWList = new ArrayList<Weight>();
        testWList.add(new Weight(1));
        testWList.add(new Weight(2));
        testWList.add(new Weight(3));
        Iterator<Weight> itr = testFam.iterator();
        for (int i = 0; i < testWList.size(); i++) {
             assertEquals(testWList.get(i).getValue(), itr.next().getValue());
        }
    }

    /**
     * Tests the addWeight method.
     */
    @Test
    public void addWeightTest() {
        Collection<Weight> weights = new ArrayList<>();
        Family testFam = new Family(weights);
        testFam.addWeight(new Weight(1));
        testFam.addWeight(new Weight(2));
        testFam.addWeight(new Weight(2));
        testFam.addWeight(new Weight(3));
        ArrayList<Weight> testWList = new ArrayList<Weight>();
        testWList.add(new Weight(1));
        testWList.add(new Weight(2));
        testWList.add(new Weight(3));
        Iterator<Weight> itr = testFam.iterator();
        for (int i = 0; i < testWList.size(); i++) {
             assertEquals(testWList.get(i).getValue(), itr.next().getValue());
        }
    }

    /**
     * Tests the removeWeight method.
     */
    @Test
    public void removeWeightTest() {
        Collection<Weight> weights = new ArrayList<>();
        Family testFam = new Family(weights);
        testFam.addWeight(new Weight(1));
        testFam.addWeight(new Weight(2));
        testFam.addWeight(new Weight(3));
        testFam.addWeight(new Weight(4));
        testFam.removeWeight(new Weight(3));
        ArrayList<Weight> testWList = new ArrayList<Weight>();
        testWList.add(new Weight(1));
        testWList.add(new Weight(2));
        testWList.add(new Weight(4));
        Iterator<Weight> itr = testFam.iterator();
        for (int i = 0; i < testWList.size(); i++) {
             assertEquals(testWList.get(i).getValue(), itr.next().getValue());
        }
    }
}
