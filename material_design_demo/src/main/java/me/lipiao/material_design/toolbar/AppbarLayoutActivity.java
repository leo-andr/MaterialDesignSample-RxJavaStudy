package me.lipiao.material_design.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import me.lipiao.material_design.R;
import me.lipiao.material_design.utils.StatusBarUtils;


public class AppbarLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout_ac);
        initView();
    }

    private void initView() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_layout_toolbar);
        StatusBarUtils.setTranslucentImageHeader(this, 0, toolbar);
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        toolbar.inflateMenu(R.menu.menu_search);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        collapsingToolbarLayout.setTitle("");
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("zhouwei", "appbarHeight:" + appBarLayout.getHeight() + " getTotalScrollRange:" + appBarLayout.getTotalScrollRange() + " offSet:" + verticalOffset);
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    toolbar.setTitle("AppbarLayout");
                } else {
                    toolbar.setTitle("");
                }
            }
        });
    }
}
