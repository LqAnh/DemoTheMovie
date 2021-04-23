package com.example.themovie.view.fragment;

import android.os.Handler;
import android.util.Log;

import com.example.themovie.CommonUtils;
import com.example.themovie.R;
import com.example.themovie.view.viewmodel.M001LoginModel;


public class M000SplashFrg extends BaseFragment<M001LoginModel> {
    public static final String KEY_LOGIN = "KEY_LOGIN";
    public static final String KEY_MOVIE_DISCOVER = "KEY_MOVIE_DISCOVER";
    private static final String TAG = M000SplashFrg.class.getName() ;

    @Override
    protected void initViews() {
        checkExitsAcc();

    }

    private void checkExitsAcc() {
        if (CommonUtils.getInstance().isExistPref("TOKEN_REQ")){
            Log.i(TAG, "checkExitsAcc: " + CommonUtils.getInstance().isExistPref("TOKEN_REQ"));
            new Handler().postDelayed(this::goToFilmDiscoverFrg, 1000);
        }else {
            new Handler().postDelayed(this::goToLoginFrg, 1000);
        }
    }

    private void goToFilmDiscoverFrg() {
        callBack.onCallBack(KEY_MOVIE_DISCOVER, null);
    }

    private void goToLoginFrg() {
        callBack.onCallBack(KEY_LOGIN, null);
    }

    @Override
    protected Class<M001LoginModel> getClassViewModel() {
        return M001LoginModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m000_splash;
    }
}
