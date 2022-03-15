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
public class page_Auto extends AppCompatActivity {
    @Nullable
    MainActivity main = new MainActivity();
    private int minimumBallCount = 0;
    private int maximumBallCount = 100;
    private boolean CanMoveBool = false;
    private String AutoCapacityString = AutoCapacity.NONE.toString();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page2);

        CheckBox AutoCanMove = findViewById(R.id.AutoTarmacCheckBox);

        final Intent i = getIntent();
        Bundle bundle = i.getExtras();

        //CapacityDropdown
        final Spinner capacitySpinner = findViewById(R.id.AutoBallsHeld);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.capacity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        capacitySpinner.setAdapter(adapter);

        capacitySpinner.setOnItemSelectedListener
                (new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(final AdapterView<?> parentView, final View selectedItemView, final int position, final long id) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.AutoBallsHeld.toString(),
                                ((Spinner) findViewById(R.id.AutoBallsHeld)).getSelectedItem().toString());
                        i.putExtras(bundle);
                    }

                    @Override
                    public void onNothingSelected(final AdapterView<?> parentView) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.AutoBallsHeld.toString(), AutoCapacity.NONE.getLabel());
                        i.putExtras(bundle);
                    }
                });
        try {
            CanMoveBool = bundle.getBoolean(BundleValues.AutoCanMove.toString());
            AutoCapacityString = bundle.getString(BundleValues.AutoBallsHeld.toString());
            if (AutoCapacityString != null) {
                capacitySpinner.setSelection(AutoCapacity.fromValue(AutoCapacityString).getIndex());
                ((CheckBox) findViewById(R.id.AutoTarmacCheckBox)).setChecked(CanMoveBool);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void decrementAutoLower(View view) {
        decrease(R.id.AutoLowerTicker, BundleValues.AutoLowerTicker, minimumBallCount);
    }

    public void incrementAutoLower(View view) {
        increase(R.id.AutoLowerTicker, BundleValues.AutoLowerTicker, maximumBallCount);
    }

    public void decrementAutoUpper(View view) {
        decrease(R.id.AutoUpperTicker, BundleValues.AutoUpperTicker, minimumBallCount);
    }

    public void incrementAutoUpper(View view) {
        increase(R.id.AutoUpperTicker, BundleValues.AutoUpperTicker, maximumBallCount);
    }

    public void AutoActivityChange(View view) {
        CheckBox AutoCanMove = findViewById(R.id.AutoTarmacCheckBox);
        boolean variable;
        variable = AutoCanMove.isChecked() ? true : false;

        final Intent i = new Intent(getApplicationContext(), page_TeleOp.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean(BundleValues.AutoCanMove.toString(), variable);
        bundle.putString( BundleValues.AutoBallsHeld.toString(),
                ((Spinner) findViewById( R.id.AutoBallsHeld )).getSelectedItem().toString() );
        i.putExtras(bundle);
        startActivity(i);
    }

    public void AutoTarmacCheckBoxUpdate(View view) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        boolean variable;
        CheckBox lineCheckbox = findViewById(R.id.AutoTarmacCheckBox);
        variable = lineCheckbox.isChecked() ? true : false;
        bundle.putBoolean(BundleValues.AutoCanMove.toString(), variable);
        i.putExtras(bundle);
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
    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), page_Basic.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}
