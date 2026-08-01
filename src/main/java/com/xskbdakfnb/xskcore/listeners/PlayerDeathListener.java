package com.xskbdakfnb.xskcore.listeners;

import com.xskbdakfnb.xskcore.managers.BackManager;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Location deathLocation = event.getPlayer().getLocation();

        BackManager.setDeathLocation(
                event.getPlayer().getUniqueId(),
                deathLocation
        );

        event.getPlayer().sendMessage("§c☠ You died!");

        event.getPlayer().sendMessage(
                "§7Coordinates: §eX: "
                        + deathLocation.getBlockX()
                        + " Y: "
                        + deathLocation.getBlockY()
                        + " Z: "
                        + deathLocation.getBlockZ()
        );

        event.getPlayer().sendMessage("§aUse /back to return here.");

    }

}