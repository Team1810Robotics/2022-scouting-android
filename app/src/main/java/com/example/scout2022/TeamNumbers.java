package com.example.scout2022;

public enum TeamNumbers {
    TEAM_245(0, "245"), TEAM_935(1, "935"), TEAM_937(2, "937"),
    TEAM_938(3, "938"), TEAM_1160(4, "1160"), TEAM_1723(5, "1723"),
    TEAM_1763(6, "1763"), TEAM_1769(7, "1769"), TEAM_1810(8, "1810"),
    TEAM_1984(9, "1984"), TEAM_1987(10, "1987"), TEAM_1997(11, "1997"),
    TEAM_2169(12, "2169"), TEAM_2220(13, "2220"), TEAM_2345(14, "2345"),
    TEAM_2410(15, "2410"), TEAM_2457(16, "2457"), TEAM_3184(17, "3184"),
    TEAM_3931(18, "3931"), TEAM_4809(19, "4809"), TEAM_5013(20, "5013"),
    TEAM_5098(21, "5098"), TEAM_5126(22, "5162"), TEAM_5189(23, "5189"),
    TEAM_5809(24, "5809"), TEAM_5935(25, "5935"), TEAM_5968(26, "5968"),
    TEAM_6026(27, "6026"), TEAM_6542(28, "6542"), TEAM_6817(29, "6817"),
    TEAM_6886(30, "6886"), TEAM_7662(31, "7662"), TEAM_8004(32, "8004"),
    TEAM_8112(33, "8112");

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
