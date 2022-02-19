package com.example.scout2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * creates page
 */
public class page_TeleOp extends Fragment {

private int minimumBallCount = 0;
private int maximumBallCount = 100;
private Utils Util = new Utils();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Util = new Utils();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page3, container, false);


            }

/*
   findViewById(R.id.TeleOpLowerMinus).setOnClickListener(() -> decrementTeleOpLower());

   findViewById(R.id.TeleOpLowerPlus).setOnClickListener(() -> incrementTeleOpLower());

   findViewById(R.id.TeleOpUpperMinus).setOnClickListener(() -> decrementTeleOpUpper());

   findViewById(R.id.TeleOpUpperPlus).setOnClickListener(() -> incrementTeleOpUpper());
*/
    /**
     * Lower TeleOp Score Counter
     */
   /* public void decrementTeleOpLower(View view) {
        Util.decrease(R.id.TeleOpLowerTicker, BundleValues.TeleOpLowerCounter, minimumBallCount);
    }

    public void incrementTeleOpLower(View TeleOpLowerPlus) {
        Util.increase(R.id.TeleOpLowerTicker, BundleValues.TeleOpLowerCounter, maximumBallCount);
    }
*/

    /**
     * Upper TeleOp Score Counter
     */

    public void decrementTeleOpUpper(View view) {
       // Util.decrease(R.id.TeleOpUpperTicker, BundleValues.TeleOpUpperCounter, minimumBallCount);
    }
    public void incrementTeleOpUpper(View view) {
        //Util.increase(R.id.TeleOpUpperTicker, BundleValues.TeleOpUpperCounter, maximumBallCount);
    }
   /*
   //TODO replace into other increase decrease
    private void decrease(int teleOpUpperTicker, BundleValues teleOpUpperCounter, int minimumBallCount) {
    }



    private void increase(int teleOpUpperTicker, BundleValues teleOpUpperCounter, int maximumBallCount) {
    }
*/
    /* TODO note to self, is using onclick easier?
    public void TeleOpLowerDe (View view){
    }

     */
}




