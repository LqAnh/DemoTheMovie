package com.techja.demothemovie.view.fragment;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.demothemovie.R;
import com.techja.demothemovie.adapter.FilmAdapter;
import com.techja.demothemovie.api.model.MovieModel;
import com.techja.demothemovie.view.viewmodel.M002ListFilmModel;
public class M002MovieListFrg extends BaseFragment<M002ListFilmModel> implements FilmAdapter.OnItemClick {
    private static final String TAG = M002MovieListFrg.class.getName();
    public static final String KEY_SHOW_DETAIL = "KEY_SHOW_DETAIL";
    private RecyclerView rvFilm;

    @SuppressLint("CutPasteId")
    @Override
    protected void initViews() {
        rvFilm = findViewById(R.id.rv_movie);
        rvFilm.setLayoutManager(new LinearLayoutManager(mContext));
        mModel.getListFilm();


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
