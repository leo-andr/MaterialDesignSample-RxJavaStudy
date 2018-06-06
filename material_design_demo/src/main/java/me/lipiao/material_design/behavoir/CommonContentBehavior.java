package me.lipiao.material_design.behavoir;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

import me.lipiao.material_design.MaterialDesignSimpleApplication;
import me.lipiao.material_design.R;
import me.lipiao.material_design.behavoir.source.HeaderScrollingViewBehavior;


public class CommonContentBehavior extends HeaderScrollingViewBehavior {

    public static final String TAG = "CommonContentBehavior";

    public CommonContentBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
         float transY =  dependency.getTranslationY()/ getHeaderOffsetRange() * 1.0f * getScrollRange(dependency);
        Log.i(TAG,"transY --->"+transY);
        child.setTranslationY(transY);
        return false;
    }

    public int getHeaderOffsetRange(){
        return MaterialDesignSimpleApplication.getAppContext().getResources().getDimensionPixelOffset(R.dimen.header_height);
    }


    @Override
    protected int getScrollRange(View v) {
        if(isDependOn(v)){
            return v.getMeasuredHeight() - 150;
        }
        return super.getScrollRange(v);
    }

    @Override
    protected View findFirstDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (isDependOn(view))
                return view;
        }
        return null;
    }

    public boolean isDependOn(View dependency){
         boolean isDenpend = dependency!=null && dependency.getId() == R.id.header_view;
        Log.i(TAG,"isDenpend --->"+isDenpend);
        return isDenpend ;
    }
}
