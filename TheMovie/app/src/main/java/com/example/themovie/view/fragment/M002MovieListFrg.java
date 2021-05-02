package com.example.themovie.view.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovie.CommonUtils;
import com.example.themovie.R;
import com.example.themovie.adapter.FilmAdapter;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.view.viewmodel.M002ListFilmModel;


public class M002MovieListFrg extends BaseFragment<M002ListFilmModel> implements FilmAdapter.OnItemClick {
    private static final String TAG = M002MovieListFrg.class.getName();
    public static final String KEY_SHOW_DETAIL = "KEY_SHOW_DETAIL";
    public static final String KEY_LOGIN_AGAIN = "KEY_LOGIN_AGAIN";
    public static final String KEY_SHOW_ACCOUNT = "KEY_SHOW_ACCOUNT";

    private RecyclerView rvFilm;
    private ImageView ivLogOut, ivAcc;

    @SuppressLint("CutPasteId")
    @Override
    protected void initViews() {
        rvFilm = findViewById(R.id.rv_movie);
        ivLogOut = findViewById(R.id.iv_log_out);
        ivLogOut.setOnClickListener(this);
        ivAcc = findViewById(R.id.iv_account);
        ivAcc.setOnClickListener(this);
        rvFilm.setLayoutManager(new LinearLayoutManager(mContext));
        mModel.getListFilm();


    }

    @Override
    protected void clickView(View v, int id) {
        if (v.getId() == R.id.iv_log_out){
            new AlertDialog.Builder(getContext())
                    .setTitle("Confirm")
                    .setPositiveButton("YES!", (dialog, which) -> {
                        callBack.onCallBack(KEY_LOGIN_AGAIN, null);
                        CommonUtils.getInstance().clearPref("TOKEN_REQ");
                    })
                    .setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel())
                    .setMessage("Do you want log out now?")
                    .show();
        }else if (v.getId() == R.id.iv_account){
            goToM007();
        }
    }

    private void goToM007() {
        callBack.onCallBack(KEY_SHOW_ACCOUNT, null);
    }

    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(M002ListFilmModel.KEY_NOTIFY)){
            notify((String) data);
        }else if (key.equals(M002ListFilmModel.API_KEY_LIST_FILM )){
            MovieModel movieModel = (MovieModel) data;

            Log.i(TAG, "onCallBack: " + key + ": " + movieModel.getListResult().size());


            FilmAdapter adapter = new FilmAdapter(movieModel.getListResult(), mContext);
            adapter.setmCallBack(this);
            rvFilm.setAdapter(adapter);
        }
    }

    public void onItemClick(MovieModel.Result film){
        callBack.onCallBack(KEY_SHOW_DETAIL, film);
    }



    @Override
    protected Class<M002ListFilmModel> getClassViewModel() {
        return M002ListFilmModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m002_home;
    }
}
