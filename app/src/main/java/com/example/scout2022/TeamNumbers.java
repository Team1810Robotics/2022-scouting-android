package com.example.scout2022;


public enum TeamNumbers {
    /* 2020 teams
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
    TEAM_8112(33, "8112"),
    */
    TEAM_937(0, "937"), TEAM_1710(1, "1710"), TEAM_1723(2, "1723"),
    TEAM_1769(3, "1769"), TEAM_1785(4, "1785"), TEAM_1802(5, "1802"),
    TEAM_1806(6, "1806"), TEAM_1810(7, "1810"), TEAM_1825(8, "1825"),
    TEAM_1847(9, "1847"), TEAM_1939(10, "1939"), TEAM_1982(11, "1982"),
    TEAM_1984(12, "1984"), TEAM_1986(13, "1986"), TEAM_1997(14, "1997"),
    TEAM_2345(15, "2345"), TEAM_2357(16, "2357"), TEAM_2457(17, "2457"),
    TEAM_2718(18, "2718"), TEAM_3172(19, "3172"), TEAM_3179(20, "3179"),
    TEAM_4959(21, "4959"), TEAM_5098(22, "5098"), TEAM_5141(23, "5141"),
    TEAM_5268(24, "5268"), TEAM_5801(25, "5801"), TEAM_6843(26, "6843"),
    TEAM_7064(27, "7064"), TEAM_7255(28, "7255"), TEAM_8112(29, "8112"),;


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
