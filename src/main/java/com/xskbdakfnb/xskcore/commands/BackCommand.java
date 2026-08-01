package com.xskbdakfnb.xskcore.commands;

import com.xskbdakfnb.xskcore.managers.BackManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (!BackManager.hasDeathLocation(player.getUniqueId())) {
            player.sendMessage("§cYou have no saved death location.");
            return true;
        }

        player.teleport(BackManager.getDeathLocation(player.getUniqueId()));
        player.sendMessage("§aTeleported to your last death location.");

        return true;
    }
}