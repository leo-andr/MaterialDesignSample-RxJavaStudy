package me.lipiao.material_design.behavoir.xiami;

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
 * @description 仿虾米音乐主页
 */
public class XiaMiCustomBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiami_custome_behavior_layout);

        RecyclerView recyclewView = findViewById(R.id.recyclerView);
        recyclewView.setLayoutManager(new LinearLayoutManager(this));
        recyclewView.setAdapter(new MyAdapter(Utils.getData()));
    }
}
