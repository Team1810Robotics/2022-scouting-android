package com.example.scout2022;

public enum HeaderEnum {
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
