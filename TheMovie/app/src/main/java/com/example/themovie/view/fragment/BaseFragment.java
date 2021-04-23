package com.example.themovie.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.themovie.App;
import com.example.themovie.OnActionCallBack;
import com.example.themovie.R;
import com.example.themovie.Storage;
import com.example.themovie.view.viewmodel.BaseViewModel;


public abstract class BaseFragment<T extends BaseViewModel> extends Fragment
        implements View.OnClickListener, OnActionCallBack {
    protected T mModel;
    protected View rootView;
    protected Context mContext;
    protected OnActionCallBack callBack;

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        mModel = new ViewModelProvider(this).get(getClassViewModel());
        mModel.setCallBack(this);
        initViews();
        return rootView;
    }

    public void setCallBack(OnActionCallBack callBack) {
        this.callBack = callBack;
    }

    protected abstract void initViews();

    protected abstract Class<T> getClassViewModel();

    protected abstract int getLayoutId();

    public final <G extends View> G findViewById(int id, View.OnClickListener event) {
        G v = rootView.findViewById(id);
        if (v != null && event != null) {
            v.setOnClickListener(this);
        }
        return v;
    }

    public final <J extends View> J findViewById(int id) {
        return findViewById(id, null);
    }

    @Override
    public final void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.abc_grow_fade_in_from_bottom));
        clickView(v, v.getId());
    }

    protected void clickView(View v, int id) {
        //do nothing
    }

    @Override
    public void onCallBack(String key, Object data) {

    }

    protected final Storage getStorage() {
        return App.getInstance().getStorage();
    }

    protected final void notify(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
