package me.lipiao.material_design.behavoir.fab;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description fab移位behavior
 */
public class FabTranslationBehavior extends /*CoordinatorLayout.Behavior<View>*/FloatingActionButton.Behavior {
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    private float viewY; // 控件距离coordinatorLayout底部距离
    private boolean isAnimate; // 动画是否在进行

    public FabTranslationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    // 在嵌套滑动开始前回调
//    @Override
//    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
//                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
//        if (child.getVisibility() == View.VISIBLE && viewY == 0) {
//            // 获取控件距离父布局（coordinatorLayout）底部距离
//            viewY = coordinatorLayout.getHeight() - child.getY();
//        }
//        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0; //判断是否竖直滚动
//    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        if (child.getVisibility() == View.VISIBLE && viewY == 0) {
            // 获取控件距离父布局（coordinatorLayout）底部距离
            viewY = coordinatorLayout.getHeight() - child.getY();
        }
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0; //判断是否竖直滚动
    }


//    // 在嵌套滑动进行时，对象消费滚动距离前回调
//    @Override
//    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
//                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
//        // dy > 0 向上        dy < 0 向下
//        if (dy >= 0 && !isAnimate && child.getVisibility() == View.VISIBLE) {
//            hide(child);
//        } else if (dy < 0 && !isAnimate && child.getVisibility() == View.GONE) {
//            show(child);
//        }
//    }


    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if ((dyConsumed > 0 || dyUnconsumed > 0) && !isAnimate && child.getVisibility() == View.VISIBLE) {
            child.hide();
        } else if ((dyConsumed <= 0 || dyUnconsumed <= 0) && child.getVisibility() == View.GONE) {
            child.show();
        }
    }

    // 隐藏时的动画
    private void hide(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationY(viewY)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isAnimate = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
                isAnimate = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                show(view);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    // 显示时的动画
    private void show(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationY(0)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                view.setVisibility(View.VISIBLE);
                isAnimate = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimate = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                hide(view);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }
}
