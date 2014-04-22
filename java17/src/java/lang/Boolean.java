package java.lang;

/**
 * The Boolean class wraps a value of the primitive type {@code boolean} in an object. 
 * An object of type {@code Boolean} contains a single field whose type is {@code boolean}.
 *
 * @author  Arthur van Hoff
 * @since   JDK1.0
 */
public final class Boolean implements java.io.Serializable, Comparable<Boolean> {
    /**
     * The {@code Boolean} object corresponding to the primitive
     * value {@code true}.
     */
    public static final Boolean TRUE = new Boolean(true);

    /**
     * The {@code Boolean} object corresponding to the primitive
     * value {@code false}.
     */
    public static final Boolean FALSE = new Boolean(false);

    /**
     * The Class object representing the primitive type boolean.
     *
     * @since   JDK1.1
     */
    public static final Class<Boolean> TYPE = Class.getPrimitiveClass("boolean");

    /**
     * The value of the Boolean.
     *
     * @serial
     */
    private final boolean value;

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -3665804199014368530L;

    /**
     * Allocates a {@code Boolean} object representing the
     * {@code value} argument.
     *
     * @param   value   the value of the {@code Boolean}.
     */
    public Boolean(boolean value) {
        this.value = value;
    }

    /**
     * Allocates a {@code Boolean} object representing the value
     * {@code true} if the string argument is not {@code null}
     * and is equal, ignoring case, to the string {@code "true"}.
     *
     * @param   s   the string to be converted to a {@code Boolean}.
     */
    public Boolean(String s) {
        this(toBoolean(s));
    }

    /**
     * Parses the string argument as a boolean.  The {@code boolean}
     * returned represents the value {@code true} if the string argument
     * is not {@code null} and is equal, ignoring case, to the string
     * {@code "true"}. <p>
     *
     * @param      s   the {@code String} containing the boolean representation to be parsed
     * @return     the boolean represented by the string argument
     * @since 1.5
     */
    public static boolean parseBoolean(String s) {
        return toBoolean(s);
    }

    /**
     * Returns the value of this {@code Boolean} object as a boolean primitive.
     *
     * @return  the primitive {@code boolean} value of this object.
     */
    public boolean booleanValue() {
        return value;
    }

    /**
     * Returns a {@code Boolean} instance representing the specified
     * {@code boolean} value.  If the specified {@code boolean} value
     * is {@code true}, this method returns {@code Boolean.TRUE};
     * if it is {@code false}, this method returns {@code Boolean.FALSE}.
     * If a new {@code Boolean} instance is not required, this method
     * should generally be used in preference to the constructor
     * {@link #Boolean(boolean)}, as this method is likely to yield
     * significantly better space and time performance.
     *
     * @param  b a boolean value.
     * @return a {@code Boolean} instance representing {@code b}.
     * @since  1.4
     */
    public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }

    /**
     * Returns a {@code Boolean} with a value represented by the
     * specified string.  The {@code Boolean} returned represents a
     * true value if the string argument is not {@code null}
     * and is equal, ignoring case, to the string {@code "true"}.
     *
     * @param   s   a string.
     * @return  the {@code Boolean} value represented by the string.
     */
    public static Boolean valueOf(String s) {
        return toBoolean(s) ? TRUE : FALSE;
    }

    /**
     * Returns a {@code String} object representing the specified
     * boolean.  If the specified boolean is {@code true}, then
     * the string {@code "true"} will be returned, otherwise the
     * string {@code "false"} will be returned.
     *
     * @param b the boolean to be converted
     * @return the string representation of the specified {@code boolean}
     * @since 1.4
     */
    public static String toString(boolean b) {
        return b ? "true" : "false";
    }

    /**
     * Returns a {@code String} object representing this Boolean's
     * value.  If this object represents the value {@code true},
     * a string equal to {@code "true"} is returned. Otherwise, a
     * string equal to {@code "false"} is returned.
     *
     * @return  a string representation of this object.
     */
    public String toString() {
        return value ? "true" : "false";
    }

    /**
     * Returns a hash code for this {@code Boolean} object.
     *
     * @return  the integer {@code 1231} if this object represents
     * {@code true}; returns the integer {@code 1237} if this
     * object represents {@code false}.
     */
    public int hashCode() {
        return value ? 1231 : 1237;
    }

    /**
     * Returns {@code true} if and only if the argument is not
     * {@code null} and is a {@code Boolean} object that
     * represents the same {@code boolean} value as this object.
     *
     * @param   obj   the object to compare with.
     * @return  {@code true} if the Boolean objects represent the
     *          same value; {@code false} otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Boolean) {
            return value == ((Boolean)obj).booleanValue();
        }
        return false;
    }

    /**
     * 当且仅当以参数命名的系统属性存在，且等于 "true" 字符串时，才返回 true
     *
     * @param   name   the system property name.
     * @return  the {@code boolean} value of the system property.
     * @see     java.lang.System#getProperty(java.lang.String)
     * @see     java.lang.System#getProperty(java.lang.String, java.lang.String)
     */
    public static boolean getBoolean(String name) {
        boolean result = false;
        try {
            result = toBoolean(System.getProperty(name));
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e) {
        }
        return result;
    }

    /**
     * Compares this {@code Boolean} instance with another.
     *
     * @param   b the {@code Boolean} instance to be compared
     * @return  zero if this object represents the same boolean value as the
     *          argument; a positive value if this object represents true
     *          and the argument represents false; and a negative value if
     *          this object represents false and the argument represents true
     * @throws  NullPointerException if the argument is {@code null}
     * @see     Comparable
     * @since  1.5
     */
    public int compareTo(Boolean b) {
        return compare(this.value, b.value);
    }

    /**
     * Compares two {@code boolean} values.
     * The value returned is identical to what would be returned by:
     * <pre>
     *    Boolean.valueOf(x).compareTo(Boolean.valueOf(y))
     * </pre>
     *
     * @param  x the first {@code boolean} to compare
     * @param  y the second {@code boolean} to compare
     * @return the value {@code 0} if {@code x == y};
     *         a value less than {@code 0} if {@code !x && y}; and
     *         a value greater than {@code 0} if {@code x && !y}
     * @since 1.7
     */
    public static int compare(boolean x, boolean y) {
        return (x == y) ? 0 : (x ? 1 : -1);
    }

    private static boolean toBoolean(String name) {
        return ((name != null) && name.equalsIgnoreCase("true"));
    }
}
