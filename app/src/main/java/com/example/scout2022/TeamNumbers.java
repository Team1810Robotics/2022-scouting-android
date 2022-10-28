package com.example.scout2022;

public enum TeamNumbers {
    TEAM_525(0, "525"), TEAM_935(1, "935"), TEAM_937(2, "937"), TEAM_1108(3, "1108"), TEAM_1710(4, "1710"),TEAM_1730(5, "1730"),  TEAM_1763(6, "1763"),
    TEAM_1764(7, "1764"), TEAM_1769(8, "1769"), TEAM_1802(9, "1802"), TEAM_1806(10, "1806"), TEAM_1810(11, "1810"), TEAM_1825(12, "1825"), TEAM_1939(13, "1939"),
    TEAM_1982(14, "1982"), TEAM_1986(15, "1986"), TEAM_1987(16, "1987"), TEAM_1994(17, "1994"), TEAM_1997(18, "1997"), TEAM_2357(19, "2357"),TEAM_2410(20, "2410"),
    TEAM_3284(21, "3284"), TEAM_3928(22, "3928"), TEAM_4455(23, "4455"),TEAM_5013(24, "5013"),TEAM_5098(25, "5098"), TEAM_5119(26, "5119"),  TEAM_5126(27, "5126"),
    TEAM_5454(28, "5454"), TEAM_5801(29, "5801"),TEAM_5809(30, "5809"),TEAM_5918(31, "5918"), TEAM_5968(32, "5968"), TEAM_6419(33, "6419"), TEAM_6424(34, "6424"),
    TEAM_8825(35, "8825");

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
