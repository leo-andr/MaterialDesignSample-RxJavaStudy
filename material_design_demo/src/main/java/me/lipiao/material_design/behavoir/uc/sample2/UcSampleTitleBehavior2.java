package me.lipiao.material_design.behavoir.uc.sample2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * @author lipiao
 * @date 2018/6/6.
 * @description uc浏览器主页简易实现
 * todo 该布局由RecylerView列表和一个TextView组成，其中RecylerView实现了NestedScrollingChild接口，所以TextView监听RecylerView的滑动状态。开始向上滑动列表时TextView和列表整体上移，直到TextView全部隐藏停止，再次上滑则列表内容上移。之后连续下滑列表当其第一个item全部显示时列表滑动停止，再次下滑列表时TextView跟随列表整体下移，直到TextView全部显示
 * @see UcRecyclerViewBehavior
 */
public class UcSampleTitleBehavior2 extends CoordinatorLayout.Behavior<TextView> {
    // 界面整体向上滑动，达到列表可滑动的临界点
    private boolean upReach;
    // 列表向上滑动后，再向下滑动，达到界面整体可滑动的临界点
    private boolean downReach;
    // 列表上一个全部可见的item位置
    private int lastPosition = -1;

    public UcSampleTitleBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, TextView child, MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downReach = false;
                upReach = false;
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        // 垂直方向滑动 只监听其垂直方向的滑动事件
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    // 处理监听到的滑动事件，实现整体滑动和列表单独滑动（header是否完全隐藏是滑动的临界点）
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child,
                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        if (target instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) target;
            // 列表第一个全部可见Item的位置
            int pos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            if (pos == 0 && pos < lastPosition) {
                downReach = true;
            }
            // 整体可以滑动，否则RecyclerView消费滑动事件
            if (canScroll(child, dy) && pos == 0) {
                float finalY = child.getTranslationY() - dy;
                if (finalY < -child.getHeight()) {
                    finalY = -child.getHeight();
                    upReach = true;
                } else if (finalY > 0) {
                    finalY = 0;
                }
                child.setTranslationY(finalY);
                // 让CoordinatorLayout消费滑动事件
                consumed[1] = dy;
            }
            lastPosition = pos;
        }
    }

    /**
     * 能否滑动
     */
    private boolean canScroll(View child, float scrollY) {
        if (scrollY > 0 && child.getTranslationY() == -child.getHeight()) {
            return false;
        }
        if (downReach) {
            return false;
        }
        return true;
    }
}
