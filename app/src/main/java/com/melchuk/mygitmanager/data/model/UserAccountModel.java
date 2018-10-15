package com.melchuk.mygitmanager.data.model;

import com.melchuk.mygitmanager.data.interactors.UserAccountConnect;
import com.melchuk.mygitmanager.presenter.UserAccountPresenter;
import com.melchuk.mygitmanager.presenter.UserAccountPresenterToModelInterface;

public class UserAccountModel implements UserAccountPresenterToModelInterface {

    public UserAccountModel() {
    }

    @Override
    public boolean connect(String login, String password) {
        UserAccountConnect userAccountConnect = new UserAccountConnect();
        return userAccountConnect.dbConnect(login, password);
    }
}
