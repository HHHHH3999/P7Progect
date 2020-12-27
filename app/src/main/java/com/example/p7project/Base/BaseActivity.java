package com.example.p7project.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (persenter == null) {
            persenter = getPersenter();
            persenter.attachView(this);
        }
    }

    protected abstract P getPersenter();

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (persenter != null) {
            persenter = null;
        }
    }
}
