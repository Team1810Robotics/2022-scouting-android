package com.example.scout2022;
//TODO replace string to int converter to build in JAVA function (if possible)
/*
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
*/
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
    private Utils() {
    }

    public void increase(int id, BundleValues bundleLocation, int limit) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        int variable = bundle.getInt(bundleLocation.toString(), 0);
        if (variable < limit) {
            variable++;
            final TextView displayInteger = findViewById(id);
            displayInteger.setText("" + variable);

            bundle.putInt(bundleLocation.toString(), variable);
            i.putExtras(bundle);
        }

    }

    public void decrease(int id, BundleValues bundleLocation, int limit) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        int variable = bundle.getInt(bundleLocation.toString(), 0);
        if (variable > limit) {
            variable--;
            final TextView textView = findViewById(id);
            textView.setText("" + variable);

            bundle.putInt(bundleLocation.toString(), variable);
            i.putExtras(bundle);
        }

    }



   /*start of increase/decrease function
    _increase = (Button) findViewById(R.id.TeleOpLowerPlus);
    _decrease = (Button) findViewById(R.id.TeleOpLowerMinus);
    _view = (TextView) findViewById(R.id.TeleOpLowerTicker);


        _increase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            teleLowerCounter++;
            _string = Integer.toString(_counter);
            try {
                _view.setText(_string);
            } catch (final Throwable t) {
                t.printStackTrace();
            }
        }
    });
    */ //end of function
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


}
