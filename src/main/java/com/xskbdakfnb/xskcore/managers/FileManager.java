package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.XSKCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    private static File playersFile;
    private static FileConfiguration playersConfig;

    public static void initialize(XSKCore plugin) {

        playersFile = new File(plugin.getDataFolder(), "players.yml");

        if (!playersFile.exists()) {
            try {
                playersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        playersConfig = YamlConfiguration.loadConfiguration(playersFile);

    }

    public static void savePlayer(UUID uuid, String password) {

        playersConfig.set("players." + uuid + ".password", password);

        try {
            playersConfig.save(playersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadPlayers() {

        XSKCore plugin = JavaPlugin.getPlugin(XSKCore.class);

        plugin.getLogger().info("Loading players...");

        if (!playersConfig.contains("players")) {
            plugin.getLogger().warning("No players section found!");
            return;
        }

        for (String uuidString : playersConfig.getConfigurationSection("players").getKeys(false)) {

            String password = playersConfig.getString("players." + uuidString + ".password");

            plugin.getLogger().info("Loaded player: " + uuidString);

            PlayerDataManager.register(UUID.fromString(uuidString), password);

        }

        plugin.getLogger().info("Finished loading players.");

    }

    public static FileConfiguration getPlayersConfig() {
        return playersConfig;
    }
}