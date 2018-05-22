package demo.test.com.swipe_back_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import demo.test.com.swipe_back_demo.utils.SwipeBackActivity;
import demo.test.com.swipe_back_demo.utils.SwipeBackLayout;


public class CommonActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        setTitle("Common");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }
}
