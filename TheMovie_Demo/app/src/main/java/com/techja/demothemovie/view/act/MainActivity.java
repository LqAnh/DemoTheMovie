package com.techja.demothemovie.view.act;

import com.techja.demothemovie.OnActionCallBack;
import com.techja.demothemovie.R;
import com.techja.demothemovie.api.model.MovieModel;
import com.techja.demothemovie.view.fragment.M001LoginFrg;
import com.techja.demothemovie.view.fragment.M002MovieListFrg;
import com.techja.demothemovie.view.fragment.M003DetailFilmFrg;
import com.techja.demothemovie.view.viewmodel.MainViewModel;

public class MainActivity extends BaseAct<MainViewModel> implements OnActionCallBack {

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected void initViews() {
        M001LoginFrg mainFrg = new M001LoginFrg();
        mainFrg.setCallBack(this);
        showFragment(R.id.ln_main, mainFrg, false);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCallBack(String key, Object data) {
        switch (key){
            case M001LoginFrg.KEY_SHOW_M002:
                M002MovieListFrg m002MovieListFrg = new M002MovieListFrg();
                m002MovieListFrg.setCallBack(this);

                showFragment(R.id.ln_main, m002MovieListFrg, false);
                break;

            case M002MovieListFrg.KEY_SHOW_DETAIL:
                M003DetailFilmFrg m003DetailFilmFrg = new M003DetailFilmFrg();
                MovieModel.Result film = (MovieModel.Result) data;
                m003DetailFilmFrg.setFilm(film);
                m003DetailFilmFrg.setCallBack(this);
                showFragment(R.id.ln_main, m003DetailFilmFrg, true);
                break;










        }

    }
}