package me.lipiao.material_design.behavoir.uc.sample1;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author lipiao
 * @date 2018/6/6.
 * @description uc浏览器主页简易实现 添加了位移以及透明度
 * todo 上滑动列表时，title(TextView)自动下滑，当title全部显示时，列表顶部和title底部恰好重合，继续上滑列表时title固定；
 * todo 下滑列表时，当列表顶部和title底部重合时，title开始自动上滑直到完全隐藏。
 */
public class UcSampleTitleBehavior extends CoordinatorLayout.Behavior<View> {
    private float detalY;  // 列表顶部和title底部重合时，列表的滑动距离。

    public UcSampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (detalY == 0) {
            detalY = dependency.getY() - child.getHeight();
        }

        float dy = dependency.getY() - child.getHeight();
        dy = dy < 0 ? 0 : dy;
        float translationY = -(dy / detalY) * child.getHeight();
        float alpha = 1 - (dy / detalY);
        Log.e("UcSampleTitleBehavior", "translationY: " + translationY + ",alpha:" + alpha);
        child.setTranslationY(translationY);
        child.setAlpha(alpha);

        return true;
    }

}
