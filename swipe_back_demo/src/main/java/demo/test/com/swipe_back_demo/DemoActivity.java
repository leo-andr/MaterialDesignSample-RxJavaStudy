package demo.test.com.swipe_back_demo;

import android.app.Activity;
import android.os.Bundle;

import com.liuguangqiang.progressbar.CircleProgressBar;

import demo.test.com.swipe_back_demo.utils.SwipeBackLayout;


/**
 * Created by Eric on 15/2/27.
 */
public class DemoActivity extends Activity {

    private CircleProgressBar progressBar;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initViews();
    }

    private void initViews() {
        progressBar = (CircleProgressBar) findViewById(R.id.progressbar1);
        swipeBackLayout = (SwipeBackLayout) findViewById(R.id.swipe_layout);
        swipeBackLayout.setEnableFlingBack(false);

        swipeBackLayout.setOnPullToBackListener(new SwipeBackLayout.SwipeBackListener() {
            @Override
            public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
                progressBar.setProgress((int) (progressBar.getMax() * fractionAnchor));
            }
        });
    }

}
