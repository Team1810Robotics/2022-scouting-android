package com.example.scout2022;

import android.os.Bundle;

public class BundleUtils {
    public static void dumpBundle(final Bundle b) {
        for (final BundleValues key : BundleValues.values()) {
            System.out.println(key.toString() + " = " + b.get(key.toString()));
        }
    }
/*
    public static DataModel buildDataModel(final Bundle bundle) {
        System.out.println("-- Before Data Build --");
        dumpBundle(bundle);
        final DataModel data = new DataModel();
        data.setMatchID(bundle.getInt(BundleValues.BasicRoundNum.toString(), 0));
        data.setTeamID(TeamNumbers.fromValue(bundle.getString((BundleValues.BasicTeamNum.toString()), TeamNumbers.TEAM_937.toString())));
        data.setAllianceColor(TeamColors.forLabel(bundle.getString(BundleValues.BasicColorDropdown.toString(),
                TeamColors.BLUE.toString())));
        //data.setStartingBalls( bundle.getInt( BundleValues.STARTUP_BALLS.toString(), 0 ) );

        data.setAutoNumCargoUpper( bundle.getInt( BundleValues.AutoUpperTicker.toString(), 0 ) );
        data.setAutoNumCargoLower( bundle.getInt( BundleValues.AutoLowerTicker.toString(), 0 ) );
       // data.setAutoPassedLine( bundle.getBoolean( BundleValues.AUTO_LINE.toString(), false ) );
       // data.setTeleopCanSpinWheel( bundle.getBoolean( BundleValues.TELEOP_SPIN.toString(), false ) );
        data.setTeleopColorCorrect( bundle.getBoolean( BundleValues.TeleOpColorCheck.toString(), false ) );
        data.setTeleopNumCargoLower( bundle.getInt( BundleValues.TeleOpLowerTicker.toString(), 0 ) );
        data.setTeleopNumCargoUpper( bundle.getInt( BundleValues.TeleOpUpperTicker.toString(), 0 ) );
/* // TODO delete

        // data.setAutoNumCargoInner( bundle.getInt( BundleValues.AUTO_POWERCELL_INNER.toString(), 0 ) );
        // data.setAutoNumCargoLower( bundle.getInt( BundleValues.AUTO_POWERCELL_LOWER.toString(), 0 ) );
        // data.setAutoNumCargoOuter( bundle.getInt( BundleValues.AUTO_POWERCELL_OUTER.toString(), 0 ) );
        // data.setAutoPassedLine( bundle.getBoolean( BundleValues.AUTO_LINE.toString(), false ) );
        // data.setTeleopCanSpinWheel( bundle.getBoolean( BundleValues.TELEOP_SPIN.toString(), false ) );
        data.setTeleopColorCorrect(bundle.getBoolean(BundleValues.TeleOpColorCheck.toString(), false));
        data.setTeleopNumCargoInner(bundle.getInt(BundleValues.TeleOpLowerCounter.toString(), 0));
        data.setTeleopNumCargoLower(bundle.getInt(BundleValues.TeleOpUpperCounter.toString(), 0));

 ///

        //data.setTeleopNumCargoOuter( bundle.getInt( BundleValues.TELEOP_OUTER_BALLS.toString(), 0 ) );
        //data.setTeleopStageReached( Stage.fromIndex( bundle.getInt( BundleValues.TELEOP_STAGE_LEVEL.toString(), 0 ) ) );
        data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(bundle.getString(
                BundleValues.TeleOpHeightDropdown.toString(), BarGrabPosition.NONE.getLabel())));
        data.setEndgameWon(bundle.getBoolean(BundleValues.FinalWinCheck.toString(), false));
        return data;
    }
*/
    public static void resetBundleValues(final Bundle b) {
        for (final BundleValues val : BundleValues.values()) {
            switch (val) {
                case FinalNoteText:
                    b.putString(val.toString(), "");
                    break;
                case FinalWinCheck:
                    b.putBoolean(val.toString(), false);
                case TeleOpColorCheck:
                    b.putBoolean(val.toString(), false);
                case AutoCanMove:
                    b.putBoolean(val.toString(), false);
                    break;
                case TeleOpHeightDropdown:
                    b.putString(val.toString(), BarGrabPosition.NONE.getLabel());
                    break;
                case AutoBallsHeld:
                    b.putInt(val.toString(), 0);
                case AutoLowerTicker:
                    b.putInt(val.toString(), 0);
                case AutoUpperTicker:
                    b.putInt(val.toString(), 0);
                case BasicRoundNum:
                    b.putInt(val.toString(), 0);
                case BasicTeamNum:
                    b.putInt(val.toString(), 0);
                case TeleOpLowerTicker:
                    b.putInt(val.toString(), 0);
                case TeleOpUpperTicker:
                    b.putInt(val.toString(), 0);
                    break;
                case BasicColorDropdown:
                    b.putString(val.toString(), TeamColors.NONE_SELECTED.toString());
                    break;
            }
        }
    }
}