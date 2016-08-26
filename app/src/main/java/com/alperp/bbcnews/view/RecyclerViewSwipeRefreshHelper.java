package com.alperp.bbcnews.view;

import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewSwipeRefreshHelper extends RecyclerView.OnScrollListener {

    private static final int DIRECTION_UP = -1;

    private final SwipeRefreshLayout refreshLayout;

    public RecyclerViewSwipeRefreshHelper(SwipeRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            refreshLayout.setEnabled(!(recyclerView.canScrollVertically(DIRECTION_UP)));
        }
    }
}
