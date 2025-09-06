package com.syndicate.starship.shared.state;

import com.syndicate.starship.shared.common.SystemType;
import java.util.HashMap;
import java.util.Map;

public class ShipState {
    public float posX, posY;
    public float velX, velY;
    public float rotationDegrees;

    public float currHealth;
    public float currShields;

    public Map<SystemType, Integer> powerLevels = new HashMap<>();
    public Map<SystemType, SystemStatus> systemStatus = new HashMap<>();
    public Map<Integer, Float> weaponCooldowns = new HashMap<>();

    public static class SystemStatus {
        public float health = 100.0f;
        public boolean onFire = false;
        public boolean isOvercharged = false;

        public SystemStatus() {}
    }
}
