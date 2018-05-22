package demo.test.com.transition_animation;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Fade 淡入淡出
            // Slide 滑入滑出
            // Explode 爆炸效果
            getWindow().setEnterTransition(new Explode().setDuration(2000));
            getWindow().setExitTransition(new Explode().setDuration(2000));

            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

//        TextView textView = (TextView) findViewById(R.id.content);
//        TranslateAnimation animation = new TranslateAnimation(0, 0, 200, 0);
//        animation.setDuration(500);
//        textView.setAnimation(animation);
//        animation.start();

    }

    public void finish(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }else {
            finish();
        }
    }
}
