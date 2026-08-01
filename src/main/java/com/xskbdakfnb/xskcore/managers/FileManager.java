package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.XSKCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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

    public static FileConfiguration getPlayersConfig() {
        return playersConfig;
    }

    public static void savePlayersConfig() {

        try {
            playersConfig.save(playersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}