//RecursiveSolver.java
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
* Calculates the minimum sized collection of Weights from a given Family that
* sum to a specified total using the Recursive algorithm.
*
* @author    Section 2 Cs390k, Taylor Woehrle
* @version 0.1.0
*         ($LastChangedDate: 11/20/16 8:21pm $)
*/
public class RecursiveSolver extends Solver {
    /**Holds smallest family size.*/
    private int smallestSize = Integer.MAX_VALUE;
    /**Holds list of solved weights.*/
    private ArrayList<Weight> smallestList = new ArrayList<>();

    /**
     * Constructs a RecursiveSolver to generate the minimum sized collection of
     * Weights for a given Family using the Recursive algorithm.
     * @param family the Family used to create a minimum sized collection of
     *         Weights for any given total to this RecursiveSolver
     * @throws IllegalArgumentException if the family is null
     */
    public RecursiveSolver(final Family family)
                      throws IllegalArgumentException {
            super(family);
    }

    /**
     * Calculates the minimum sized collection of Weights that add up to a
     * specified total using the Recursive algorithm where it uses recursion
     * to solve for the minimum sized weight collection.
     * note: does not use a memo table
     * @param total the target sum
     * @return the collection representing the minimum sized collection of
     *         Weights that sum to the provided total
     * @throws IllegalArgumentException if the parameter total is null
     */
    public Collection<Weight> minimumWeightCollection(
                                   final Weight total)
                     throws IllegalArgumentException {
        try {
            for (int i = 0; i < getSuperFamilySize(); i++) {
                Weight parentWeight = getSuperFamilyElemenet(i);
                if (total.getValue() - parentWeight.getValue() >= 0) {
                    ArrayList<Weight> blankList = new ArrayList<>();
                    recursiveSolve(parentWeight, blankList, total.getValue());
                }
            }
            return this.smallestList;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**recursive method to solve for minimum sized family.
    *@return returns a boolean of if the problem was solved
    * @param inWeight the weight that goes into the solving
    * @param priorWeights the weights that solve the problem
    * @param totalValue the remaining part of the total
    */
    private boolean recursiveSolve(final Weight inWeight,
             final ArrayList<Weight> priorWeights, int totalValue) {
        ArrayList<Weight> currentWeightList = priorWeights;
        ArrayList<Weight> possibleOtherWeights = findLEList(inWeight);
        //base case 1
        if (inWeight.getValue() == 1) {
            for (int i = 0; i < totalValue; i++) {
                currentWeightList.add(new Weight(1));
            }
            setIfSmallest(currentWeightList);
            return true;
        //base case 2
        } else if (totalValue - inWeight.getValue() == 0) {
            currentWeightList.add(inWeight);
            setIfSmallest(currentWeightList);
            return true;
        //else if recursion is needed for further reduction
        } else if (totalValue - inWeight.getValue() > 0) {
            currentWeightList.add(inWeight);
            totalValue = totalValue - inWeight.getValue(); //reduction
            for (int i = 0; i < possibleOtherWeights.size(); i++) {
                recursiveSolve(possibleOtherWeights.get(i),
                            currentWeightList, totalValue);
            }
            return false;
        //else stop recursion
        } else {
            return false;
        }
    }

    /** Sets a new smallestList and smallestSize
     * if input size is smaller.
     * @param candidateList a potential minimum weight solution list
     */
    private void setIfSmallest(final ArrayList<Weight> candidateList) {
        if (candidateList.size() < this.smallestSize) {
            this.smallestList = candidateList;
            this.smallestSize = candidateList.size();
        }
    }

    /** Finds an element at a specified index of the super family.
     * @param index the index to be found
     * @return the weight at the given index
    */
    private Weight getSuperFamilyElemenet(final int index) {
        Iterator<Weight> indexItr = super.family().iterator();
        for (int i = 0; i < index; i++) {
            indexItr.next();
        }
        return indexItr.next();
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

    /** Finds all the weights that are less than or equal to the input weight.
     * @param inWeight the weight to see what is less than or equal to
     * @return the array list of weights from the family
     * that are less than or equal to
     * the inWeight
     */
    private ArrayList<Weight> findLEList(final Weight inWeight) {
        Iterator<Weight> leItr = super.family().iterator();
        ArrayList<Weight> leList = new ArrayList<>();
        if (inWeight.getValue() == 1) {
            leList.add(new Weight(1));
            return leList;
        }
        while (leItr.hasNext()) {
            Weight candidateWeight = leItr.next();
            if (candidateWeight.getValue() <= inWeight.getValue()) {
                leList.add(candidateWeight);
            }
        }
        return leList;
    }

    /**
     * Utility method to calculate the minimum sized collection of Weights that
     * add up to the specified total using a given Family.
     * @param total the target sum
     * @param family the Family of Weights to use
     * @return The collection representing the minimum sized collection of
     *         Weights that sum to the provided total
     * @throws IllegalArgumentException if the parameters are null
     */
    public static Collection<Weight> minimumWeightCollection(
                    final Weight total, final Family family)
                    throws IllegalArgumentException {
        return null;
    }

}
