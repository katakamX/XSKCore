package com.xskbdakfnb.xskcore.commands;

import com.xskbdakfnb.xskcore.managers.AuthManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 2) {
            player.sendMessage("§cUsage: /register <password> <confirm>");
            return true;
        }

        if (!args[0].equals(args[1])) {
            player.sendMessage("§cPasswords do not match.");
            return true;
        }

        if (AuthManager.register(player.getUniqueId(), args[0])) {
            player.sendMessage("§aRegistration successful!");
            player.sendMessage("§eNow use /login <password>");
        } else {
            player.sendMessage("§cYou are already registered.");
        }

        return true;
    }
}