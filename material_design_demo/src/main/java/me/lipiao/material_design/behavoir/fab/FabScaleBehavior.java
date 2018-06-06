package me.lipiao.material_design.behavoir.fab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import me.lipiao.material_design.AnimatorUtil;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description fab缩放behavior
 */
public class FabScaleBehavior extends FloatingActionButton.Behavior {
    private String TAG = "FabScaleBehavior";
    /**
     * 退出动画是否正在执行。
     */
    private boolean isAnimatingOut = false;

    private OnStateChangedListener mOnStateChangedListener;

    public FabScaleBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }



    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child,
                               @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.e(TAG, "dyConsumed = " + dyConsumed + "\ndyUnconsumed = " + dyUnconsumed);
        if ((dyConsumed > 0 || dyUnconsumed > 0) && !isAnimatingOut && child.getVisibility() == View.VISIBLE) { // 往下滑
            Log.e(TAG, "onNestedScroll: 111" );
            AnimatorUtil.scaleHide(child, viewPropertyAnimatorListener);
            if (mOnStateChangedListener != null) {
                mOnStateChangedListener.onChanged(false);
            }
        } else if ((dyConsumed < 0 || dyUnconsumed < 0) && child.getVisibility() != View.VISIBLE) {
            Log.e(TAG, "onNestedScroll: 222" );
            AnimatorUtil.scaleShow(child, null);
            if (mOnStateChangedListener != null) {
                mOnStateChangedListener.onChanged(true);
            }
        }
    }

    public void setOnStateChangedListener(OnStateChangedListener mOnStateChangedListener) {
        this.mOnStateChangedListener = mOnStateChangedListener;
    }

    // 外部监听显示和隐藏。
    public interface OnStateChangedListener {
        void onChanged(boolean isShow);
    }

    public static <V extends View> FabScaleBehavior from(V view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof FabScaleBehavior)) {
            throw new IllegalArgumentException("The view is not associated with ScaleDownShowBehavior");
        }
        return (FabScaleBehavior) behavior;
    }

    private ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener() {

        @Override
        public void onAnimationStart(View view) {
            isAnimatingOut = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimatingOut = false;
            view.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationCancel(View arg0) {
            isAnimatingOut = false;
        }
    };

    /**
     *  外部监听 示例
     */
    /**
     * 找到BottomSheetBehavior
     * 当fab缩放的时候让BottomSheetBehaviour触犯显示或者隐藏
     */
   /* bottomSheetBehavior =BottomSheetBehavior.from(

    findViewById(R.id.sheet_layout));
        bottomSheetBehavior.setPeekHeight(0);
    ScaleBehavior scaleBehavior = ScaleBehavior.from(findViewById(R.id.fab));

        scaleBehavior.setOnStateChangeListener(listener);
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    private ScaleBehavior.OnStateChangeListener listener = new ScaleBehavior.OnStateChangeListener() {
        @Override
        public void onChanged(boolean isShow) {
            bottomSheetBehavior.setState(isShow ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
        }
    };*/
}
