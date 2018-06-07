package me.lipiao.material_design.behavoir.zhihu;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author lipiao
 * @date 2018/6/7.
 * @description 知乎首页 底部控件上拉消失下拉出现 自定义Behavior第三种实现方式 直接监控recyclerView是否滑动以及滑动方向即可
 * @see ZhihuFooterBehavior1
 * @see ZhihuFooterBehavior2
 */
public class ZhihuFooterBehavior3 extends CoordinatorLayout.Behavior<View> {
    private ObjectAnimator outAnimator, inAnimator;

    private static final String TAG = "ZhihuFooterBehavior3";

    public ZhihuFooterBehavior3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (target instanceof NestedScrollView) {
            return;
        }
        Log.e(TAG, "onNestedPreScroll: dy = " + dy);
        if (dy > 0) { // 上滑隐藏
            hide(child);
        } else if (dy < 0) { // 下滑显示
            show(child);
        }
    }

    private void hide(View view) {
        if (outAnimator == null) {
            outAnimator = ObjectAnimator.ofFloat(view, "translationY", 0, view.getHeight());
            outAnimator.setDuration(200);
        }
        if (!outAnimator.isRunning() && view.getTranslationY() <= 0) {
            outAnimator.start();
        }
    }

    private void show(View view) {
        if (inAnimator == null) {
            inAnimator = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0);
            inAnimator.setDuration(200);
        }
        if (!inAnimator.isRunning() && view.getTranslationY() >= view.getHeight()) {
            inAnimator.start();
        }
    }
}
