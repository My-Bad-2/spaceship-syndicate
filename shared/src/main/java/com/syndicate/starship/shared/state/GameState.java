package com.syndicate.starship.shared.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class GameState {
    public long sessionID;
    public GameStatus status = GameStatus.LOBBY;

    public ShipState playerShip = new ShipState();
    public Map<String, PlayerState> players = new HashMap<>();
    public Map<Integer, EnemyState> enemies = new HashMap<>();
    public List<ProjectileState> projectiles = new ArrayList<>();

    public float missionTimer;

    public GameState() {}

    public enum GameStatus {
        LOBBY,
        IN_PROGRESS,
        VICTORY,
        DEFEAT,
    }
}
