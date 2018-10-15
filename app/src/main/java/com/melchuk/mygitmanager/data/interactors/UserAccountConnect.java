package com.melchuk.mygitmanager.data.interactors;

public class UserAccountConnect implements UserAccountConnector {

    @Override
    public boolean dbConnect(String login, String password) {
        boolean isConnectedOk = false;

        //Check db test response
        if(login.contentEquals("admin") && password.contentEquals("password")) isConnectedOk = true;

        return isConnectedOk;
    }
}
