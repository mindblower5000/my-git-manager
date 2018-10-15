package com.melchuk.mygitmanager.data.interactors;

public interface UserAccountConnector {
    public boolean dbConnect(String login, String password);
}
