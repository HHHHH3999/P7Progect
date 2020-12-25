package com.example.p7project;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.p7project.Fragments.FenLeiFragment;
import com.example.p7project.Fragments.GouWuFragment;
import com.example.p7project.Fragments.HomeFragment;
import com.example.p7project.Fragments.MyFragment;
import com.example.p7project.Fragments.ZhuanTiFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> list;
    private FrameLayout fl;
    private RadioGroup rg;
    private RadioButton btnShouye;
    private RadioButton btnZhuanti;
    private RadioButton btnFenlei;
    private RadioButton btnGouwu;
    private RadioButton btnMine;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ZhuanTiFragment());
        list.add(new FenLeiFragment());
        list.add(new GouWuFragment());
        list.add(new MyFragment());


        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.tab_content);
        rg = (RadioGroup) findViewById(R.id.ll_bottom);
        btnShouye = (RadioButton) findViewById(R.id.btn_shouye);
        btnZhuanti = (RadioButton) findViewById(R.id.btn_zhuanti);
        btnFenlei = (RadioButton) findViewById(R.id.btn_fenlei);
        btnGouwu = (RadioButton) findViewById(R.id.btn_gouwu);
        btnMine = (RadioButton) findViewById(R.id.btn_mine);

        HomeFragment homeFragment = new HomeFragment();
        ZhuanTiFragment zhuanTiFragment = new ZhuanTiFragment();
        FenLeiFragment fenLeiFragment = new FenLeiFragment();
        GouWuFragment gouWuFragment = new GouWuFragment();
        MyFragment myFragment = new MyFragment();

        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.tab_content, homeFragment)
                .add(R.id.tab_content, zhuanTiFragment)
                .add(R.id.tab_content, fenLeiFragment)
                .add(R.id.tab_content, gouWuFragment)
                .add(R.id.tab_content, myFragment)
                .show(homeFragment).commit();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_zhuanti:

                        supportFragmentManager.beginTransaction().hide(homeFragment)
                                .hide(fenLeiFragment)
                                .hide(gouWuFragment)
                                .hide(myFragment).show(zhuanTiFragment).commit();

                        break;
                    case R.id.btn_fenlei:

                        supportFragmentManager.beginTransaction().hide(homeFragment)
                                .hide(zhuanTiFragment)
                                .hide(gouWuFragment)
                                .hide(myFragment).show(fenLeiFragment).commit();

                        break;
                    case R.id.btn_gouwu:

                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .hide(fenLeiFragment)
                                .hide(zhuanTiFragment)
                                .hide(myFragment).show(gouWuFragment).commit();

                        break;
                    case R.id.btn_mine:

                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .hide(fenLeiFragment)
                                .hide(gouWuFragment)
                                .hide(zhuanTiFragment).show(myFragment).commit();
                        break;
                    case R.id.btn_shouye:

                        supportFragmentManager.beginTransaction()
                                .hide(fenLeiFragment)
                                .hide(fenLeiFragment)
                                .hide(gouWuFragment)
                                .hide(zhuanTiFragment).show(homeFragment).commit();
                        break;

                }
            }
        });
    }
}