package com.example.scout2022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

/*
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);
 */
/**
 * creates page
 */
public class page_Basic extends Activity {
    @Nullable
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page1);
//Color dropdown
        final Spinner colorSpinner = findViewById( R.id.BasicColorDropdown );
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                ( this, R.array.alliance_Colors, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        colorSpinner.setAdapter( adapter );

        colorSpinner.setOnItemSelectedListener
                ( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(final AdapterView<?> parentView, final View selectedItemView, final int position, final long id) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.BasicColorDropdown.toString(),
                                ((Spinner) findViewById(R.id.BasicColorDropdown)).getSelectedItem().toString());
                        i.putExtras(bundle);
                    }

                    @Override
                    public void onNothingSelected(final AdapterView<?> parentView) {
                        final Intent i = getIntent();
                        Bundle bundle = i.getExtras();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }

                        bundle.putString(BundleValues.BasicColorDropdown.toString(), BarGrabPosition.NONE.getLabel());
                        i.putExtras(bundle);
                    }
                });
    }
    public void BasicActivityChange(View view) {
        final Intent i = new Intent(getApplicationContext(), page_TeleOp.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        i.putExtras(bundle);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), MainActivity.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}