package com.alperp.bbcnews.channel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.network.model.Item;
import com.alperp.bbcnews.view.BBCTextView;
import com.alperp.bbcnews.view.ItemThumbnailView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {

    private ArrayList<Item> items;
    private ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClick(Item item);
    }

    public ChannelListAdapter(ArrayList<Item> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_channel_item, parent, false);
        return new ViewHolder(view, listener);
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

        @BindView(R.id.item_channel_item_draweeview_thumbnail)
        ItemThumbnailView draweeViewThumbnail;

        private Item item;
        private ItemClickListener listener;

        public ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = itemClickListener;
        }

        public void bindItem(Item item) {
            this.item = item;
            textViewHeader.setText(item.getTitle());
            textViewDescription.setText(item.getDescription());
            draweeViewThumbnail.setImageURI(item.getThumbnail().getUrl());
        }

        @OnClick(R.id.item_channel_item_cardview_container)
        public void onItemClick() {
            listener.onItemClick(item);
        }
    }
}
