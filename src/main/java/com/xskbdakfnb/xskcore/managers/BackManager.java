package com.xskbdakfnb.xskcore.managers;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.UUID;

public class BackManager {

    private static final HashMap<UUID, Location> deathLocations = new HashMap<>();

    public static void setDeathLocation(UUID uuid, Location location) {
        deathLocations.put(uuid, location);
    }

    public static Location getDeathLocation(UUID uuid) {
        return deathLocations.get(uuid);
    }

    public static boolean hasDeathLocation(UUID uuid) {
        return deathLocations.containsKey(uuid);
    }

}