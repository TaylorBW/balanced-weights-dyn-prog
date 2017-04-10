//Solver.java
import java.util.Collection;

/**
* Calculates the minimum sized collection of Weights from a given Family that
* sum to a specified total.
*
* @author  Section 2 Cs390k
* @version $Revision: 414 $
*     ($LastChangedDate: 2016-11-11 11:47:24 -0700 (Fri, 11 Nov 2016) $)
*/
public abstract class Solver {
    /**Holds the family for the solver.*/
    private static Family solverFamily = new Family();

    /**
     * Constructs a solver to generate the minimum sized collection of Weights
     * for a given Family.
     * @param family the Family used to create a minimum sized collection of
     *     Weights for any given total to this Solver
     * @throws IllegalArgumentException if the family is null
     */
    public Solver(final Family family) throws IllegalArgumentException {
        if (family == null) {
            throw new IllegalArgumentException();
        } else {
            this.solverFamily = family;
        }
    }

    /**
     * Returns the Family associated with this Solver. An accessor provided
     * @return the Family associated with this Solver
     */
    protected Family family() {
        return this.solverFamily;
    }

    /**
     * Calculates the minimum sized collection of Weights that add up to a
     * specified total using this Solver's Family.
     * @param total the target sum
     * @return the collection representing the minimum sized collection of
     *     Weights that sum to the provided total
     * @throws IllegalArgumentException if the parameter total is null
     */
    public abstract Collection<Weight> minimumWeightCollection(
        final Weight total)
        throws IllegalArgumentException;
}
