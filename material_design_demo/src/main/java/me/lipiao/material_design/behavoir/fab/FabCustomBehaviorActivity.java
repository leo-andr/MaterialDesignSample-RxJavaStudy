package me.lipiao.material_design.behavoir.fab;

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
 * @description 自定义 Behavior 实现 FloatingActionButton的显示与隐藏
 * @see FabScaleBehavior 1.缩放
 * @see FabTranslationBehavior 2.位移
 */
public class FabCustomBehaviorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fab_custom_behavior_layout4);
        RecyclerView recyclewView = findViewById(R.id.recyclerView);
        recyclewView.setLayoutManager(new LinearLayoutManager(this));
        recyclewView.setAdapter(new MyAdapter(Utils.getData()));
    }
}
