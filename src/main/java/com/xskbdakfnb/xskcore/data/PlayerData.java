package com.xskbdakfnb.xskcore.data;

public class PlayerData {

    private String password;
    private boolean loggedIn;

    public PlayerData(String password) {
        this.password = password;
        this.loggedIn = false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}