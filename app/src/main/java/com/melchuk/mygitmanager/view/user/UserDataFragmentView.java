package com.melchuk.mygitmanager.view.user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;


import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.melchuk.mygitmanager.R;
import com.melchuk.mygitmanager.presenter.UserAccountPresenter;
import com.melchuk.mygitmanager.presenter.UserAccountPresenterToViewInterface;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnUserDataFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserDataFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDataFragmentView extends MvpAppCompatFragment implements UserAccountPresenterToViewInterface {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private OnUserDataFragmentInteractionListener mListener;

    @BindView(R.id.input_email)     EditText _emailText;
    @BindView(R.id.input_password)  EditText _passwordText;
    @BindView(R.id.btn_login)       Button  _loginButton;
    @BindView(R.id.link_signup)     TextView _signupLink;


    @InjectPresenter
    UserAccountPresenter userAccountPresenter;


    public UserDataFragmentView() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserDataFragmentView.
     */

    public static UserDataFragmentView newInstance(String param1, String param2) {
        UserDataFragmentView fragment = new UserDataFragmentView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //userAccountPresenter.isLoggedIn();

        userAccountPresenter = new UserAccountPresenter();

       _loginButton.setOnClickListener(v -> userAccountPresenter.buttonLoginCheck(_emailText.getText().toString().trim(), _passwordText.getText().toString().trim()));

//        _signupLink.setOnClickListener(v -> {
//            // Start the Signup activity
//            //Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
//            //startActivityForResult(intent, REQUEST_SIGNUP);
//        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUserDataFragmentInteractionListener) {
            mListener = (OnUserDataFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnUserDataFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnUserDataFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void connectedOk() {
        //UI ok
    }

    @Override
    public void connectedNotOk() {
        //UI not ok
    }
}
