package me.lipiao.material_design.behavoir.zhihu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.lipiao.material_design.MyAdapter;
import me.lipiao.material_design.R;
import me.lipiao.material_design.utils.Utils;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description 仿知乎首页，
 * 上面的AppBarLayout 向上滑动的时候会隐藏，向下滑动的时候会展示
 * 下面的布局，向上滑动的时候会隐藏，向下滑动的时候会显示
 * 采用用2种不同的behavior实现
 * todo 第二种有问题！！
 * @see ZhihuFooterBehavior1
 * @see ZhihuFooterBehavior2
 * @see ZhihuFooterBehavior3
 * 需要注意的是不管是哪一种方法，我们都需要重写带两个构造方法的函数，因为底层机制会采用反射的形式获得该对象
 */
public class ZhiHuCustomBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhi_hu_custom_behavior_layout);

        RecyclerView recyclewView = findViewById(R.id.recyclerView);
        recyclewView.setLayoutManager(new LinearLayoutManager(this));
        recyclewView.setAdapter(new MyAdapter(Utils.getData()));
    }

}
