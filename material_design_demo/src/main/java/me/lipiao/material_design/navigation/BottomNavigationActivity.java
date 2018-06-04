package me.lipiao.material_design.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import me.lipiao.material_design.R;



public class BottomNavigationActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_view_layout);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

    }
}
