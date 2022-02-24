package com.example.scout2022;

import android.os.Bundle;

public class BundleUtils {
    public static void dumpBundle(final Bundle b) {
        for (final BundleValues key : BundleValues.values()) {
            System.out.println(key.toString() + " = " + b.get(key.toString()));
        }
    }

    public static DataModel buildDataModel(final Bundle bundle) {
        System.out.println("-- Before Data Build --");
        dumpBundle(bundle);
        final DataModel data = new DataModel();
        data.setMatchID(bundle.getInt(BundleValues.BasicRoundNum.toString(), 0));
        data.setTeamID(TeamNumbers.fromValue(bundle.getString((BundleValues.BasicTeamNum.toString()), TeamNumbers.TEAM_245.toString())));
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

 */

        //data.setTeleopNumCargoOuter( bundle.getInt( BundleValues.TELEOP_OUTER_BALLS.toString(), 0 ) );
        //data.setTeleopStageReached( Stage.fromIndex( bundle.getInt( BundleValues.TELEOP_STAGE_LEVEL.toString(), 0 ) ) );
        data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(bundle.getString(
                BundleValues.TeleOpHeightDropdown.toString(), BarGrabPosition.NONE.getLabel())));
        data.setEndgameWon(bundle.getBoolean(BundleValues.FinalWinCheck.toString(), false));
        return data;
    }

    public static void resetBundleValues(final Bundle b) {
        for (final BundleValues val : BundleValues.values()) {
            switch (val) {
                //case AUTO_LINE:
                case FinalWinCheck:
                    //case TELEOP_SPIN:
                case TeleOpColorCheck:
                    b.putBoolean(val.toString(), false);
                    break;
                //case AUTO_POWERCELL_INNER:
                //case AUTO_POWERCELL_LOWER:
                //case AUTO_POWERCELL_OUTER:
                //case STARTUP_BALLS:
                case BasicRoundNum:
                case BasicTeamNum:
                case TeleOpLowerTicker:
                case TeleOpUpperTicker:
                    //case TELEOP_OUTER_BALLS:
                    //case TELEOP_STAGE_LEVEL:
                    b.putInt(val.toString(), 0);
                    break;
                case BasicColorDropdown:
                    b.putString(val.toString(), TeamColors.BLUE.toString());
                    break;
                case TeleOpHeightDropdown:
                    b.putString(val.toString(), BarGrabPosition.NONE.getLabel());
                    break;
            }
        }
    }
}