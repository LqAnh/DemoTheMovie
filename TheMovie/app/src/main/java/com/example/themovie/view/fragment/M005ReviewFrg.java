package com.example.themovie.view.fragment;

import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovie.R;
import com.example.themovie.adapter.ReviewAdapter;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.api.model.ReviewFilmModel;
import com.example.themovie.view.viewmodel.M005FilmReviewModel;


public class M005ReviewFrg extends BaseFragment<M005FilmReviewModel> {
    public static final String TAG = M005ReviewFrg.class.getName();
    private MovieModel.Result film;
    private TextView tvAuthor, tvContentRv;
    private RecyclerView rvReview;

    @Override
    protected void initViews() {

        rvReview = findViewById(R.id.recycleview_review);
        rvReview.setLayoutManager(new LinearLayoutManager(mContext));
        mModel.getFilmReview(film.getId());
    }


    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(M005FilmReviewModel.KEY_NOTIFY)) {
            notify((String) data);
        }else if (key.equals(M005FilmReviewModel.API_REVIEW_FILM)){
            ReviewFilmModel reviewFilmModel = (ReviewFilmModel) data;

            Log.i(TAG, "onCallBack:....... M005" + reviewFilmModel.getListResult().size());

            ReviewAdapter adapter = new ReviewAdapter(reviewFilmModel.getListResult(), mContext);

            rvReview.setAdapter(adapter);


        }
    }

    @Override
    protected Class<M005FilmReviewModel> getClassViewModel() {
        return M005FilmReviewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m005_review;
    }

    public void setFilm(MovieModel.Result film2) {
        this.film = film2;

    }
}
