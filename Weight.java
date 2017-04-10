//Weight.java
/**
* Represents a balance weight with a weight value of 1 or greater.
*
* @author  Section 2 Cs390k
* @version 1.0.0
*    ($LastChangedDate: 2016-11-20 1:40pm$)
*/
public class Weight implements Comparable<Weight> {
    /**holds the weight value.*/
    private int weightValue;

    /**
    * Constructs a Weight with a weight value of 1 or greater.
    * @param value a representation of a weight's value.
    * @throws IllegalArgumentException if parameter is null or has a
    * value equal to or less than 0
    */
    Weight(final Integer value) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException("Weight error: value <= 0");
        }
        try {
            this.weightValue = value;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("invalid arguement");
        }
    }

    /**
    * Retrieves the value of this weight.
    * @return The Integer value of this Weight.
    */
    public Integer getValue() {
        return this.weightValue;
    }

    /**
     * Compares this Weight with the parameter for order.
     * Returns a negative integer, zero, or a positive integer
     * as this object is less than, equal to, or greater than
     * the specified object. Comparison considers value only;
     * null is considered to be lower than any other value.
     * <P>
     * Ensures that sgn(x.compareTo(y)) == - sgn(y.compareTo(x))
     * for all x and y. (This implies that x.compareTo(y) must
     * throw an exception if and only if y.compareTo(x) throws an exception.)
     * </P><P>
     * The relation is transitive: (x.compareTo(y) > 0 && y.compareTo(z) > 0)
     * implies x.compareTo(z) > 0.
     * </P><P>
     * Ensures that x.compareTo(y)==0 implies that
     * sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
     * </P><P>
     * The natural ordering is consistent with equals, that is,
     * (x.compareTo(y)==0 == (x.equals(y)).
     * </P>
     * In the foregoing description, the notation sgn(expression)
     * designates the mathematical signum function, which is defined
     * to return one of -1, 0, or 1 according to whether the value of
     * expression is negative, zero or positive.
     * @param w the object to be compared
     * @return a negative integer, zero, or a positive integer as this
     *     object is less than, equal to, or greater than the specified object.
    */
    public int compareTo(final Weight w) {
        int weightDifference = this.weightValue - w.getValue();
        if (weightDifference > 0) {
            return 1;
        } else if (weightDifference < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference object with which to compare
     * @return true if and only if
     *  <ul>
     *    <li>both are non-null</li>
     *    <li>both have the same value</li>
     *  </ul>
     * @see #hashCode()
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Weight) {
            if (((Weight) obj).getValue() == this.weightValue) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Returns a hash code value for this Weight. Should ensure that if two
     * Weights x,y:
     * x.equals(y) is true, then x.hashcode() == y.hashcode() is true.
     * @return a hash code value for this Weight.
     * @see #equals(Object o)
     */
    @Override
    public int hashCode() {
        return (this.weightValue);
    }

    /**
     * Renders the Weight as a non-null and non-empty String.
     * The string shall take the format:
     * <P>
     * 1
     * </P>
     * Where 1 is the numerical value of this Weight.
     * @return string rendering of this object
     */
    @Override
    public String toString() {
        return ("" + this.weightValue);
    }
}
