package com.xskbdakfnb.xskcore.managers;

import com.xskbdakfnb.xskcore.data.PlayerData;
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

        PlayerData playerData = PlayerDataManager.getPlayerData(uuid);
        String storedPassword = playerData.getPassword();

        // New account (already hashed)
        if (storedPassword.length() == 64) {

            String hashedPassword = HashUtils.hashPassword(password);

            if (!storedPassword.equals(hashedPassword)) {
                return false;
            }

        }
        // Old account (plain text)
        else {

            if (!storedPassword.equals(password)) {
                return false;
            }

            // Migrate to SHA-256
            String hashedPassword = HashUtils.hashPassword(password);

            playerData.setPassword(hashedPassword);

            FileManager.savePlayer(uuid, hashedPassword);

        }

        playerData.setLoggedIn(true);

        return true;
    }

    public static boolean isLoggedIn(UUID uuid) {

        if (!PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        return PlayerDataManager.getPlayerData(uuid).isLoggedIn();
    }

}