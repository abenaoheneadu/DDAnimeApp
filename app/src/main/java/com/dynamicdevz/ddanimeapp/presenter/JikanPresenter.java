package com.dynamicdevz.ddanimeapp.presenter;

import android.util.Log;

import com.dynamicdevz.ddanimeapp.model.JikanResult;
import com.dynamicdevz.ddanimeapp.model.network.JikanNetwork;

import java.util.List;

public class JikanPresenter implements Presenter.JikanPresenter {

    private Presenter.JikanView view;
    public JikanPresenter(Presenter.JikanView view){
        this.view = view;
    }

    @Override
    public void getJikanResults(String query) {
    new Thread(){
        @Override
        public void run() {
            super.run();
            try {
                // a singleton
                List<JikanResult> results = JikanNetwork.getInstance().searchJikan(query);
                Log.d("TAG_M", "Success");
                view.displayResults(results);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("TAG_M", "");
                view.displayError(e.getMessage());
            }

        }
    }.start();
        }


    }

