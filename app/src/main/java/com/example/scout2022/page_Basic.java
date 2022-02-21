package com.example.scout2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * creates page
 */
<<<<<<< HEAD:app/src/main/java/com/example/scout2022/Page3.java
public class Page3 extends Fragment {

=======
public class page_Basic extends Fragment {
>>>>>>> origin/12-bundlevalues-and-relevant-location-id-updates:app/src/main/java/com/example/scout2022/page_Basic.java
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page3);

        Bundle bundle = getIntent().getExtras();
        try {
            teleLowerCells = bundle.getInt(BundleValues.TeleOpLowerTicker.toString());
            teleOuterCells = bundle.getInt(BundleValues.TELEOP_OUTER_BALLS.toString());
            teleInnerCells = bundle.getInt(BundleValues.TELEOP_INNER_BALLS.toString());
            stageLevel = bundle.getInt(BundleValues.TELEOP_STAGE_LEVEL.toString());
            spinCheck = bundle.getBoolean(BundleValues.TELEOP_SPIN.toString());
            colorCheck = bundle.getBoolean(BundleValues.TELEOP_COLOR.toString());
            trenchCheck = bundle.getBoolean(BundleValues.TELEOP_TRENCH.toString());
            barCheck = bundle.getBoolean(BundleValues.TELEOP_BAR.toString());
            ballPickupCheck = bundle.getBoolean(BundleValues.TElEOP_BALL_PICKUP.toString());
            ((TextView) findViewById(R.id.PowerCellLowerTicker)).setText("" + teleLowerCells);
            ((TextView) findViewById(R.id.PowerCellOuterTicker)).setText("" + teleOuterCells);
            ((TextView) findViewById(R.id.PowerCellInnerTicker)).setText("" + teleInnerCells);
            ((TextView) findViewById(R.id.StageLevelTicker)).setText("" + stageLevel);
            ((CheckBox) findViewById(R.id.SpinCheckbox)).setChecked(spinCheck);
            ((CheckBox) findViewById(R.id.ColorCheckbox)).setChecked(colorCheck);
            ((CheckBox) findViewById(R.id.TrenchCheckbox)).setChecked(trenchCheck);
            ((CheckBox) findViewById(R.id.StronkWheelCheckbox)).setChecked(barCheck);
            ((CheckBox) findViewById(R.id.BallPickupCheckbox)).setChecked(ballPickupCheck);

        } catch(Throwable t) {
            t.printStackTrace();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }

<<<<<<< HEAD:app/src/main/java/com/example/scout2022/Page3.java
    public void TeleOpLowerIn(){
        increase(R.id.AutoLowerTicker, BundleValues.TeleOpLowerTicker);
    }


    public void increase(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
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
=======
>>>>>>> origin/12-bundlevalues-and-relevant-location-id-updates:app/src/main/java/com/example/scout2022/page_Basic.java
}