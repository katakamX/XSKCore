package com.xskbdakfnb.xskcore;

import com.xskbdakfnb.xskcore.commands.BackCommand;
import com.xskbdakfnb.xskcore.commands.LoginCommand;
import com.xskbdakfnb.xskcore.commands.RegisterCommand;
import com.xskbdakfnb.xskcore.listeners.AuthListener;
import com.xskbdakfnb.xskcore.listeners.PlayerDeathListener;
import com.xskbdakfnb.xskcore.listeners.PlayerJoinListener;
import com.xskbdakfnb.xskcore.managers.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class XSKCore extends JavaPlugin {

    @Override
    public void onEnable() {

        File dataFolder = getDataFolder();

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        FileManager.initialize(this);

        getLogger().info("Calling FileManager.loadPlayers()");

        FileManager.loadPlayers();

        // Register listeners
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