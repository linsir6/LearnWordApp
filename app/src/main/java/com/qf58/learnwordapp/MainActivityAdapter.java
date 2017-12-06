package com.qf58.learnwordapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by linSir
 * date at 2017/12/5.
 * describe:
 */

public class MainActivityAdapter extends FragmentPagerAdapter {


    private Context context;
    private View view;
    private Fragment[] fragments = {new DictionaryFragment(), new LearnWordFragment()
            , new GoOverFragment(), new TestFragment()};

    private String[] title = {"词典", "背单词", "复习", "测验"};

    public MainActivityAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }


    public void setupTabLayout(final TabLayout tabLayout, final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tv_boss_item_name);
                tv.setTextColor(0xff42a5f5);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tv_boss_item_name);
                tv.setTextColor(0xff333333);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    public View getTabView(int position, Context context, boolean select) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_boss_order_fragment_tablayout_item, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_boss_item_name);
        tv.setText(title[position]);
        if (select) {
            tv.setTextColor(0xff42a5f5);
        } else {
            tv.setTextColor(0xff333333);
        }
        return view;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }


}
