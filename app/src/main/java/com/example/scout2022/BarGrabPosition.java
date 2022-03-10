package com.example.scout2022;

public enum BarGrabPosition {
    NONE(0, "Did not Climb"), Low(1, "Low"), Mid (2, "Middle"),
    High(3, "High"), Transversal(4,"Transversal");

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
