import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
/**
* Tests for the GreedySolver class.
*
* @author  Taylor Woehrle
* @version 1.0
*/
public class GreedySolverTest {


    /**Simple 2 weight Family weight test.
     *
     */
    @Test
    public void twoWeightFamilyTest() {
        Weight total = new Weight(13);
        Family family = new Family();
        family.addWeight(new Weight(10));
        Collection<Weight> weightList = new ArrayList<Weight>();
        weightList.add(new Weight(10));
        weightList.add(new Weight(1));
        weightList.add(new Weight(1));
        weightList.add(new Weight(1));
        GreedySolver testSolver = new GreedySolver(family);
        assertEquals(testSolver.minimumWeightCollection(total), weightList);
    }

    /**
     * Tests the method that uses both total and a defined family.
     */
    @Test
    public void solveTest() {
        Weight total = new Weight(11);
        Family family = new Family();
        family.addWeight(new Weight(1));
        family.addWeight(new Weight(3));
        family.addWeight(new Weight(7));
        Collection<Weight> weightList = new ArrayList<Weight>();
        weightList.add(new Weight(7));
        weightList.add(new Weight(3));
        weightList.add(new Weight(1));
        assertEquals(GreedySolver.minimumWeightCollection(total, family), weightList);
    }

    /**Tests the method that takes only the total as a parameter.
     *
     */
    @Test
    public void tripleWeightFamilyTest() {
        Weight total = new Weight(16);
        Family family = new Family();
        family.addWeight(new Weight(1));
        family.addWeight(new Weight(5));
        family.addWeight(new Weight(10));
        GreedySolver testSolver = new GreedySolver(family);
        Collection<Weight> weightList = new ArrayList<Weight>();
        weightList.add(new Weight(10));
        weightList.add(new Weight(5));
        weightList.add(new Weight(1));
        assertEquals(testSolver.minimumWeightCollection(total), weightList);
    }

}
