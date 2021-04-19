package com.techja.demothemovie.view.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.techja.demothemovie.CommonUtils;
import com.techja.demothemovie.R;
import com.techja.demothemovie.api.model.TokenResModel;
import com.techja.demothemovie.view.viewmodel.BaseViewModel;
import com.techja.demothemovie.view.viewmodel.M001LoginModel;

public class M001LoginFrg extends BaseFragment<M001LoginModel> {
    public static final String KEY_SHOW_M002 = "KEY_SHOW_M002" ;
    private static final String TAG = M001LoginFrg.class.getName();
    private static final String KEY_USERNAME = "KEY_USERNAME";
    private static final String KEY_PASS = "KEY_PASS";
    private EditText edtUserName, edtPass;
    private CheckBox cbRemem;

    @Override
    protected void initViews() {
        findViewById(R.id.tv_login).setOnClickListener(this);
        edtUserName = findViewById(R.id.edt_user_name);
        edtPass = findViewById(R.id.edt_pass);
        cbRemem = findViewById(R.id.cb_remember);
        cbRemem.setOnClickListener(this);



        String userName = CommonUtils.getInstance().getPref(KEY_USERNAME);
        String pass = CommonUtils.getInstance().getPref(KEY_PASS);
        doLogin(userName, pass);
        if (userName != null && pass != null){
            edtUserName.setText(userName);
            cbRemem.setChecked(true);
            edtPass.setText(pass);


        }



    }

    @Override
    public void clickView(View v, int id) {
        if (v.getId() == R.id.tv_login){
            doLogin(edtUserName.getText().toString(), edtPass.getText().toString());
        }else if (v.getId() == R.id.cb_remember){
            remeberAcc();
        }

    }


    private void doLogin(String userName, String pass) {
        if (userName.isEmpty() || pass.isEmpty()){
            notify("Please input value");
            return;
        }
        mModel.login(userName, pass);
    }

    private void remeberAcc(){
        if (cbRemem.isChecked() && !edtUserName.getText().toString().isEmpty()
                || cbRemem.isChecked() && !edtPass.getText().toString().isEmpty()) {
            CommonUtils.getInstance().savePref(KEY_USERNAME, edtUserName.getText().toString());
            CommonUtils.getInstance().savePref(KEY_PASS, edtPass.getText().toString());

        }else if (!cbRemem.isChecked()){
            CommonUtils.getInstance().clearPref(KEY_USERNAME);
            CommonUtils.getInstance().clearPref(KEY_PASS);

        }
    }

    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(BaseViewModel.KEY_NOTIFY)){
            notify(data.toString());
        }else if (key.equals(M001LoginModel.API_KEY_LOGIN)){
            doAfterLogin((TokenResModel)data);

        }
    }

    private void doAfterLogin(TokenResModel data) {

        notify("Login suceess");
        callBack.onCallBack(KEY_SHOW_M002,null);
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
