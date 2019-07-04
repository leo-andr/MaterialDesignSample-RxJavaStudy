package com.example.recyclerview_touch;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by LiPiao on 2019/5/27 10:50
 */
public class MyRelativeLayout extends RelativeLayout {

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int getScreenW() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    private TextView tvSlideScreen;
    private int mScreenWidth;

    public void init() {
        tvSlideScreen = findViewById(R.id.tvSlideScreen);
        tvSlideScreen.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        mScreenWidth = getScreenW();
        tvSlideScreen.setTranslationX(-mScreenWidth);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) ev.getX() - mLastXIntercept;
                int deltaY = (int) ev.getY() - mLastYIntercept;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    // 横向滑动
                    intercept = true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                intercept = false;
                break;
            default:
                break;
        }
        mLastX = x;
        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercept;
    }

    private int mLastXIntercept;
    private int mLastYIntercept;
    private int mLastX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int currentX = (int) event.getX();
                // 拿到x方向的偏移量
                int dx = currentX - mLastX;
                float translationX = tvSlideScreen.getTranslationX();
                if (translationX <= 0) {
                    tvSlideScreen.setTranslationX(dx + translationX);
                }
                mLastX = currentX;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                translationX = tvSlideScreen.getTranslationX();
                float absTranslationX = Math.abs(translationX);
                if (absTranslationX <= mScreenWidth) {
                    // 没滑动到边界
                    if ((mScreenWidth - absTranslationX) >= mScreenWidth / 2) {
                        // 取消手势 做惯性操作
                        animTranslationXStart(tvSlideScreen, 0);
                    } else {
                        animTranslationXStart(tvSlideScreen, -mScreenWidth);
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }

    private void animTranslationXStart(View view, float translationX) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                view, "translationX", translationX);
        animator.setInterpolator(new OvershootInterpolator());
        animator.setDuration(400);
        animator.start();
    }
}
