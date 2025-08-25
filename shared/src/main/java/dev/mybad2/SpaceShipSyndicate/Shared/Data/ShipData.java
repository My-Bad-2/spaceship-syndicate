package dev.mybad2.SpaceShipSyndicate.Shared.Data;

import java.util.HashMap;

public class ShipData {
    private String id;
    private String name;
    private float maxHealth;
    private float maxShields;
    private int cargoSize;
    private HashMap<String, Integer> MaxComponentsHealth;
    private int powerCapacity;

    public ShipData() {
        this.MaxComponentsHealth = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getMaxShields() {
        return maxShields;
    }

    public void setMaxShields(float maxShields) {
        this.maxShields = maxShields;
    }

    public int getCargoSize() {
        return cargoSize;
    }

    public void setCargoSize(int cargoSize) {
        this.cargoSize = cargoSize;
    }

    public HashMap<String, Integer> getMaxComponentsHealth() {
        return MaxComponentsHealth;
    }

    public void setMaxComponentsHealth(HashMap<String, Integer> maxComponentsHealth) {
        MaxComponentsHealth = maxComponentsHealth;
    }

    public int getPowerCapacity() {
        return powerCapacity;
    }

    public void setPowerCapacity(int powerCapacity) {
        this.powerCapacity = powerCapacity;
    }
}
