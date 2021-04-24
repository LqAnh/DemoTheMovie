package com.example.themovie.view.act;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.themovie.R;
import com.example.themovie.view.viewmodel.M006CinemaModel;

public class CinemaAct extends BaseAct<M006CinemaModel> {
    private ImageView ivCgv, ivBhd, ivLotte, ivBeta;
    private TextView tvCgv, tvBhd, tvLotte, tvBeta;

    @Override
    protected Class getClassViewModel() {
        return M006CinemaModel.class;
    }

    @Override
    protected void initViews() {
        ivCgv = findViewById(R.id.iv_cgv);
        tvCgv = findViewById(R.id.tv_cgv);
        ivCgv.setOnClickListener(this);
        tvCgv.setOnClickListener(this);


        ivBhd = findViewById(R.id.iv_bhd);
        tvBhd = findViewById(R.id.tv_bhd);
        ivBhd.setOnClickListener(this);
        tvBhd.setOnClickListener(this);


        ivLotte = findViewById(R.id.iv_lotte);
        tvLotte = findViewById(R.id.tv_lotte);
        ivLotte.setOnClickListener(this);
        tvLotte.setOnClickListener(this);


        ivBeta = findViewById(R.id.iv_beta);
        tvBeta = findViewById(R.id.tv_beta);
        ivBeta.setOnClickListener(this);
        tvBeta.setOnClickListener(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.frg_m006_cinema_select;
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.tv_cgv || v.getId() == R.id.iv_cgv) {
            openCgv();
        } else if (v.getId() == R.id.tv_bhd || v.getId() == R.id.iv_bhd) {
            openBhd();
        } else if (v.getId() == R.id.tv_lotte || v.getId() == R.id.iv_lotte) {
            openLotte();
        } else if (v.getId() == R.id.tv_beta || v.getId() == R.id.iv_beta) {
            openBeta();
        }
    }

    private void openBeta() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.beta.betacineplex");
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + "com.beta.betacineplex"));
            startActivity(intent);
        }
    }

    private void openLotte() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("vn.com.lottecinema.android");
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + "vn.com.lottecinema.android"));
            startActivity(intent);
        }
    }

    private void openBhd() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("io.starec.bhdstarcineplex");
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + "io.starec.bhdstarcineplex"));
            startActivity(intent);
        }
    }

    private void openCgv() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.cgv.cinema.vn");
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + "com.cgv.cinema.vn"));
            startActivity(intent);
        }
    }
}


