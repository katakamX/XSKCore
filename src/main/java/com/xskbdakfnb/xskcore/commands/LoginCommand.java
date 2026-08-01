package com.xskbdakfnb.xskcore.commands;

import com.xskbdakfnb.xskcore.managers.AuthManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoginCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§cUsage: /login <password>");
            return true;
        }

        if (AuthManager.login(player.getUniqueId(), args[0])) {

            player.sendMessage("§aSuccessfully logged in!");

        } else {

            player.sendMessage("§cInvalid password or you are not registered.");

        }

        return true;
    }

}