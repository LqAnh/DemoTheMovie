package com.techja.demothemovie.view.viewmodel;

import android.util.Log;

import com.techja.demothemovie.CommonUtils;
import com.techja.demothemovie.api.API;
import com.techja.demothemovie.api.model.AccReqModel;
import com.techja.demothemovie.api.model.TokenResModel;

public class M001LoginModel extends BaseViewModel {
    private static final String TAG = M001LoginModel.class.getName();
    private static final String API_KEY_GET_REQ_TOKEN = "API_KEY_GET_REQ_TOKEN";
    public static final String API_KEY_LOGIN = "API_KEY_LOGIN";

    private String username, pass;

    public void login(String userName, String pass) {
        this.username = userName;
        this.pass = pass;
        // call api getTokenReq
        API apis = getWS().create(API.class);
        apis.getTokenReq().enqueue(initHandlerRes(API_KEY_GET_REQ_TOKEN));
    }



    @Override
    protected <T> void handleSuccess(String key, T body) {
        Log.i(TAG, "handleSuccess: " + key);
        Log.i(TAG, "handleSuccess: " + body);

        if (key.equals(API_KEY_GET_REQ_TOKEN)) {
            saveTokenReq((TokenResModel) body);
        } else if (key.equals(API_KEY_LOGIN)) {
            doAfterLogin((TokenResModel) body);
        }
    }

    private void doAfterLogin(TokenResModel body) {
        // call to ui
        callBack.onCallBack(API_KEY_LOGIN, body);

    }

    private void saveTokenReq(TokenResModel body) {
        CommonUtils.getInstance().savePref(BaseViewModel.TOKEN_REQ, body.getRequestToken());

        AccReqModel acc =
                new AccReqModel(username, pass, body.getRequestToken());
        API apis = getWS().create(API.class);
        apis.login(acc).enqueue(initHandlerRes(API_KEY_LOGIN));

    }

    @Override
    protected void handleFail(String key, Object errorBody) {
        Log.e(TAG, "handleFail: key = " + key);
        Log.e(TAG, "handleFail: error = " + errorBody);
        
        callBack.onCallBack(BaseViewModel.KEY_NOTIFY, errorBody);
    }
}
