package com.example.scout2022;

import android.os.Bundle;

public class BundleUtils {
    public static void dumpBundle(final Bundle b) {
        for (final BundleValues key : BundleValues.values()) {
            System.out.println(key.toString() + " = " + b.get(key.toString()));
        }
    }

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