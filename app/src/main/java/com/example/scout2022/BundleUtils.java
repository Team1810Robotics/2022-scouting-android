package com.example.scout2022;

import android.os.Bundle;

public class BundleUtils {
    public static void dumpBundle( final Bundle b ) {
        for ( final BundleValues key : BundleValues.values() ) {
            System.out.println( key.toString() + " = " + b.get( key.toString() ) );
        }
    }

    public static DataModel buildDataModel( final Bundle bundle ) {
        System.out.println( "-- Before Data Build --" );
        dumpBundle( bundle );
        final DataModel data = new DataModel();
        data.setMatchID( bundle.getInt( BundleValues.STARTUP_MATCH_NUMBER.toString(), 0 ) );
        data.setTeamID( TeamNumbers.fromValue(bundle.getString( (BundleValues.STARTUP_ROBOT_ID.toString()), TeamNumbers.TEAM_245.toString() ) ) );
        data.setAllianceColor( AllianceColor.forLabel( bundle.getString( BundleValues.STARTUP_ALLIANCE_COLOR.toString(),
                AllianceColor.BLUE.toString() ) ) );
        data.setStartingBalls( bundle.getInt( BundleValues.STARTUP_BALLS.toString(), 0 ) );
        data.setAutoNumPowerCellsInner( bundle.getInt( BundleValues.AUTO_POWERCELL_INNER.toString(), 0 ) );
        data.setAutoNumPowerCellsLower( bundle.getInt( BundleValues.AUTO_POWERCELL_LOWER.toString(), 0 ) );
        data.setAutoNumPowerCellsOuter( bundle.getInt( BundleValues.AUTO_POWERCELL_OUTER.toString(), 0 ) );
        data.setAutoPassedLine( bundle.getBoolean( BundleValues.AUTO_LINE.toString(), false ) );
        data.setTeleopCanSpinWheel( bundle.getBoolean( BundleValues.TELEOP_SPIN.toString(), false ) );
        data.setTeleopColorCorrect( bundle.getBoolean( BundleValues.TELEOP_COLOR.toString(), false ) );
        data.setTeleopNumPowerCellsInner( bundle.getInt( BundleValues.TELEOP_INNER_BALLS.toString(), 0 ) );
        data.setTeleopNumPowerCellsLower( bundle.getInt( BundleValues.TELEOP_LOWER_BALLS.toString(), 0 ) );
        data.setTeleopNumPowerCellsOuter( bundle.getInt( BundleValues.TELEOP_OUTER_BALLS.toString(), 0 ) );
        data.setTeleopStageReached( Stage.fromIndex( bundle.getInt( BundleValues.TELEOP_STAGE_LEVEL.toString(), 0 ) ) );
        data.setEndgameBarGrabPosition( BarGrabPosition.fromValue( bundle.getString(
                BundleValues.ENDGAME_BAR_LEVEL.toString(), BarGrabPosition.NONE.getLabel() ) ) );
        data.setEndgameWon( bundle.getBoolean( BundleValues.ENDGAME_WIN.toString(), false ) );
        return data;
    }

    public static void resetBundleValues( final Bundle b ) {
        for ( final BundleValues val : BundleValues.values() ) {
            switch ( val ) {
                case AUTO_LINE:
                case ENDGAME_WIN:
                case TELEOP_SPIN:
                case TELEOP_COLOR:
                    b.putBoolean( val.toString(), false );
                    break;
                case AUTO_POWERCELL_INNER:
                case AUTO_POWERCELL_LOWER:
                case AUTO_POWERCELL_OUTER:
                case STARTUP_BALLS:
                case STARTUP_MATCH_NUMBER:
                case STARTUP_ROBOT_ID:
                case TELEOP_INNER_BALLS:
                case TELEOP_LOWER_BALLS:
                case TELEOP_OUTER_BALLS:
                case TELEOP_STAGE_LEVEL:
                    b.putInt( val.toString(), 0 );
                    break;
                case STARTUP_ALLIANCE_COLOR:
                    b.putString( val.toString(), AllianceColor.BLUE.toString() );
                    break;
                case ENDGAME_BAR_LEVEL:
                    b.putString( val.toString(), BarGrabPosition.NONE.getLabel() );
                    break;
            }
        }
    }
}