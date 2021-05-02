package com.example.themovie.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.themovie.R;
import com.example.themovie.view.viewmodel.M007AccountModel;



public class M007AccountFrg extends BaseFragment<M007AccountModel>{
    private TextView resetPass;
    @Override
    protected void initViews() {
        resetPass = findViewById(R.id.tv_reset_pass);
        resetPass.setOnClickListener(this);
    }

    @Override
    protected void clickView(View v, int id) {
        if (v.getId() == R.id.tv_reset_pass){
            doReset();
        }
    }

    private void doReset() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/reset-password"));
        startActivity(browserIntent);
    }

    @Override
    protected Class<M007AccountModel> getClassViewModel() {
        return M007AccountModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m007_account;
    }
}
