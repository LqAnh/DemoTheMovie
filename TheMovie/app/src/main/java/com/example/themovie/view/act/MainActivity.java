package com.example.themovie.view.act;


import com.example.themovie.OnActionCallBack;
import com.example.themovie.R;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.view.fragment.M000SplashFrg;
import com.example.themovie.view.fragment.M001LoginFrg;
import com.example.themovie.view.fragment.M002MovieListFrg;
import com.example.themovie.view.fragment.M003DetailFilmFrg;
import com.example.themovie.view.fragment.M004Frg;
import com.example.themovie.view.fragment.M005ReviewFrg;
import com.example.themovie.view.fragment.M007AccountFrg;
import com.example.themovie.view.viewmodel.MainViewModel;

public class MainActivity extends BaseAct<MainViewModel> implements OnActionCallBack {

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected void initViews() {
        M000SplashFrg m000SplashFrg = new M000SplashFrg();
        m000SplashFrg.setCallBack(this);
        showFragment(R.id.ln_main, m000SplashFrg, false);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCallBack(String key, Object data) {
        switch (key) {
            case M000SplashFrg.KEY_LOGIN:
            case M002MovieListFrg.KEY_LOGIN_AGAIN:
                M001LoginFrg m001LoginFrg = new M001LoginFrg();
                m001LoginFrg.setCallBack(this);
                showFragment(R.id.ln_main, m001LoginFrg, false);
                break;

            case M000SplashFrg.KEY_MOVIE_DISCOVER:
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

            case M002MovieListFrg.KEY_SHOW_ACCOUNT:
                M007AccountFrg m007AccountFrg = new M007AccountFrg();
                m007AccountFrg.setCallBack(this);
                showFragment(R.id.ln_main, m007AccountFrg, true);
                break;
            case M003DetailFilmFrg.KEY_SHOW_TRAILER:
                M004Frg m004Frg = new M004Frg();
                MovieModel.Result film1 = (MovieModel.Result) data;
                m004Frg.setFilm(film1);
                m004Frg.setCallBack(this);
                showFragment(R.id.ln_main, m004Frg, true);
                break;

            case M003DetailFilmFrg.KEY_SHOW_REVIEW:
                M005ReviewFrg m005ReviewFrg = new M005ReviewFrg();
                MovieModel.Result film2 = (MovieModel.Result) data;
                m005ReviewFrg.setFilm(film2);
                m005ReviewFrg.setCallBack(this);
                showFragment(R.id.ln_main, m005ReviewFrg, true);
                break;
        }

    }
}