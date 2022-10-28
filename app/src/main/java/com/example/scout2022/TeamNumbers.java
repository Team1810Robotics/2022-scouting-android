package com.example.scout2022;

public enum TeamNumbers {
//    TEAM_245(0, "245"), TEAM_935(1, "935"), TEAM_937(2, "937"),
    TEAM_525(0, "525"), TEAM_935(1, "935"), TEAM_937(2, "937), TEAM_1108(3, "1108"),

    private final String teamLabel;
    private final int indexTeam;

    TeamNumbers(final int indexTeam, final String teamLabel) {
        this.teamLabel = teamLabel;
        this.indexTeam = indexTeam;
    }

    public static TeamNumbers forIndex(final int indexIn) {
        for (TeamNumbers val : TeamNumbers.values()) {
            if (val.indexTeam == indexIn) {
                return val;
            }
        }

        return null;
    }


    public static final TeamNumbers fromValue(String valIn) {
        for (TeamNumbers val : TeamNumbers.values()) {
            if (val.teamLabel.equalsIgnoreCase(valIn)) {
                return val;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return teamLabel;
    }

    public String getLabel() {
        return teamLabel;
    }

    public int getIndex() {
        return indexTeam;
    }
}
