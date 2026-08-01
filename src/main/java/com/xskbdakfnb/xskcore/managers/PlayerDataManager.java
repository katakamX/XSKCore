package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.data.PlayerData;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDataManager {

    private static final HashMap<UUID, PlayerData> playerData = new HashMap<>();

    public static void register(UUID uuid, String password) {
        playerData.put(uuid, new PlayerData(password));
    }

    public static boolean isRegistered(UUID uuid) {
        return playerData.containsKey(uuid);
    }

    public static PlayerData getPlayerData(UUID uuid) {
        return playerData.get(uuid);
    }

    public static HashMap<UUID, PlayerData> getAllPlayers() {
        return playerData;
    }

}