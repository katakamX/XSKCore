package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.utils.HashUtils;

import java.util.UUID;

public class AuthManager {

    public static boolean register(UUID uuid, String password) {

        if (PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        PlayerDataManager.register(uuid, password);

        // Save hashed password to players.yml
        FileManager.savePlayer(uuid, password);

        return true;
    }

    public static boolean login(UUID uuid, String password) {

        if (!PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        // Hash the password entered by the player
        String hashedPassword = HashUtils.hashPassword(password);

        if (!PlayerDataManager.getPlayerData(uuid).getPassword().equals(hashedPassword)) {
            return false;
        }

        PlayerDataManager.getPlayerData(uuid).setLoggedIn(true);

        return true;
    }

    public static boolean isLoggedIn(UUID uuid) {

        if (!PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        return PlayerDataManager.getPlayerData(uuid).isLoggedIn();
    }

}