package com.example.scout2022;
//TODO replace string to int converter to build in JAVA function (if possible)
/**
 * Utility class.
 *
 * @author Michael Sheehan
 */
public final class Utils {
    private Utils() {
    }

    /**
     * Convert a string to an int.
     *
     * @param val String value to convert to an int.
     * @return Representative value or 0.
     */
    public static int toInt( final String val ) {
        int rVal = 0;
        try {
            rVal = Integer.parseInt( val );
        }
        catch ( final Throwable e ) {
            e.printStackTrace();
        }

        return rVal;
    }
}
