package com.example.scout2022;

import org.apache.commons.lang3.builder.ToStringBuilder;

//TODO Update IDs to current code
public class DataModel extends BaseDto {
    // Data for startup screen
    /**
     * The match number.
     *
     * @since 2019
     * updated 2/2022
     */
    //Basic
    private int matchID;
    private TeamNumbers teamID;
    private TeamColors allianceColor;
    //Auto
    private int autoNumCargoLower;
    private int autoNumCargoUpper;
    private String autoNumCargoHeld;
    private boolean canMove;
    //TeleOp
    private int teleopNumCargoLower;
    private int teleopNumCargoUpper;
    private boolean teleopColorCorrect;
    private BarGrabPosition endgameBarGrabPosition;
    //Final
    private boolean endgameWon;
    private String endNotes;

    //Basic Page getters and setters
    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(final int matchID) {
        this.matchID = matchID;
    }

    public TeamNumbers getTeamID() {
        return teamID;
    }

    public void setTeamID(final TeamNumbers teamID) {
        this.teamID = teamID;
    }

    public TeamColors getAllianceColor() {
        return allianceColor;
    }

    public void setAllianceColor(final TeamColors allianceColor) {
        this.allianceColor = allianceColor;
    }

    //Auto Page getters and setters
    public int getAutoNumCargoLower() {
        return autoNumCargoLower;
    }

    public void setAutoNumCargoLower(int autoNumCargoLower) {
        this.autoNumCargoLower = autoNumCargoLower;
    }

    public int getAutoNumCargoUpper() {
        return autoNumCargoUpper;
    }

    public void setAutoNumCargoUpper(int autoNumCargoUpper) {
        this.autoNumCargoUpper = autoNumCargoUpper;
    }

    public String getAutoNumCargoHeld() {return autoNumCargoHeld; }

    public void setAutoNumCargoHeld(String autoNumCargoHeld) {
        this.autoNumCargoHeld = autoNumCargoHeld;
    }

    public boolean getAutoCanMove() {return canMove; }

    public void setAutoCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    //TeleOp Page getters and setters
    public int getTeleopNumCargoLower() { return teleopNumCargoLower; }

    public void setTeleopNumCargoLower(int teleopNumCargoLower) {
        this.teleopNumCargoLower = teleopNumCargoLower;
    }

    public int getTeleopNumCargoUpper() {
        return teleopNumCargoUpper;
    }

    public void setTeleopNumCargoUpper(int teleopNumCargoUpper) {
        this.teleopNumCargoUpper = teleopNumCargoUpper;
    }

    public boolean isTeleopColorCorrect() {
        return teleopColorCorrect;
    }

    public void setTeleopColorCorrect(boolean teleopColorCorrect) {
        this.teleopColorCorrect = teleopColorCorrect;
    }
/* TODO delete with all references

    public boolean isTeleopBallPickupCorrect() {
        return teleopBallPickup;
    }

    public void setTeleopBallPickup(boolean teleopBallPickup) {
        this.teleopBallPickup = teleopBallPickup;
    }
*/
    public BarGrabPosition getEndgameBarGrabPosition() {
        return endgameBarGrabPosition;
    }

    public void setEndgameBarGrabPosition(BarGrabPosition endgameBarGrabPosition) {
        this.endgameBarGrabPosition = endgameBarGrabPosition;
    }

    //Final
    public boolean isEndgameWon() {
        return endgameWon;
    }

    public void setEndgameWon(boolean endgameWon) {
        this.endgameWon = endgameWon;
    }

    public String getEndNotes() {return endNotes; }

    public void setEndNotes(String endNotes) {
        this.endNotes = endNotes;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
