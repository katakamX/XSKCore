package com.xskbdakfnb.xskcore.managers;

import java.util.UUID;

public class AuthManager {

    public static boolean register(UUID uuid, String password) {

        if (PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        PlayerDataManager.register(uuid, password);
        return true;
    }

    public static boolean login(UUID uuid, String password) {

        if (!PlayerDataManager.isRegistered(uuid)) {
            return false;
        }

        if (!PlayerDataManager.getPlayerData(uuid).getPassword().equals(password)) {
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