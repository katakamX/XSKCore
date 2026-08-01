package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.data.PlayerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
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

    public static void savePlayer(UUID uuid, String password) {

        File file = new File("plugins/XSKCore/players.yml");

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("players." + uuid + ".password", password);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}