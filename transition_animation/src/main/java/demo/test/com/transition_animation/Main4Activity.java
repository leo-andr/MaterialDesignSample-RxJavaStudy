package demo.test.com.transition_animation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;

/**
 * @author lipiao
 * @data 2018/5/22.
 * @description 描述
 */
public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Fragment1 fragment1 = Fragment1.newInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slideTransition = new Slide(Gravity.LEFT);
            slideTransition.setDuration(500);
            fragment1.setReenterTransition(slideTransition);
            fragment1.setExitTransition(slideTransition);
            fragment1.setSharedElementEnterTransition(new ChangeBounds());
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment1)
                .commit();
    }
}
