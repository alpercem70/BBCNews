package com.alperp.bbcnews.channel;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.core.BaseFragment;
import com.alperp.bbcnews.network.model.Item;
import com.alperp.bbcnews.view.BBCSwipeRefreshLayout;
import com.alperp.bbcnews.view.RecyclerViewSwipeRefreshHelper;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import java.util.ArrayList;

import butterknife.BindView;

@FragmentWithArgs
public class MainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    public interface Listener {
        void onRefreshData();
    }

    @Arg
    ArrayList<Item> items;

    @BindView(R.id.fragment_main_recyclerview_items)
    RecyclerView recyclerView;

    @BindView(R.id.fragment_main_swipe_refresh)
    BBCSwipeRefreshLayout swipeRefreshLayout;

    private Listener listener;

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ChannelListAdapter adapter = new ChannelListAdapter(items);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.addOnScrollListener(new RecyclerViewSwipeRefreshHelper(swipeRefreshLayout));
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (Listener) context;
        } catch (ClassCastException exception) {
            Log.d(getFragmentTag(), context.getClass().getSimpleName() + " should implement " + Listener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

    @Override
    public void onRefresh() {
        listener.onRefreshData();
    }

    public void refreshData(ArrayList<Item> items) {
        this.items = items;

        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new ChannelListAdapter(items));
        } else {
            ((ChannelListAdapter) recyclerView.getAdapter()).refreshItems(items);
        }

        disableRefreshing();
    }

    private void disableRefreshing() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
