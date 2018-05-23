package demo.test.com.transition_animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author lipiao
 * @data 2018/5/22.
 * @description 描述
 */
public class Main5Activity extends AppCompatActivity {
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private ViewGroup mGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mGroup = (ViewGroup) findViewById(R.id.constraintLayout1);
        mImageView1 = (ImageView) findViewById(R.id.imageView1);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade(); // 渐隐
            fade.setDuration(500);
            Slide slide = new Slide(Gravity.END); // 右边平移
            slide.setDuration(500);
            Explode explode = new Explode(); // 展开回收
            explode.setDuration(500);


//            getWindow().setEnterTransition(fade); // 当A start B时，使B中的View进入场景的transition
            getWindow().setExitTransition(explode); // 当A start B时，使A中的View退出场景的transition
//            getWindow().setReturnTransition(slide); // 当B 返回 A时，使B中的View退出场景的transition
            getWindow().setReenterTransition(slide); // 当B 返回 A时，使A中的View进入场景的transition

            getWindow().setAllowEnterTransitionOverlap(false); // 进入当前页面时，前后两个页面动画是否同步执行？
            getWindow().setAllowReturnTransitionOverlap(false); // 退出当前页面时，前后两个页面动画是否同步执行
        }

    }

    public void button(View view) {
        translationToActivity(Main2Activity.class);
    }

    public void button2(View view) {
        translationToActivity(Main3Activity.class, mImageView1, mImageView2, text1, text2);
    }

    public void button3(View view) {
        startActivity(Main4Activity.class, mImageView1);
    }

    // 平移过渡动画
    private void translationToActivity(Class target) {
        Intent intent = new Intent(this, target);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    // 平移过渡动画 share elements 单个元素
    private void startActivity(Class target, ImageView imageView1) {
        Intent intent = new Intent(this, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptionsCompat transitionActivityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView1, "image1");
            startActivity(intent, transitionActivityOptions.toBundle());
        }else {
            startActivity(intent);
        }
    }

    // 平移过渡动画 share elements 多个元素
    private void translationToActivity(Class target, ImageView imageView, ImageView imageView2,
                                       TextView text1, TextView text2) {
        Intent intent = new Intent(this, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Pair[] pairs = new Pair[]{Pair.create(imageView, "image1"),
                    Pair.create(imageView2, "image2"),
                    Pair.create(text1, "text1"),
                    Pair.create(text2, "text2")};
            ActivityOptionsCompat transitionActivityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
            startActivity(intent, transitionActivityOptions.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
