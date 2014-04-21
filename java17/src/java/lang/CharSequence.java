package java.lang;

/**
 * A <tt>CharSequence</tt> is a readable sequence of <code>char</code> values. This
 * interface provides uniform, read-only access to many different kinds of
 * <code>char</code> sequences.
 *
 * @author Mike McCloskey
 * @since 1.4
 * @spec JSR-51
 */

public interface CharSequence {

    /**
     * Returns the length of this character sequence.  
     * The length is the number of 16-bit <code>char</code>s in the sequence.</p>
     *
     * @return  the number of <code>char</code>s in this sequence
     */
    int length();

    /**
     * Returns the <code>char</code> value at the specified index.  
     * An index ranges from zero to <tt>length() - 1</tt>.  
     *
     * @param   index   the index of the <code>char</code> value to be returned
     * @return  the specified <code>char</code> value
     * @throws  IndexOutOfBoundsException
     */
    char charAt(int index);

    /**
     * Returns a new <code>CharSequence</code> that is a subsequence of this sequence.
     *
     * @param   start   the start index, inclusive
     * @param   end     the end index, exclusive
     * @return  the specified subsequence
     * @throws  IndexOutOfBoundsException
     */
    CharSequence subSequence(int start, int end);

    /**
     * Returns a string containing the characters in this sequence in the same order as this sequence.  
     * The length of the string will be the length of this sequence. </p>
     *
     * @return  a string consisting of exactly this sequence of characters
     */
    public String toString();

}
