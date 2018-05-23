package demo.test.com.material_animations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import demo.test.com.material_animations.databinding.ActivityTransition2Binding;


public class TransitionActivity2 extends BaseDetailActivity {

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
        ActivityTransition2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_transition2);
        Sample sample = (Sample) getIntent().getExtras().getSerializable(EXTRA_SAMPLE);
        type = getIntent().getExtras().getInt(EXTRA_TYPE);
        binding.setTransition2Sample(sample);
    }

    private void setupWindowAnimations() {
        Transition transition;

        if (type == TYPE_PROGRAMMATICALLY) {
            // 中心移入或者移出动画
            transition = buildEnterTransition();
        }  else {
            // 中心移入或者移出动画 结束后弹起
            transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        }
        // TransitionActivity1跳到TransitionActivity2，TransitionActivity2启动动画
        getWindow().setEnterTransition(transition);
    }

    private void setupLayout() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
                // 结束TransitionActivity2返回TransitionActivity1，这时候也会调用之前进入该界面的动画效果
            }
        });
    }

    private Transition buildEnterTransition() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        return enterTransition;
    }

}
