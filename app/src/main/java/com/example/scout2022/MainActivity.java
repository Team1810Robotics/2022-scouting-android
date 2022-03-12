package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


//import com.example.scout2022.ui.main.SectionsPagerAdapter;

/**
 * min and max can be adjusted to yearly rules as needed
 */
public class MainActivity extends AppCompatActivity {
    private Utils Util = new Utils();

   // private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        /*
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        */

        /**
         * This is a starting location for the team number autofill, please move if possible
        **/
        /*
        try {
            String[] team_Numbers = getResources().getStringArray(R.array.teamNumber);
            AutoCompleteTextView ACBasicTeamNum = findViewById(R.id.BasicTeamNum);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, team_Numbers);
            ACBasicTeamNum.setAdapter(adapter);
        } catch(Throwable t) {
            t.printStackTrace();
        }
*/
    }

/*
    public void SubmitBasic(View view){
        NumBoxUpdate(R.id.BasicTeamNum, BundleValues.BasicTeamNum);
        NumBoxUpdate(R.id.BasicRoundNum, BundleValues.BasicRoundNum);
        //DropDownUpdate(R.id.BasicColorDropdown, BundleValues.BasicColorDropdown);
    }
*/

/* TODO remove submit button and fix dropdowns

    public void BasicColorDropdownUpdate(View view) {
        TextBoxUpdate(R.id.BasicColorDropdown, BundleValues.BasicColorDropdown);
    }

    public void TeleOpBarHeightUpdate(View view) {
        DropDownUpdate(R.id.TeleOpHeightDropdown, BundleValues.TeleOpHeightDropdown);
    }
*/
/*
    Spinner TeleOpHeightDropdown = (Spinner) findViewById(R.id.TeleOpHeightDropdown);
    TeleOpHeightDropdown.setAdapter(new ArrayAdapter<BarGrabPosition>(this, android.R.layout.TeleOpHeightDropdown, BarGrabPosition.values()));
*/





    public void CheckBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        boolean variable;
        CheckBox CheckboxUpdate = findViewById(id); //find checkbox
        variable = CheckboxUpdate.isChecked() ? true : false;
        bundle.putBoolean(bundleLocation.toString(), variable); //update bundle value
        i.putExtras(bundle);
    }

    public void TextBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        TextView TextViewUpdate = findViewById(id); //find textview (text input)
        String StringUpdate = TextViewUpdate.getText().toString(); //convert textview to string
        bundle.putString(bundleLocation.toString(), StringUpdate); //update bundle value
        i.putExtras(bundle);
    }
//TODO delete unless still needed
    /*
    private void DropDownUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        bundle.putString( BundleValues.BasicColorDropdown.toString(),
                ((Spinner) findViewById( R.id.BasicColorDropdown )).getSelectedItem().toString() );
        i.putExtras(bundle);
    }
    */

    public void NumBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        TextView NumViewUpdate = findViewById(id); //find textview (text input)
        String StringToIntUpdate = NumViewUpdate.getText().toString(); //convert textview to string
        int variable =Integer.parseInt(StringToIntUpdate);
        bundle.putInt(bundleLocation.toString(), variable); //update bundle value
        i.putExtras(bundle);
    }

    public void MainActivityChange(View view) {
        final Intent i = new Intent(getApplicationContext(), page_Basic.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        startActivity(i);
    }
}
