package demo.test.com.transition_animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;

/**
 * @author lipiao
 * @data 2018/5/22.
 * @description 描述
 */
public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(500);
            Slide slide = new Slide();
            slide.setDuration(500);
            slide.setSlideEdge(Gravity.START);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(explode);
        }

    }
}
