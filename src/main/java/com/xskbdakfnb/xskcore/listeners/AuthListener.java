package com.xskbdakfnb.xskcore.listeners;

import com.xskbdakfnb.xskcore.managers.AuthManager;
import com.xskbdakfnb.xskcore.managers.PlayerDataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AuthListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (PlayerDataManager.isRegistered(event.getPlayer().getUniqueId())) {

            PlayerDataManager.getPlayerData(event.getPlayer().getUniqueId()).setLoggedIn(false);

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

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (AuthManager.isLoggedIn(event.getPlayer().getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (AuthManager.isLoggedIn(event.getPlayer().getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {

        if (AuthManager.isLoggedIn(event.getPlayer().getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {

        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (AuthManager.isLoggedIn(player.getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (AuthManager.isLoggedIn(player.getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (AuthManager.isLoggedIn(player.getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {

        if (!(event.getPlayer() instanceof Player player)) {
            return;
        }

        if (AuthManager.isLoggedIn(player.getUniqueId())) {
            return;
        }

        event.setCancelled(true);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        if (PlayerDataManager.isRegistered(event.getPlayer().getUniqueId())) {
            PlayerDataManager.getPlayerData(event.getPlayer().getUniqueId()).setLoggedIn(false);
        }

    }

}