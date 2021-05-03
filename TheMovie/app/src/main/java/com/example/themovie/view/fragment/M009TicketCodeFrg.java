package com.example.themovie.view.fragment;

import com.example.themovie.R;
import com.example.themovie.view.viewmodel.M009TicketCodeModel;

public class M009TicketCodeFrg extends BaseFragment<M009TicketCodeModel>{
    @Override
    protected void initViews() {

    }

    @Override
    protected Class<M009TicketCodeModel> getClassViewModel() {
        return M009TicketCodeModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m009_ticket_code;
    }
}
