package com.example.scout2022;

//TODO Update IDs to current code
public class DataModel extends BaseDto {
    // Data for startup screen
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

    private TeamNumbers teamID;
    private TeamColors allianceColor;
    //private int startingBalls;
    //private String nameOfScouter;
    private boolean autoPassedLine;
    private int autoNumCargoLower;
    private int autoNumCargoOuter;
    private int autoNumCargoInner;
    private int teleopNumCargoLower;
    private int teleopNumCargoOuter;
    private int teleopNumCargoInner;
    private boolean teleopCanSpinWheel;
    private boolean teleopColorCorrect;
    private boolean teleopTrench;
    private boolean teleopBar;
    private boolean teleopBallPickup;
    //private Stage teleopStageReached;
    private BarGrabPosition endgameBarGrabPosition;
    private boolean endgameWon;

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

    /*
        public int getStartingBalls() {
            return startingBalls;
        }

        public void setStartingBalls( int startingBalls ) {
            this.startingBalls = startingBalls;
        }

        public String getScouterName(){return nameOfScouter;}

        public void setNameOfScouter( String nameOfScouter) {this.nameOfScouter = nameOfScouter;}
    */
    public boolean isAutoPassedLine() {
        return autoPassedLine;
    }

    public void setAutoPassedLine(boolean autoPassedLine) {
        this.autoPassedLine = autoPassedLine;
    }

    public int getAutoNumCargoLower() {
        return autoNumCargoLower;
    }

    public void setAutoNumCargoLower(int autoNumCargoLower) {
        this.autoNumCargoLower = autoNumCargoLower;
    }

    public int getAutoNumCargoOuter() {
        return autoNumCargoOuter;
    }

    public void setAutoNumCargoOuter(int autoNumCargoOuter) {
        this.autoNumCargoOuter = autoNumCargoOuter;
    }

    public int getAutoNumCargoInner() {
        return autoNumCargoInner;
    }

    public void setAutoNumCargoUpper(int autoNumCargoInner) {
        this.autoNumCargoInner = autoNumCargoInner;
    }

    public int getTeleopNumCargoLower() {
        return teleopNumCargoLower;
    }

    public void setTeleopNumCargoUpper(int teleopNumCargoLower) {
        this.teleopNumCargoLower = teleopNumCargoLower;
    }

    public int getTeleopNumCargoOuter() {
        return teleopNumCargoOuter;
    }

    public void setTeleopNumCargoOuter(int teleopNumCargoOuter) {
        this.teleopNumCargoOuter = teleopNumCargoOuter;
    }

    public int getTeleopNumCargoInner() {
        return teleopNumCargoInner;
    }

    public void setTeleopNumCargoLower(int teleopNumCargoInner) {
        this.teleopNumCargoInner = teleopNumCargoInner;
    }

    public boolean isTeleopCanSpinWheel() {
        return teleopCanSpinWheel;
    }

    public void setTeleopCanSpinWheel(boolean teleopCanSpinWheel) {
        this.teleopCanSpinWheel = teleopCanSpinWheel;
    }

    public boolean isTeleopColorCorrect() {
        return teleopColorCorrect;
    }

    public void setTeleopColorCorrect(boolean teleopColorCorrect) {
        this.teleopColorCorrect = teleopColorCorrect;
    }

    public boolean isTeleopTrenchCorrect() {
        return teleopTrench;
    }

    public void setTeleopTrench(boolean teleopTrench) {
        this.teleopTrench = teleopTrench;
    }

    public boolean isTeleopBarCorrect() {
        return teleopBar;
    }

    public void setTeleopBar(boolean teleopBar) {
        this.teleopBar = teleopBar;
    }

    public boolean isTeleopBallPickupCorrect() {
        return teleopBallPickup;
    }

    public void setTeleopBallPickup(boolean teleopBallPickup) {
        this.teleopBallPickup = teleopBallPickup;
    }

    /*
        public Stage getTeleopStageReached() {
            return teleopStageReached;
        }

        public void setTeleopStageReached( Stage teleopStageReached ) {
            this.teleopStageReached = teleopStageReached;
        }
    */
    public BarGrabPosition getEndgameBarGrabPosition() {
        return endgameBarGrabPosition;
    }

    public void setEndgameBarGrabPosition(BarGrabPosition endgameBarGrabPosition) {
        this.endgameBarGrabPosition = endgameBarGrabPosition;
    }

    public boolean isEndgameWon() {
        return endgameWon;
    }

    public void setEndgameWon(boolean endgameWon) {
        this.endgameWon = endgameWon;
    }
}
