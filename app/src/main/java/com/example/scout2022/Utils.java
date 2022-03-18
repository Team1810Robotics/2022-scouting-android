package com.example.scout2022;
//TODO replace string to int converter to build in JAVA function (if possible)

import androidx.appcompat.app.AppCompatActivity;
/**
 * Utility class.
 *
 * @author Michael Sheehan
 */
public final class Utils extends AppCompatActivity {


    /**
     * Defining variables for increase and decrease
     * <p>
     * private Button _decrease; //Decrease Button
     * private Button _increase; //Increase Button
     * private TextView _view; //Textview
     * private static int _counter; //Counter
     * private String _string; //String
     */
    public Utils() {
    }

    /**
     * Convert a string to an int.
     *
     * @param val String value to convert to an int.
     * @return Representative value or 0.
     */
    public static int toInt(final String val) {
        int rVal = 0;
        try {
            rVal = Integer.parseInt(val);
        } catch (final Throwable e) {
            e.printStackTrace();
        }

        return rVal;
    }
//Poor attempt to make notes work below... Sorry...
    public static int toStrings(final String txt) {
        int rVal = 0;
        try {
            rVal = Integer.parseInt(txt);
        } catch (final Throwable e) {
            e.printStackTrace();
        }

        return 2;
    }
}
