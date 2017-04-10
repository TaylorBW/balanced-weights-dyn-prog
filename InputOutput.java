//InputOutput.java
import java.util.List;

/**
* This class is used to interface with the user and abstract the inner-workings
*     of our program from the user's interaction with it.
*
* @author  Section 2 Cs390k
* @version 0.0.0, 11/09/2016 11:29:00 -6000
*/
public class InputOutput {
    /**
     * Asks the user for the Family of weights to choose from.
     * Ensures that no duplicates are inputted from the user.
     * @return The family of Weights used in our calculation.
     */
    public Family getListOfWeightsFromUser() {
        return new Family();
    }

    /**
     * Asks the user for a total value the output family will add up to. The
     *    total must be a sum of weights.
     * @return A Weight with a total value.
     */
    public Weight getTotalBalanceValueFromUser() {
        return null;
    }

    /**
     * Displays the solution of the minimum value to the user's screen.
     * @param solution the collection of weights that add up to a target
     */
    public void displayBalanceSolution(final List<Weight> solution) {
    }
}
