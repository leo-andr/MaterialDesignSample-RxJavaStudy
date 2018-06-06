package me.lipiao.material_design.behavoir.uc.mainpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import me.lipiao.material_design.R;
import me.lipiao.material_design.TypePageAdapter;

/**
 * @author lipiao
 * @date 2018/6/6.
 * @description uc主页
 */
public class UsMainCustomBehaviorActivity extends AppCompatActivity implements MainHeaderBehavior.OnHeaderStateListener{

    private ViewPager mViewPager;

    private MainHeaderBehavior mHeaderBehavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc_main_custom_behavior_layout);
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        fragments.add(TypeFragment.newInstance());
        fragments.add(TypeFragment.newInstance());
        fragments.add(TypeFragment.newInstance());

        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tableLayout = (TabLayout) findViewById(R.id.tablayout);

        TypePageAdapter mTypeAdapter = new TypePageAdapter(getSupportFragmentManager());
        mTypeAdapter.setData(fragments, titles);
        mViewPager.setAdapter(mTypeAdapter);
        mViewPager.setOffscreenPageLimit(titles.size() - 1);

        tableLayout.setupWithViewPager(mViewPager);
        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onHeaderClosed() {
        Log.e("status", "closed");
    }

    @Override
    public void onHeaderOpened() {
        Log.e("status", "opened");
    }
    @Override
    public void onBackPressed() {
        if (mHeaderBehavior != null && mHeaderBehavior.isClosed()) {
            mHeaderBehavior.openHeader();
        } else {
            super.onBackPressed();
        }
    }

}
