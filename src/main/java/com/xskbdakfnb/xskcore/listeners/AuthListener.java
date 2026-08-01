package com.xskbdakfnb.xskcore.listeners;

import com.xskbdakfnb.xskcore.managers.AuthManager;
import com.xskbdakfnb.xskcore.managers.PlayerDataManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class AuthListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (PlayerDataManager.isRegistered(event.getPlayer().getUniqueId())) {

            event.getPlayer().sendMessage("§ePlease login using:");
            event.getPlayer().sendMessage("§a/login <password>");

        } else {

            event.getPlayer().sendMessage("§eWelcome!");
            event.getPlayer().sendMessage("§aPlease register using:");
            event.getPlayer().sendMessage("§a/register <password> <confirm>");

        }

    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if (AuthManager.isLoggedIn(event.getPlayer().getUniqueId())) {
            return;
        }

        if (event.getFrom().getBlockX() != event.getTo().getBlockX()
                || event.getFrom().getBlockY() != event.getTo().getBlockY()
                || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {

            event.setTo(event.getFrom());

        }

    }

}