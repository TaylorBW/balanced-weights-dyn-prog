//Family.java
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
* Represents a collection of weights, the weights must have unique values
* and the collection must contain the weight with the value equal to 1.
*
* @author  Section 2 Cs390k, Taylor
* @version 1.0.0
*     ($LastChangedDate: 2016-11-20 1:40pm$)
*/
public class Family implements Iterable<Weight> {
    /**holds the weight values of the family.*/
    private Collection<Weight> weightList = new ArrayList<Weight>();

    /**
     * Constructs a Family containing a single Weight with a value of 1.
     */
    Family() {
        this.weightList = new ArrayList<>();
        this.weightList.add(new Weight(1));
    }

    /**
     * Constructs a Family composed of Weights from the parameter. The
     * resulting Family contains no duplicate Weights and has the required
     * Weight with value 1.
     * @param weights the Weights to be included in this family. Allowed to
     *    contain duplicates and omit the required Weight with value 1
     * @throws IllegalArgumentException if any of the collection elements
     *    are null.
     */
    Family(final Collection<Weight> weights) throws IllegalArgumentException {
        try {
            this.weightList.add(new Weight(1));
            for (int i = 0; i < weights.size(); i++) {
                if (!weightList.contains(((ArrayList<Weight>) weights)
                                                           .get(i))) {
                    weightList.add(((ArrayList<Weight>) weights).get(i));
                }
           }
            Collections.sort((List<Weight>) this.weightList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Null argument");
        }
    }

    /**
     * Adds a weight to this Family.
     * @param weight the Weight to be added
     * @return true if and only if the parameter is not null and
     *         a Weight with the same value does not already exist
     *         in the Family; false otherwise
     * @throws IllegalArgumentException if value is null
     */
    public boolean addWeight(final Weight weight) throws
        IllegalArgumentException {
        try {
            for (int i = 0; i < weightList.size(); i++) {
                  if (((ArrayList<Weight>) weightList).get(i)
                          .getValue() == weight.getValue()) {
                      return false;
                  }
            }
            weightList.add(weight);
            Collections.sort((List<Weight>) this.weightList);
            return true;
        } catch (IllegalArgumentException e) {
               throw new IllegalArgumentException("Null argument");
        }
    }

    /**
     * Removes a Weight from this Family whose value is equal to
     *    that of the parameter.
     * Returns true if the state of this Family was changed.
     * If a weight with the same value as the parameter does not
     *   already exist in the current family, the return value is false.
     * If the value of the Weight parameter is 1, no weights will be
     *     removed from this family.
     * @param valueWeight a Weight representing the value to be removed
     * @return true if a corresponding Weight exists in this Family
     *         and that Weight was removed; false otherwise (e.g., if the
     *        parameter has value of 1, or is not contained in the Family).
     * @throws IllegalArgumentException if the parameter is null
     */
    public boolean removeWeight(final Weight valueWeight) throws
        IllegalArgumentException {
        try {
            for (int i = 0; i < weightList.size(); i++) {
                  if (((ArrayList<Weight>) weightList)
                      .get(i).getValue() == valueWeight.getValue()) {
                      if (((ArrayList<Weight>) weightList)
                                     .get(i).getValue() >= 1) {
                          ((ArrayList<Weight>) weightList)
                                          .remove(i);
                          return true;
                      }
                  }
            }
            return false;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Null argument");
        }
    }

    /**
     * Returns an iterator over the elements of this Family.
     * The iterator returns the elements in their natural order.
     * @return an Iterator.
    */
    @Override
    public java.util.Iterator<Weight> iterator() {
        Collections.sort((List<Weight>) this.weightList);
        return this.weightList.iterator();
    }


    /**
     * Renders the Family as a non-null and non-empty string.
     * The string shall take the format:
     * <P>
     * [1, 2, 5, 6]
     * </P>
     * where the Weights within the family are listed in ascending order.
     * @return string rendering of this object
     */
    @Override
    public String toString() {
        ArrayList<Integer> toStringList = new ArrayList<Integer>();
        for (int i = 0; i < weightList.size(); i++) {
            toStringList.add(((ArrayList<Weight>) weightList)
                                         .get(i).getValue());
        }
        Collections.sort(toStringList);
        String returnString = "[";
        for (int i = 0; i < toStringList.size(); i++) {
             returnString = (returnString + toStringList.get(i) + "  ");
        }
        return returnString + " ]";
    }
}
