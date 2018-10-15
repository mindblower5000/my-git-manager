package com.melchuk.mygitmanager.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.melchuk.mygitmanager.data.model.UserAccountModel;
import com.melchuk.mygitmanager.view.user.UserDataFragmentView;

@InjectViewState
public class UserAccountPresenter extends MvpPresenter<UserAccountPresenterToViewInterface> {

    private UserAccountModel userAccountModel;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        userAccountModel = new UserAccountModel();
        Log.d("Dto", "first attach");
    }


    public void attachView(UserDataFragmentView view) {
        super.attachView(view);
        Log.d("Dto", "attach view");
    }


    public void buttonLoginCheck(String login, String password){

        if(userAccountModel.connect(login, password))
            getViewState().connectedOk();
        else
            getViewState().connectedNotOk();

    }
}
