package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.scout2022.databinding.ActivityMainBinding;
import com.example.scout2022.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String uniqueID = UUID.randomUUID().toString(); //creates unique ID for each save file
    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    //Create and save a new file
    public void FinalSave() {

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        final DataModel data = new DataModel();

        //setting final bundle value for bar grab position
        bundle.putString(BundleValues.TeleOpHeightDropdown.toString(), ((Spinner) findViewById(R.id.TeleOpHeightDropdown)).getSelectedItem().toString());

        //storing the user input values into the DataModel to be used in the DAO
        data.setMatchID(bundle.getInt(BundleValues.BasicRoundNum.toString(), 0));
        data.setTeamID(TeamNumbers.fromValue(bundle.getString(BundleValues.BasicTeamNum.toString(), TeamNumbers.TEAM_245.toString())));
        data.setAllianceColor(TeamColors.forLabel(bundle.getString(BundleValues.BasicColorDropdown.toString(), TeamColors.BLUE.toString())));
        // data.setStartingBalls( bundle.getInt( BundleValues.STARTUP_BALLS.toString(), 0 ) );
        // data.setNameOfScouter(bundle.getString(BundleValues.SCOUTER_NAME.toString(), "" ) );
        // data.setAutoNumPowerCellsInner( bundle.getInt( BundleValues.AUTO_POWERCELL_INNER.toString(), 0 ) );
        // data.setAutoNumPowerCellsLower( bundle.getInt( BundleValues.AUTO_POWERCELL_LOWER.toString(), 0 ) );
        // data.setAutoNumPowerCellsOuter( bundle.getInt( BundleValues.AUTO_POWERCELL_OUTER.toString(), 0 ) );
        // data.setAutoPassedLine( bundle.getBoolean( BundleValues.AUTO_LINE.toString(), false ) );
        // data.setTeleopCanSpinWheel( bundle.getBoolean( BundleValues.TELEOP_SPIN.toString(), false ) );
        data.setTeleopColorCorrect(bundle.getBoolean(BundleValues.TeleOpColorCheck.toString(), false));
        data.setTeleopNumPowerCellsInner(bundle.getInt(BundleValues.TeleOpLowerCounter.toString(), 0));
        data.setTeleopNumPowerCellsLower(bundle.getInt(BundleValues.TeleOpUpperCounter.toString(), 0));
        //data.setTeleopNumPowerCellsOuter( bundle.getInt( BundleValues.TELEOP_OUTER_BALLS.toString(), 0 ) );
        // data.setTeleopStageReached( Stage.fromIndex( bundle.getInt( BundleValues.TELEOP_STAGE_LEVEL.toString(), 0 ) ) );
        data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(bundle.getString(BundleValues.TeleOpHeightDropdown.toString(), BarGrabPosition.NONE.toString())));
        data.setEndgameWon(bundle.getBoolean(BundleValues.FinalWinCheck.toString(), false));
        //data.setTeleopTrench( bundle.getBoolean(BundleValues.TELEOP_TRENCH.toString(), false ) );
        //data.setTeleopBar( bundle.getBoolean(BundleValues.TELEOP_BAR.toString(), false ) );
        //data.setTeleopBallPickup( bundle.getBoolean(BundleValues.TElEOP_BALL_PICKUP.toString(), false ) );

        //writing to the disk actually into the Documents Directory
        try {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

            dir.setWritable(true, false);
            dir.setReadable(true, false);

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
}