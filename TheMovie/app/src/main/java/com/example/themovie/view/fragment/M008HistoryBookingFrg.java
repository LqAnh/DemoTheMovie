package com.example.themovie.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.themovie.App;
import com.example.themovie.R;
import com.example.themovie.view.viewmodel.M008HistoryModel;

public class M008HistoryBookingFrg extends BaseFragment<M008HistoryModel>{
    public static final String KEY_SHOW_TICKET_CODE = "KEY_SHOW_TICKET_CODE";
    private LinearLayout lnGod, lnNobody;
    @Override
    protected void initViews() {
        lnGod = findViewById(R.id.ln_godzilla);
        lnGod.setOnClickListener(this);
        lnNobody= findViewById(R.id.ln_nobody);
        lnNobody.setOnClickListener(this);
    }

    @Override
    protected void clickView(View v, int id) {
        if (v.getId() == R.id.ln_godzilla || v.getId() == R.id.ln_nobody){
            goToM009();
        }
    }

    private void goToM009() {
        callBack.onCallBack(KEY_SHOW_TICKET_CODE, null);
    }

    @Override
    protected Class<M008HistoryModel> getClassViewModel() {
        return M008HistoryModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m008_booking_history;
    }
}
