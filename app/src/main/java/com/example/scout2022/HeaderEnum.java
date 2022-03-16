package com.example.scout2022;

//TODO update IDs to match current code
public enum HeaderEnum {
    /*
    MatchId("Match Id"), TeamId("Team Id"), AllianceColor("Alliance Color"), StartupBalls("Startup Balls"), ScouterName("namo"),
    PassedAutoLine("Passed Auto Line"), AutoCargoLower("Auto Power Cells Lower"),
    AutoCargoOuter("Auto Power Cells Outer"), AutoCargoInner("Auto Power Cells Inner"),
    TeleopCargoLower("Teleop Power Cells Lower"), TeleopCargoOuter("Teleop Power Cells Outer"),
    TeleopCargoInner("Teleop Power Cells Inner"), TeleopCanSpinWheel("Can Spin Wheel"),
    TeleopCanChooseCorrectColor("Can Choose Correct Color"), TeleopCanTrench("Can Go Through Trench"),
    TeleopCanBar("Can Go Over bar"), TeleopCanPickupBalls("Can Pickup Balls Off Ground"), GrabBarPosition("Grab Bar Position"), Won("Won");
*/
    MatchId("Match Id"), TeamId("Team Id"), AllianceColor("Alliance Color"),
    AutoCargoLower("Auto Cargo Lower"), AutoCargoOuter("Auto Cargo Upper"), AutoCargoHeld("Cargo held at once"), AutoMoves("Can Robot Move"),
    TeleOpCargoLower("TeleOp Cargo Lower"), TeleOpCargoOuter("TeleOp Cargo Upper"), TeleOpCanSeeColor("Can See Colors"), GrabBarPosition("Grab Bar Position"),
    Won("Won"), Notes("Final Notes");
    private final String value;

    HeaderEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
