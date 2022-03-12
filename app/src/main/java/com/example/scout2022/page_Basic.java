package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);
 */
/**
 * creates page
 */
public class page_Basic extends AppCompatActivity {
    //initializing variables that will be set as the bundle values
    private String BasicTeamString = TeamNumbers.TEAM_1810.toString();
    private int BasicRoundInt = 0;
    private String BasicColorString = TeamColors.NONE_SELECTED.toString();


    @Nullable
    MainActivity main = new MainActivity();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page1);
        //Color dropdown
        final Spinner colorSpinner = findViewById( R.id.BasicColorDropdown );
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
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                ( this, R.array.alliance_Colors, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        colorSpinner.setAdapter( adapter );
        EditText TeamNum = findViewById(R.id.BasicTeamNum);
        EditText RoundNum = findViewById(R.id.BasicRoundNum);
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
      try{
          BasicTeamString = bundle.getString(BundleValues.BasicTeamNum.toString());
          BasicRoundInt = bundle.getInt(BundleValues.BasicRoundNum.toString());
          BasicColorString = bundle.getString(BundleValues.BasicColorDropdown.toString());
          System.out.println("Startup" + BasicTeamString);
          ((TextView) findViewById(R.id.BasicTeamNum)).setText(BasicTeamString);
          ((TextView) findViewById(R.id.BasicRoundNum)).setText(BasicRoundInt);
          colorSpinner.setSelection(TeamColors.valueOf(BasicColorString).getIndex());
      }catch(Throwable t){

      }
    }

/*
    private void BasicTeamNumUpdate(View view) {
        main.NumBoxUpdate(R.id.BasicTeamNum, BundleValues.BasicTeamNum);
    }

    private void BasicRoundNumUpdate(View view) {
        main.NumBoxUpdate(R.id.BasicRoundNum, BundleValues.BasicRoundNum);
    }
*/

    public void BasicActivityChange(View view) {
        EditText TeamNum = findViewById(R.id.BasicTeamNum);
        String TeamNumString = TeamNum.getText().toString();
        EditText RoundNum = findViewById(R.id.BasicRoundNum);
        String RoundString = RoundNum.toString();

        //main.NumBoxUpdate(R.id.BasicTeamNum, BundleValues.BasicTeamNum);
      //  main.NumBoxUpdate(R.id.BasicRoundNum, BundleValues.BasicRoundNum);

        final Intent i = new Intent(getApplicationContext(), page_Auto.class);
       Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        int matchVal = Integer.parseInt(RoundNum.getText().toString());
        bundle.putInt(BundleValues.BasicRoundNum.toString(), matchVal);
        bundle.putString(BundleValues.BasicColorDropdown.toString(),
                ((Spinner) findViewById(R.id.BasicColorDropdown)).getSelectedItem().toString());
        bundle.putString(BundleValues.BasicTeamNum.toString(), TeamNumString);



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