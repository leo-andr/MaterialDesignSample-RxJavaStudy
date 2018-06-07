package me.lipiao.material_design.behavoir.zhihu;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description 知乎首页 底部控件上拉消失下拉出现 自定义Behavior第二种实现方式 监控recyclerView，记录recyclerView滑动距离，比较操作底部导航栏高度，底部做相应位移操作
 * @description 主要是重写onStartNestedScroll 和 onNestedPreScroll 这两个方法，
 * @description 判断是否是垂直滑动，是的话就进行处理，灵活性大大增强，推荐使用这一种方法
 * @see ZhihuFooterBehavior1
 * @see ZhihuFooterBehavior3
 */
public class ZhihuFooterBehavior2 extends CoordinatorLayout.Behavior<View> {
    /*
        1：AccelerateDecelerateInterpolator 加速减速插补器（先慢后快再慢）
        2：AccelerateInterpolator 加速插补器（先慢后快）
        3：AnticipateInterpolator 向前插补器（先往回跑一点，再加速向前跑）
        4：AnticipateOvershootInterpolator 向前向后插补器（先往回跑一点，再向后跑一点，再回到终点）
        5：BounceInterpolator 反弹插补器（在动画结束的时候回弹几下，如果是竖直向下运动的话，就是玻璃球下掉弹几下的效果）
        6：CycleInterpolator 循环插补器（按指定的路径以指定时间（或者是偏移量）的1/4、变速地执行一遍，再按指定的轨迹的相反反向走1/2的时间，再按指定的路径方向走完剩余的1/4的时间，最后回到原点。假如：默认是让a从原点往东跑100米。它会先往东跑100米，然后往西跑200米，再往东跑100米回到原点。可在代码中指定循环的次数）
        7：DecelerateInterpolator 减速插补器（先快后慢）
        8：LinearInterpolator 直线插补器（匀速）
        9：OvershootInterpolator 超出插补器（向前跑直到越界一点后，再往回跑）
        10：FastOutLinearInInterpolator MaterialDesign基于贝塞尔曲线的插补器 效果：依次 慢慢快
        11：FastOutSlowInInterpolator MaterialDesign基于贝塞尔曲线的插补器 效果：依次 慢快慢
        12：LinearOutSlowInInterpolator MaterialDesign基于贝塞尔曲线的插补器 效果：依次 快慢慢*/
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    private int sinceDirectionChange;
    private String TAG = "ZhihuFooterBehavior2";

    public ZhihuFooterBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    // 1.判断滑动的方向 我们需要垂直滑动
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull View child, @NonNull View directTargetChild,
                                       @NonNull View target, int axes) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    // 2.根据滑动的距离显示和隐藏footer view
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.e(TAG, "dy = " + dy);
        if (dy > 0 && sinceDirectionChange < 0 || dy < 0 && sinceDirectionChange > 0) {
            child.animate().cancel();
            sinceDirectionChange = 0;
        }
        sinceDirectionChange += dy;
        Log.e(TAG, "onNestedPreScroll: sinceDirectionChange = " + sinceDirectionChange);
        if (sinceDirectionChange > child.getHeight()) {
            hide(child);
            sinceDirectionChange = 0;
        } else if (sinceDirectionChange < 0 && Math.abs(sinceDirectionChange) >= child.getHeight()) {
            show(child);
            sinceDirectionChange = 0;
        }
    }

    private void hide(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationY(view.getHeight())
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // todo 这个有问题，gone了之后，onNestedPreScroll不再有任何反应，还不太明白
//                view.setVisibility(View.GONE);
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

    private void show(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationY(0)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                view.setVisibility(View.VISIBLE);
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
