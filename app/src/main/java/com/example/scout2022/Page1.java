package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * creates page
 */
public class Page1 extends Fragment {

    private int TeleOpLowerCargo = 0;
   // private int TeleOpUpperCargo = 0;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }
    /*
    public void decrementAutoBallsLower() {
        decrease(R.id.AutoPowerCellLowerTicker, BundleValues.AUTO_POWERCELL_LOWER, 0);
    }

    public void incrementAutoBallsLower() {
        increase(R.id.AutoPowerCellLowerTicker, BundleValues.AUTO_POWERCELL_LOWER, 25);
    }

    public void decrementAutoBallsOuter() {
        decrease(R.id.AutoPowerCellOuterTicker, BundleValues.AUTO_POWERCELL_OUTER, 0);
    }

    public void incrementAutoBallsOuter() {
        increase(R.id.AutoPowerCellOuterTicker, BundleValues.AUTO_POWERCELL_OUTER, 25);
    }
    public void increase(int id, BundleValues bundleLocation, int limit) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if ( bundle == null ) {
            bundle = new Bundle();
        }

        int variable = bundle.getInt(bundleLocation.toString(), 0);
        if (variable < limit) {
            variable++;
            final TextView displayInteger = findViewById(
                    id);
            displayInteger.setText("" + variable);

            bundle.putInt(bundleLocation.toString(), variable);
            i.putExtras(bundle);
        }

    }

    public void decrease(int id, BundleValues bundleLocation, int limit) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if ( bundle == null ) {
            bundle = new Bundle();
        }

        int variable = bundle.getInt(bundleLocation.toString(), 0);
        if (variable > limit) {
            variable--;
            final TextView displayInteger = findViewById(
                    id);
            displayInteger.setText("" + variable);

            bundle.putInt(bundleLocation.toString(), variable);
            i.putExtras(bundle);
        }

    }
    public void TeleOpLowerDe() {

    }
*/
}