package com.xskbdakfnb.xskcore.managers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StarterKitManager {

    public void giveStarterKit(Player player) {

        player.getInventory().addItem(
                new ItemStack(Material.IRON_INGOT, 3),
                
                new ItemStack(Material.COAL, 24),
                new ItemStack(Material.OAK_LOG, 32)
        );

        player.sendMessage("§eYou received your Starter Kit!");

    }

}