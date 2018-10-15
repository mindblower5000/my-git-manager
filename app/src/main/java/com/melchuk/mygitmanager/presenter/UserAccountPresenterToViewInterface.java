package com.melchuk.mygitmanager.presenter;

import com.arellomobile.mvp.MvpView;

public interface UserAccountPresenterToViewInterface extends MvpView {
    void connectedOk();
    void connectedNotOk();
}
