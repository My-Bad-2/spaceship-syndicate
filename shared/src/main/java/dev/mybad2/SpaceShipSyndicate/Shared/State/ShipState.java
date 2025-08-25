package dev.mybad2.SpaceShipSyndicate.Shared.State;

import dev.mybad2.SpaceShipSyndicate.Shared.Data.ShipData;

import java.util.HashMap;
import java.util.Map;

public class ShipState {
    public ShipData shipData;
    public float currHealth;
    public float currShields;
    public int currCargoNum;

    public Map<String, Long> players;
    public Map<String, Integer> componentsHealth;

    public ShipState(ShipData shipData) {
        this.shipData = shipData;
        this.players = new HashMap<>();
        this.componentsHealth = new HashMap<>();
    }
}
