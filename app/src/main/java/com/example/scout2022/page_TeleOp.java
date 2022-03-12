package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * creates page
 */
public class page_TeleOp extends AppCompatActivity {
    @Nullable
    private int minimumBallCount = 0;
    private int maximumBallCount = 100;
    private boolean CanSeeBool = false;
    private String BarGrabString = BarGrabPosition.NONE.toString();
    MainActivity main = new MainActivity();

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

        CheckBox TeleCanSee = findViewById(R.id.TeleOpColorCheck);

        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        try{
            CanSeeBool = bundle.getBoolean(BundleValues.TeleOpColorCheck.toString());
            BarGrabString = bundle.getString(BundleValues.TeleOpHeightDropdown.toString());
            ((CheckBox) findViewById(R.id.TeleOpColorCheck)).setChecked(CanSeeBool);
            if ( BarGrabString != null ) {
                barHeightSpinner.setSelection( BarGrabPosition.fromValue( BarGrabString ).getIndex() );
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
    }
    public void TeleOpColorCheckUpdate(View view) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        boolean variable;
        CheckBox lineCheckbox = findViewById(R.id.TeleOpColorCheck);
        variable = lineCheckbox.isChecked() ? true : false;
        bundle.putBoolean(BundleValues.TeleOpColorCheck.toString(), variable);
        i.putExtras(bundle);
    }
    /**
     *
     */


    public void decrementTeleOpLower(View view) {
        decrease(R.id.TeleOpLowerTicker, BundleValues.TeleOpLowerTicker, minimumBallCount);
    }

    public void incrementTeleOpLower(View view) {
        increase(R.id.TeleOpLowerTicker, BundleValues.TeleOpLowerTicker, maximumBallCount);
    }

    public void decrementTeleOpUpper(View view) {
        decrease(R.id.TeleOpUpperTicker, BundleValues.TeleOpUpperTicker, minimumBallCount);
    }

    public void incrementTeleOpUpper(View view) {
        increase(R.id.TeleOpUpperTicker, BundleValues.TeleOpUpperTicker, maximumBallCount);
    }

    private void increase(int id, BundleValues bundleLocation, int limit) {
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

    private void decrease(int id, BundleValues bundleLocation, int limit) {
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
   public void TeleOpActivityChange(View view) {
       CheckBox TeleCanSee = findViewById(R.id.TeleOpColorCheck);
       boolean variable;
       variable = TeleCanSee.isChecked() ? true : false;

       final Intent i = new Intent(getApplicationContext(), page_Final.class);
       Bundle bundle = getIntent().getExtras();
       if (bundle == null) {
           bundle = new Bundle();
       }

       bundle.putString( BundleValues.TeleOpHeightDropdown.toString(),
               ((Spinner) findViewById( R.id.TeleOpHeightDropdown )).getSelectedItem().toString() );
       bundle.putBoolean(BundleValues.TeleOpColorCheck.toString(), variable);
       i.putExtras(bundle);

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




