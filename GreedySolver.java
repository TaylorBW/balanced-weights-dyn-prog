import java.util.ArrayList;
//GreedySolver.java
import java.util.Collection;
import java.util.Iterator;

/**
 * Calculates the minimum sized collection of Weights from a given Family that
 * sum to a specified total using the greedy algorithm.
 *
 * @author  Section 2 Cs390k
 * @version $Revision$
 *     ($LastChangedDate$)
 */
public class GreedySolver extends Solver {
    /**
     * Constructs a GreedySolver to generate the minimum sized collection of
     * Weights for a given Family using the greedy algorithm.
     * @param family the Family used to create a minimum sized collection of
     *     Weights for any given total to this GreedySolver
     * @throws IllegalArgumentException if the family is null
     */
    public GreedySolver(final Family family) throws IllegalArgumentException {
        super(family);
    }

    /**
     * Calculates the minimum sized collection of Weights that add up to a
     * specified total using the greedy algorithm where it always picks the
     * largest weights that it can.
     * Note: this might not always come up with the actual smallest sized
     * collection of Weights possible for the given total.
     * @param total the target sum
     * @return the collection representing the minimum sized collection of
     *     Weights that sum to the provided total
     * @throws IllegalArgumentException if the parameter total is null
     */
    public Collection<Weight> minimumWeightCollection(final Weight total)
                                         throws IllegalArgumentException {
        try {
            int totalVal = total.getValue();
            int lastVal =
            getSuperFamilyElement(getSuperFamilySize()).getValue();
            int offset = 0;
            ArrayList<Weight> returnList = new ArrayList<>();
            while (totalVal != 0) {
                if (totalVal - lastVal > 0) {
                    totalVal = totalVal - lastVal;
                    returnList.add(new Weight(lastVal));
                } else if (totalVal - lastVal == 0) {
                    returnList.add(new Weight(lastVal));
                    totalVal = totalVal - lastVal;
                } else {
                    offset++;
                    lastVal = getSuperFamilyElement(getSuperFamilySize()
                                                    - offset).getValue();
                }
            }
        return returnList;
        } catch (IllegalArgumentException e) {
            System.out.println("Greedy Solver error: " + e);
            return null;
        }
    }

    /** Finds the size of a family.
     *@param family the family to find the size of
     *@return the size of the given family
     */
    private static int getFamilySize(final Family family) {
        Iterator<Weight> sizeItr = family.iterator();
        int sizeCount = 0;
        while (sizeItr.hasNext()) {
            sizeItr.next();
            sizeCount++;
        }
        return sizeCount;
    }

    /** Finds an element at a specified index of the super family.
     * @param index the index to be found
     * @param family the family to be found the element in
     * @return the weight at the given index
    */
    private static Weight getFamilyElement(final int index,
                                     final Family family) {
        Iterator<Weight> indexItr = family.iterator();
        Weight returnWeight = new Weight(1);
        for (int i = 0; i < index; i++) {
            returnWeight = indexItr.next();
        }
        return returnWeight;
    }

    /**
     * Utility method to calculate the minimum sized collection of Weights that
     * add up to the specified total using a given Family.
     * @param total the target sum
     * @param family the Family of Weights to use
     * @return The collection representing the minimum sized collection of
     *     Weights that sum to the provided total
     * @throws IllegalArgumentException if the parameters are null
     */
    public static Collection<Weight> minimumWeightCollection(
                     final Weight total, final Family family)
                            throws IllegalArgumentException {
        try {
            int totalVal = total.getValue();
            int lastVal =
                getFamilyElement(getFamilySize(family), family).getValue();
            int offset = 0;
            ArrayList<Weight> returnList = new ArrayList<>();
            while (totalVal != 0) {
                if (totalVal - lastVal > 0) {
                    totalVal = totalVal - lastVal;
                    returnList.add(new Weight(lastVal));
                } else if (totalVal - lastVal == 0) {
                    returnList.add(new Weight(lastVal));
                    totalVal = totalVal - lastVal;
                } else {
                    offset++;
                    lastVal =
                    getFamilyElement(getFamilySize(family)
                    - offset, family).getValue();
                }
            }
            return returnList;
        } catch (IllegalArgumentException e) {
            System.out.println("Greedy Solver Exception: " + e);
            return null;
        }
    }

    /** Finds an element at a specified index of the super family.
     * @param index the index to be found
     * @return the weight at the given index
    */
    private Weight getSuperFamilyElement(final int index) {
        Iterator<Weight> indexItr = super.family().iterator();
        Weight returnWeight = new Weight(1);
        for (int i = 0; i < index; i++) {
            returnWeight = indexItr.next();
        }
        return returnWeight;
    }

    /** Finds the size of the super family.
     * @return the size of the super family
     */
    private int getSuperFamilySize() {
        Iterator<Weight> sizeItr = super.family().iterator();
        int sizeCount = 0;
        while (sizeItr.hasNext()) {
            sizeItr.next();
            sizeCount++;
        }
        return sizeCount;
    }
}
