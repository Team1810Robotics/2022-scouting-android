package com.example.scout2022;

public enum AutoCapacity {
    NONE(0, "0"), ONE(1, "1"), TWO(2, "2");

    private final String capLabel;
    private final int indexCap;

    AutoCapacity(final int indexBar, final String capLabel) {
        this.capLabel = capLabel;
        this.indexCap = indexBar;
    }

    public static AutoCapacity forIndex(final int indexIn) {
        for (AutoCapacity val : AutoCapacity.values()) {
            if (val.indexCap == indexIn) {
                return val;
            }
        }

        return null;
    }


    public static final AutoCapacity fromValue(String valIn) {
        for (AutoCapacity val : AutoCapacity.values()) {
            if (val.capLabel.equalsIgnoreCase(valIn)) {
                return val;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return capLabel;
    }

    public String getLabel() {
        return capLabel;
    }

    public int getIndex() {
        return indexCap;
    }
}