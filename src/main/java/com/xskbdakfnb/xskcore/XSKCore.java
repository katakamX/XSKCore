package com.xskbdakfnb.xskcore;

import com.xskbdakfnb.xskcore.commands.BackCommand;
import com.xskbdakfnb.xskcore.commands.LoginCommand;
import com.xskbdakfnb.xskcore.commands.RegisterCommand;
import com.xskbdakfnb.xskcore.listeners.AuthListener;
import com.xskbdakfnb.xskcore.listeners.PlayerDeathListener;
import com.xskbdakfnb.xskcore.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class XSKCore extends JavaPlugin {

    @Override
    public void onEnable() {

        // Create plugin data folder
        File dataFolder = getDataFolder();

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        // Create players.yml if it doesn't exist
        File playersFile = new File(dataFolder, "players.yml");

        if (!playersFile.exists()) {
            try {
                playersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Register event listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new AuthListener(), this);

        // Register commands
        getCommand("back").setExecutor(new BackCommand());
        getCommand("register").setExecutor(new RegisterCommand());
        getCommand("login").setExecutor(new LoginCommand());

        getLogger().info("================================");
        getLogger().info("XSKCore v1.0 Enabled!");
        getLogger().info("Developed by xskbdakfnb");
        getLogger().info("================================");
    }

    @Override
    public void onDisable() {

        getLogger().info("XSKCore Disabled!");

    }
}