package me.lipiao.material_design.behavoir.zhihu;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description 知乎首页 底部控件上拉消失下拉出现 自定义Behavior第一种实现方式
 * @description 缺陷：主要是重写layoutDependsOn 和 onDependentViewChanged 这两个方法
 * @description 缺陷：在layoutDependsOn判断dependency是否是AppBarLayout的实现类，会导致child依赖于 AppBarLayout，灵活性太低
 * @see ZhihuFooterBehavior2
 */
public class ZhihuFooterBehavior1 extends CoordinatorLayout.Behavior<View>{
    private static final String TAG = "ZhihuFooterBehavior1";

    public ZhihuFooterBehavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 决定child 依赖于把一个 dependency
    // 当 dependency instanceof AppBarLayout 返回TRUE，将会调用onDependentViewChanged（）方法
    // todo 我们要分清两个概念，child 和 dependency ，child 是我们要改变的坐标的view，
    // todo 而 dependency 是child 的 附属 ，即child 会随着 dependency 坐标的改变而改变。
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    // 当 dependency View 改变的时候 child 要做出怎样的响应
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        // 根据dependency top值的变化改变 child 的 translationY
        float translationY = Math.abs(dependency.getTop());
        child.setTranslationY(translationY);
        Log.e(TAG, "onDependentViewChanged: translationY" + translationY);
        return true;
    }
}
