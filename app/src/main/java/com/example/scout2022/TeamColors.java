package com.example.scout2022;

/**
 * Enum of alliance colors.
 *
 * @author Michael Sheehan
 */
public enum TeamColors {
    NONE_SELECTED(0,"None Selected"), RED(1, "Red"), BLUE(2, "Blue");

    private final String label;
    private final int index;

    TeamColors(final int index, final String label) {
        this.label = label;
        this.index = index;
    }

    public static TeamColors forIndex(final int indexIn) {
        for (TeamColors val : TeamColors.values()) {
            if (val.index == indexIn) {
                return val;
            }
        }

        return null;
    }

    public static TeamColors forLabel(final String valIn) {
        for (TeamColors val : TeamColors.values()) {
            if (val.label.equalsIgnoreCase(valIn)) {
                return val;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return label;
    }

    public int getIndex() {
        return index;
    }
}

