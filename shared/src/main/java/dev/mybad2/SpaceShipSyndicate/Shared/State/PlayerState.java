package dev.mybad2.SpaceShipSyndicate.Shared.State;

public class PlayerState {
    public long userId;
    public long currSessionId;
    public String userName;

    public boolean isGameInProgress;
    public PlayerStatus currStatus;

    public float oxygenLevel;

    public enum PlayerRole {
        PILOT,
        CAPTAIN,
        HELMSMEN,
        TECHNICIAN,
    }

    public enum PlayerStatus {
        LOBBY,
        PILOT_VIEW,
        HELMSMEN_VIEW,
        CAPTAIN_VIEW,
        TECHNICIAN_VIEW,
    }
}
