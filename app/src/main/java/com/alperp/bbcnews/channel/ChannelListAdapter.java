package com.alperp.bbcnews.channel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.network.model.Item;
import com.alperp.bbcnews.view.BBCTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {

    private ArrayList<Item> items;

    public ChannelListAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_channel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = items.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void refreshItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_channel_item_textview_header)
        BBCTextView textViewHeader;

        @BindView(R.id.item_channel_item_textview_description)
        BBCTextView textViewDescription;

        private Item item;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(Item item) {
            this.item = item;
            textViewHeader.setText(item.getTitle());
            textViewDescription.setText(item.getDescription());
        }
    }
}
