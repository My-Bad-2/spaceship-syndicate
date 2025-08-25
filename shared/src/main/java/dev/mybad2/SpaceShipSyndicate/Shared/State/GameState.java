package dev.mybad2.SpaceShipSyndicate.Shared.State;

import java.util.HashMap;

public class GameState {
    public long sessionId;
    public GameStatus status;
    public ShipState playerShip;
    public HashMap<String, PlayerState> players;

    public float missionTimer;
    public String missionObjective;

    public enum GameStatus {
        LOBBY,
        IN_PROGRESS,
        PAUSED,
        VICTORY,
        DEFEAT,
    }

    public GameState() {
        this.players = new HashMap<>();
    }
}
