package demo.test.com.material_animations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;

import demo.test.com.material_animations.databinding.ActivityTransition3Binding;


public class TransitionActivity3 extends BaseDetailActivity {

    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindData();
        setupWindowAnimations();
        setupLayout();
        setupToolbar();
    }

    private void bindData() {
        ActivityTransition3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_transition3);
        Sample sample = (Sample) getIntent().getExtras().getSerializable(EXTRA_SAMPLE);
        type = getIntent().getExtras().getInt(EXTRA_TYPE);
        binding.setTransition3Sample(sample);
    }

    private void setupWindowAnimations() {
        Transition transition;

        if (type == TYPE_PROGRAMMATICALLY) {
            // 右边移入
            transition = buildEnterTransition();
        }  else {
            // 底部移入
            transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_bottom);
        }
        // TransitionActivity1跳到TransitionActivity3，TransitionActivity3启动动画
        getWindow().setEnterTransition(transition);
    }

    private void setupLayout() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
                // 结束TransitionActivity3返回TransitionActivity1，这时候也会调用之前进入该界面的动画效果
                // 底部移出/右边移出
            }
        });
    }

    private Visibility buildEnterTransition() {
        Slide enterTransition = new Slide();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        enterTransition.setSlideEdge(Gravity.RIGHT);
        return enterTransition;
    }

}
