package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * creates page
 */
public class page_Final extends AppCompatActivity {
    private static final String uniqueID = UUID.randomUUID().toString(); //creates unique ID for each save file
    MainActivity main = new MainActivity();
    private String NotesString = "";
    private Boolean WinBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page4);

        CheckBox Win = findViewById(R.id.FinalWinCheck);

        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        try{
            WinBool = bundle.getBoolean(BundleValues.FinalWinCheck.toString());
            NotesString = bundle.getString(BundleValues.FinalNotes.toString());
            ((CheckBox) findViewById(R.id.FinalWinCheck)).setChecked(WinBool);
        }catch(Throwable t){
            t.printStackTrace();
        }
    }



    public void FinalWinCheckUpdate(View view) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        boolean variable;
        CheckBox lineCheckbox = findViewById(R.id.FinalWinCheck);
        variable = lineCheckbox.isChecked() ? true : false;
        bundle.putBoolean(BundleValues.FinalWinCheck.toString(), variable);
        i.putExtras(bundle);
    }
    //Create and save a new file
    public void FinalSave(View view) {

        EditText FinalNotes = findViewById(R.id.FinalNotes);
        String NotesString = FinalNotes.getText().toString();
        CheckBox Win = findViewById(R.id.FinalWinCheck);
        boolean variable;
        variable = Win.isChecked() ? true : false;

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        bundle.putBoolean(BundleValues.FinalWinCheck.toString(), variable);
        bundle.putString(BundleValues.FinalNotes.toString(),
                ((EditText) findViewById(R.id.FinalNotes)).getText().toString());

        final DataModel data = new DataModel();

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
        data.setAutoNumCargoHeld(AutoCapacity.fromValue(bundle.getString(BundleValues.AutoBallsHeld.toString(),"")));
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

        //BundleUtils.resetBundleValues(bundle);
    }

    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), page_TeleOp.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}