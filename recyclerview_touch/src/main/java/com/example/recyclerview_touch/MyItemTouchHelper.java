package com.example.recyclerview_touch;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by LiPiao on 2019/5/24 15:10
 */
public class MyItemTouchHelper extends ItemTouchHelper.Callback {
    private MainActivity.MyAdapter mAdapter;

    // 限制ImageView长度所能增加的最大值
    private double ICON_MAX_SIZE = 50;
    // ImageView的初始长宽
    private int fixedWidth = 150;

    public MyItemTouchHelper(MainActivity.MyAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    /**
     * 该方法用于返回可以滑动的方向 比如说允许从右到左侧滑，允许上下拖动等
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        // 允许上下的拖动
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // 只允许从右向左侧滑
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /**
     * 当用户拖动一个Item进行上下移动从旧的位置到新的位置的时候会调用该方法
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        // onItemMove是接口方法
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 当用户左右滑动Item达到删除条件时，会调用该方法，
     * 一般手指触摸滑动的距离达到RecyclerView宽度的一半时，再松开手指，
     * 此时该Item会继续向原先滑动方向滑过去并且调用onSwiped方法进行删除，否则会反向滑回原来的位置
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // onItemDissmiss是接口方法
        mAdapter.onItemDissmiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
    }

//    @Override
//    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
//        super.clearView(recyclerView, viewHolder);
//        // 重置改变，防止由于复用而导致的显示问题
//        viewHolder.itemView.setScrollX(0);
//        ((MainActivity.MyAdapter.MyHolder) viewHolder).tvText.setText("左滑删除");
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.getLayoutParams();
//        params.width = 150;
//        params.height = 150;
//        ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.setLayoutParams(params);
//        ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.setVisibility(View.INVISIBLE);
//    }
//
//    /**
//     * 修改侧滑删除的样式
//     *
//     * @param c
//     * @param recyclerView
//     * @param viewHolder
//     * @param dX
//     * @param dY
//     * @param actionState
//     * @param isCurrentlyActive
//     */
//    @Override
//    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        //仅对侧滑状态下的效果做出改变
//        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//            //如果dX小于等于删除方块的宽度，那么我们把该方块滑出来
//            if (Math.abs(dX) <= getSlideLimitation(viewHolder)) {
//                viewHolder.itemView.scrollTo(-(int) dX, 0);
//            }
//            //如果dX还未达到能删除的距离，此时慢慢增加“眼睛”的大小，增加的最大值为ICON_MAX_SIZE
//            else if (Math.abs(dX) <= recyclerView.getWidth() / 2) {
//                double distance = (recyclerView.getWidth() / 2 - getSlideLimitation(viewHolder));
//                double factor = ICON_MAX_SIZE / distance;
//                double diff = (Math.abs(dX) - getSlideLimitation(viewHolder)) * factor;
//                if (diff >= ICON_MAX_SIZE)
//                    diff = ICON_MAX_SIZE;
//                ((MainActivity.MyAdapter.MyHolder) viewHolder).tvText.setText("");   // 把文字去掉
//                ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.setVisibility(View.VISIBLE);  // 显示眼睛
//                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.getLayoutParams();
//                params.width = (int) (fixedWidth + diff);
//                params.height = (int) (fixedWidth + diff);
//                ((MainActivity.MyAdapter.MyHolder) viewHolder).ivImg.setLayoutParams(params);
//            }
//        } else {
//            //拖拽状态下不做改变，需要调用父类的方法
//            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        }
//    }
//
//    /**
//     * 获取删除方块的宽度
//     */
//    public int getSlideLimitation(RecyclerView.ViewHolder viewHolder) {
//        ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
//        return viewGroup.getChildAt(1).getLayoutParams().width;
//    }

}
