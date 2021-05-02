package com.example.themovie.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.themovie.R;
import com.example.themovie.api.model.TokenResModel;
import com.example.themovie.view.viewmodel.BaseViewModel;
import com.example.themovie.view.viewmodel.M001LoginModel;


public class M001LoginFrg extends BaseFragment<M001LoginModel> {
    public static final String KEY_SHOW_M002 = "KEY_SHOW_M002";
    private static final String TAG = M001LoginFrg.class.getName();
    private EditText edtUserName, edtPass;
    private CheckBox cbRemem;
    private TextView tvSignUp;

    @Override
    protected void initViews() {
        findViewById(R.id.tv_login).setOnClickListener(this);
        edtUserName = findViewById(R.id.edt_user_name);
        edtPass = findViewById(R.id.edt_pass);
        cbRemem = findViewById(R.id.cb_remember);
        tvSignUp = findViewById(R.id.tv_sign_up);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void clickView(View v, int id) {
        if (v.getId() == R.id.tv_login && cbRemem.isChecked()) {
            doLogin(edtUserName.getText().toString(), edtPass.getText().toString(), 1);
        } else if (v.getId() == R.id.tv_login && !cbRemem.isChecked()) {
            doLogin(edtUserName.getText().toString(), edtPass.getText().toString(), 0);
        } else if (v.getId() == R.id.tv_sign_up) {
            doSignUp();
        }

    }

    private void doSignUp() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/signup"));
        startActivity(browserIntent);

    }


    private void doLogin(String userName, String pass, int check) {
        if (userName.isEmpty() || pass.isEmpty()) {
            notify("Please input value");
            return;
        }
        mModel.setCheck(check);
        mModel.login(userName, pass);
    }


    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(BaseViewModel.KEY_NOTIFY)) {
            notify(data.toString());
        } else if (key.equals(M001LoginModel.API_KEY_LOGIN)) {
            doAfterLogin((TokenResModel) data);

        }
    }

    private void doAfterLogin(TokenResModel data) {
        notify("Login suceess");
        callBack.onCallBack(KEY_SHOW_M002, null);
    }

    @Override
    protected Class<M001LoginModel> getClassViewModel() {
        return M001LoginModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m001_login;
    }
}
