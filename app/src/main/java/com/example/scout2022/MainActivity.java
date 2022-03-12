package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scout2022.databinding.ActivityMainBinding;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//import com.example.scout2022.ui.main.SectionsPagerAdapter;

/**
 * min and max can be adjusted to yearly rules as needed
 */
public class MainActivity extends AppCompatActivity {
    private int minimumBallCount = 0;
    private int maximumBallCount = 100;
    private Utils Util = new Utils();
    private static final String uniqueID = UUID.randomUUID().toString(); //creates unique ID for each save file
    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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


    //Create and save a new file
    public void FinalSave(View view) {



        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }



        final DataModel data = new DataModel();

        DropDownUpdate(R.id.TeleOpHeightDropdown, BundleValues.TeleOpHeightDropdown);

        //setting final bundle value for bar grab position
        //.putString(BundleValues.TeleOpHeightDropdown.toString(), ((Spinner) findViewById(R.id.TeleOpHeightDropdown)).getSelectedItem().toString());

        //storing the user input values into the DataModel to be used in the DAO

        //Basic Page
        data.setMatchID(bundle.getInt(BundleValues.BasicRoundNum.toString(), 0));
        data.setTeamID(TeamNumbers.fromValue(bundle.getString(BundleValues.BasicTeamNum.toString(), "")));
        data.setAllianceColor(TeamColors.forLabel(bundle.getString(BundleValues.BasicColorDropdown.toString(), "")));

        // data.setStartingBalls( bundle.getInt( BundleValues.STARTUP_BALLS.toString(), 0 ) );
        // data.setNameOfScouter(bundle.getString(BundleValues.SCOUTER_NAME.toString(), "" ) );

        //Auto Page
       data.setAutoNumCargoUpper(bundle.getInt(BundleValues.AutoUpperTicker.toString(), 0));
        data.setAutoNumCargoLower(bundle.getInt(BundleValues.AutoLowerTicker.toString(), 0));
        data.setAutoNumCargoHeld(bundle.getInt(BundleValues.AutoBallsHeld.toString(), 0));
        data.setAutoCanMove(bundle.getBoolean(BundleValues.AutoCanMove.toString(), false));

        // data.setAutoPassedLine( bundle.getBoolean( BundleValues.AUTO_LINE.toString(), false ) );
        // data.setTeleopCanSpinWheel( bundle.getBoolean( BundleValues.TELEOP_SPIN.toString(), false ) );

        //TeleOp Page
        data.setTeleopColorCorrect(bundle.getBoolean(BundleValues.TeleOpColorCheck.toString(), false));
        data.setTeleopNumCargoLower(bundle.getInt(BundleValues.TeleOpLowerTicker.toString(), 0));
        data.setTeleopNumCargoUpper(bundle.getInt(BundleValues.TeleOpUpperTicker.toString(), 0));
        data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(bundle.getString(BundleValues.TeleOpHeightDropdown.toString(), "")));
        //data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(bundle.getString(BundleValues.TeleOpHeightDropdown.toString())));
        // data.setTeleopNumCargoOuter( bundle.getInt( BundleValues.TELEOP_OUTER_BALLS.toString(), 0 ) );
        // data.setTeleopStageReached( Stage.fromIndex( bundle.getInt( BundleValues.TELEOP_STAGE_LEVEL.toString(), 0 ) ) );

        //Final
        data.setEndgameWon(bundle.getBoolean(BundleValues.FinalWinCheck.toString(), false));
        data.setEndNotes(bundle.getString(BundleValues.FinalNotes.toString(), ""));

        //writing to the disk actually into the Documents Directory
        try {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

            dir.setWritable(true, false);
            dir.setReadable(true, false);
            //TODO test app on tablet with granted permission in android settings to access files
            if (!dir.exists() && !dir.mkdirs()) {
                throw new IOException("Could not create directory '" + dir + "'.");
            }

            final File csvFileLocation = new File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) +
                            "/scouting2022export" + uniqueID + ".csv");

            csvFileLocation.setReadable(true, false);
            csvFileLocation.setWritable(true, false);

            if (!csvFileLocation.exists() && !csvFileLocation.createNewFile()) {
                throw new IOException("Could not create file'" + csvFileLocation + "'");
            }

            final DataModelDao dao = new DataModelDaoImpl(csvFileLocation);
            dao.appendDataModel(data);

            final Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        } catch (final Throwable e) {
            e.printStackTrace();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(e.getMessage());
            alertDialogBuilder.setTitle("File Save Error Contact A Programmer");

            alertDialogBuilder.setNegativeButton("Okay", (dialog, which) -> {
                finish();
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        BundleUtils.resetBundleValues(bundle);
    }


    /**
     * Score Counter increment and decrement
     */
    //autonomous page
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

    //teleOp page
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

    /**
     * Onclick update functions
     */

    public void SubmitBasic(View view){
        NumBoxUpdate(R.id.BasicTeamNum, BundleValues.BasicTeamNum);
        NumBoxUpdate(R.id.BasicRoundNum, BundleValues.BasicRoundNum);
        //DropDownUpdate(R.id.BasicColorDropdown, BundleValues.BasicColorDropdown);
    }


/* TODO remove submit button and fix dropdowns

    public void BasicColorDropdownUpdate(View view) {
        TextBoxUpdate(R.id.BasicColorDropdown, BundleValues.BasicColorDropdown);
    }

    public void TeleOpBarHeightUpdate(View view) {
        DropDownUpdate(R.id.TeleOpHeightDropdown, BundleValues.TeleOpHeightDropdown);
    }
*/

    public void BasicTeamNumUpdate(View view) {
        NumBoxUpdate(R.id.BasicTeamNum, BundleValues.BasicTeamNum);
    }

    public void BasicRoundNumUpdate(View view) {
        NumBoxUpdate(R.id.BasicRoundNum, BundleValues.BasicRoundNum);
    }

    public void AutoTarmacCheckBoxUpdate(View view) {
        CheckBoxUpdate(R.id.AutoTarmacCheckBox, BundleValues.AutoCanMove);
    }

    public void AutoBallsHeldUpdate(View view) {
        NumBoxUpdate(R.id.AutoBallsHeld, BundleValues.AutoBallsHeld);
    }

    public void TeleOpColorCheckUpdate(View view) {
        CheckBoxUpdate(R.id.TeleOpColorCheck, BundleValues.TeleOpColorCheck);
    }
/*
    Spinner TeleOpHeightDropdown = (Spinner) findViewById(R.id.TeleOpHeightDropdown);
    TeleOpHeightDropdown.setAdapter(new ArrayAdapter<BarGrabPosition>(this, android.R.layout.TeleOpHeightDropdown, BarGrabPosition.values()));
*/
    public void FinalNotesUpdate(View view) {
        TextBoxUpdate(R.id.FinalNotes, BundleValues.FinalNotes);
    }

    public void FinalWinCheckUpdate(View view) {
        CheckBoxUpdate(R.id.FinalWinCheck, BundleValues.FinalWinCheck);
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

    private void CheckBoxUpdate(int id, BundleValues bundleLocation) {
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

    private void TextBoxUpdate(int id, BundleValues bundleLocation) {
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

    private void NumBoxUpdate(int id, BundleValues bundleLocation) {
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
 //TODO add onclick updaters for other inputs

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
