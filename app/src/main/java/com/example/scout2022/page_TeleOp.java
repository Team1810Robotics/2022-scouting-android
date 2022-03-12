package com.example.scout2022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

/**
 * creates page
 */
public class page_TeleOp extends Activity {
    @Nullable
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page3);

        //BarHeightDropdown
        final Spinner barHeightSpinner = findViewById( R.id.TeleOpHeightDropdown );
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                ( this, R.array.height, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        barHeightSpinner.setAdapter( adapter );

        barHeightSpinner.setOnItemSelectedListener
                ( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(final AdapterView<?> parentView, final View selectedItemView, final int position, final long id) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.TeleOpHeightDropdown.toString(),
                                ((Spinner) findViewById(R.id.TeleOpHeightDropdown)).getSelectedItem().toString());
                        i.putExtras(bundle);
                    }

                    @Override
                    public void onNothingSelected(final AdapterView<?> parentView) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.TeleOpHeightDropdown.toString(), BarGrabPosition.NONE.getLabel());
                        i.putExtras(bundle);
                    }
                });


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
   public void TeleOpActivityChange(View view) {
       final Intent i = new Intent(getApplicationContext(), page_Final.class);
       Bundle bundle = getIntent().getExtras();
       if (bundle == null) {
           bundle = new Bundle();
       }

       i.putExtras(bundle);
       startActivity(i);
   }

    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), page_Auto.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}




