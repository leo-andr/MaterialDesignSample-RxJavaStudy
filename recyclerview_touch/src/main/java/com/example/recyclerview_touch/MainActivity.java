package com.example.recyclerview_touch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvContentScreen;
    TextView tvSlideScreen;
    MyRelativeLayout rlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        MyAdapter myAdapter = new MyAdapter(list);
        ItemTouchHelper.Callback callback = new MyItemTouchHelper(myAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rlRoot = findViewById(R.id.rlRoot);
        rlRoot.init();
    }

    public interface ItemTouchHelperAdapter {
        /**
         * 数据交换
         *
         * @param fromPosition 启示坐标
         * @param toPosition   终点坐标
         */
        void onItemMove(int fromPosition, int toPosition);

        /**
         * 数据删除
         *
         * @param position 删除下标
         */
        void onItemDissmiss(int position);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> implements ItemTouchHelperAdapter {

        private List<String> mData;

        MyAdapter(List<String> list) {
            this.mData = list;
        }

        @NonNull
        @Override
        public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_rv, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyHolder viewHolder, int i) {
            viewHolder.tv.setText(mData.get(i));
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tv;
            ImageView ivImg;
            TextView tvText;

            MyHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv);
                ivImg = itemView.findViewById(R.id.iv_img);
                tvText = itemView.findViewById(R.id.tv_text);
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public void onItemMove(int fromPosition, int toPosition) {
            // 交换位置
            Collections.swap(mData, fromPosition, toPosition);
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onItemDissmiss(int position) {
            // 移除数据
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

}
