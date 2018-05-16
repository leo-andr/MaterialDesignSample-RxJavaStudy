package demo.test.com.headstretchablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * @author lipiao
 * @data 2018/3/30.
 */

public class MyListView extends ListView {
    private ImageView mHeaderImageView;
    private int mStartHeight;

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mStartHeight = dip2px(context, 200f);
    }

    public void setZoneImageView(ImageView imageView) {
        this.mHeaderImageView = imageView;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
                                   int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        // deltaY < 0 下拉过渡
        // deltaY > 0 上拉过渡
        if (deltaY < 0) {
            mHeaderImageView.getLayoutParams().height = mHeaderImageView.getHeight() - deltaY;
            mHeaderImageView.requestLayout();
        } else {
            if (mStartHeight - mHeaderImageView.getHeight() <= dip2px(getContext(), 100f)) {
                mHeaderImageView.getLayoutParams().height = mHeaderImageView.getHeight() - deltaY;
                mHeaderImageView.requestLayout();
            }
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    // 上升的时候图片减小
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View parent = (View) mHeaderImageView.getParent();
        int deltaY = parent.getTop();

        // 拉伸之后再上拉，deltaY<0 恢复到原图大小之后不再缩小
        if (deltaY < 0 && mHeaderImageView.getHeight() > mStartHeight) {
            mHeaderImageView.getLayoutParams().height = mHeaderImageView.getHeight() + deltaY;
            // 更新图片，都要重置图片的位置
            parent.layout(parent.getLeft(), 0, parent.getRight(), parent.getBottom());
            mHeaderImageView.requestLayout();
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            ResetAnimotion animotion = new ResetAnimotion(mHeaderImageView, mStartHeight);
            animotion.setDuration(300);
            mHeaderImageView.startAnimation(animotion);
        }

        return super.onTouchEvent(ev);
    }

    class ResetAnimotion extends Animation {
        private int targhtHeight;
        private int originHeight;
        private int extraHeight;

        private ResetAnimotion(ImageView iv, int targhtHeight) {
            this.targhtHeight = targhtHeight;
            this.originHeight = iv.getHeight();
            this.extraHeight = originHeight - targhtHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            mHeaderImageView.getLayoutParams().height = (int) (originHeight - (extraHeight * interpolatedTime));
            mHeaderImageView.requestLayout();
            super.applyTransformation(interpolatedTime, t);
        }
    }
}
