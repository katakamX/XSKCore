package com.xskbdakfnb.xskcore.listeners;

import com.xskbdakfnb.xskcore.managers.StarterKitManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final StarterKitManager starterKitManager = new StarterKitManager();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        // Every player gets this message every time they join
        event.getPlayer().sendMessage("§aWelcome to XSK Server!");

        // Only first-time players get the starter kit
        if (!event.getPlayer().hasPlayedBefore()) {

            starterKitManager.giveStarterKit(event.getPlayer());

        }

    }
}