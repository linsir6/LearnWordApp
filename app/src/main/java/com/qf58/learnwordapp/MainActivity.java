package com.qf58.learnwordapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initViewpager();
    }


    private void initViewpager() {
        MainActivityAdapter mAdapter = new MainActivityAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(4);
        tablayout.setupWithViewPager(viewPager);
        mAdapter.setupTabLayout(tablayout, viewPager);
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            if (tab != null) {
                if (i == 0) {
                    tab.setCustomView(mAdapter.getTabView(i, this, true));
                } else {
                    tab.setCustomView(mAdapter.getTabView(i, this, false));
                }
            }
        }
    }
}







