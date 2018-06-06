package me.lipiao.material_design.behavoir.uc.sample2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * @author lipiao
 * @date 2018/6/6.
 * @description uc主页的recycleView 当header位置变化时(即TextView)，改变列表y坐标
 * @see UcSampleTitleBehavior2
 */
public class UcRecyclerViewBehavior extends CoordinatorLayout.Behavior<RecyclerView>{

    public UcRecyclerViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RecyclerView child, View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RecyclerView child, View dependency) {
        // 计算列表y坐标，最小为0
        float y = dependency.getHeight() + dependency.getTranslationY();
        if (y < 0) {
            y = 0;
        }
        child.setY(y);
        return true;
    }
}
