package com.alperp.bbcnews.channel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.core.BaseFragment;
import com.alperp.bbcnews.network.model.Item;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import java.util.ArrayList;

import butterknife.BindView;

@FragmentWithArgs
public class MainFragment extends BaseFragment {

    @Arg
    ArrayList<Item> items;

    @BindView(R.id.fragment_main_recyclerview_items)
    RecyclerView recyclerView;

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ChannelListAdapter adapter = new ChannelListAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_main;
    }

    public void refreshData(ArrayList<Item> items) {
        this.items = items;

        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new ChannelListAdapter(items));
        } else {
            ((ChannelListAdapter) recyclerView.getAdapter()).refreshItems(items);
        }
    }
}
