import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
/**
* Tests for the DynamicSolver class.
*
* @author  Taylor Woehrle
* @version 1.0
*/
public class DynamicProgrammingSolverTest {

    @Test
    public void solveTest() {
        Weight total = new Weight(11);
        Family family = new Family();
        family.addWeight(new Weight(1));
        family.addWeight(new Weight(3));
        family.addWeight(new Weight(7));
        Collection<Weight> weightList = new ArrayList<Weight>();
        weightList.add(new Weight(9));
        weightList.add(new Weight(9));
        assertEquals(DynamicProgrammingSolver.minimumWeightCollection(total, family), weightList);
    }

}
