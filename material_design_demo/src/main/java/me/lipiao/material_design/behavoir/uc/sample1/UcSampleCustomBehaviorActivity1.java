package me.lipiao.material_design.behavoir.uc.sample1;

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
 * @date 2018/6/6.
 * @description 仿UC浏览器主页1
 */
public class UcSampleCustomBehaviorActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc_sample_custom_behavior_layout1);
        RecyclerView recyclewView = findViewById(R.id.recyclerView);
        recyclewView.setLayoutManager(new LinearLayoutManager(this));
        recyclewView.setAdapter(new MyAdapter(Utils.getData()));
    }
}
