package com.example.scout2022;

public enum BarGrabPosition {
    NONE(0, "None"), LEVEL(1, "Level"), HIGH(2, "High");

    private final String barLabel;
    private final int indexBar;

    BarGrabPosition(final int indexBar, final String barLabel) {
        this.barLabel = barLabel;
        this.indexBar = indexBar;
    }

    public static BarGrabPosition forIndex(final int indexIn) {
        for (BarGrabPosition val : BarGrabPosition.values()) {
            if (val.indexBar == indexIn) {
                return val;
            }
        }

        return null;
    }


    public static final BarGrabPosition fromValue(String valIn) {
        for (BarGrabPosition val : BarGrabPosition.values()) {
            if (val.barLabel.equalsIgnoreCase(valIn)) {
                return val;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return barLabel;
    }

    public String getLabel() {
        return barLabel;
    }

    public int getIndex() {
        return indexBar;
    }
}
