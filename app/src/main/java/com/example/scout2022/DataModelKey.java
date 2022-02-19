package com.example.scout2022;
//TODO update IDs to match current code

/**
 * Data model key - i.e. what makes a data record unique.
 *
 * @author Michael Sheehan
 */
public class DataModelKey extends BaseDto {
    /**
     * The match number.
     *
     * @since 2019
     */
    private int matchID;

    /**
     * The team number
     *
     * @since 2019
     */
    private int teamID;

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(final int matchID) {
        this.matchID = matchID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(final int teamID) {
        this.teamID = teamID;
    }
}
