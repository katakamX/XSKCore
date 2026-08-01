package com.xskbdakfnb.xskcore.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashUtils {

    private HashUtils() {
        // Prevent instantiation
    }

    public static String hashPassword(String password) {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();

            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }

            return hex.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.", e);
        }

    }

}