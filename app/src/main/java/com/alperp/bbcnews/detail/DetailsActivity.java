package com.alperp.bbcnews.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alperp.bbcnews.core.BaseActivity;
import com.alperp.bbcnews.core.BaseFragment;
import com.alperp.bbcnews.network.model.Item;

public class DetailsActivity extends BaseActivity {

    private static final String KEY_ITEM = "keyItem";

    private Item item;

    public static Intent newIntent(Context context, Item item) {
        return new Intent(context, DetailsActivity.class).putExtra(KEY_ITEM, item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.item = getIntent().getParcelableExtra(KEY_ITEM);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseFragment getContainedFragment() {
        return new DetailsFragmentBuilder(item.getLink()).build();
    }

    @Override
    protected String getActionBarTitle() {
        return item.getTitle();
    }

    @Override
    protected boolean displayHomeAsUpEnabled() {
        return true;
    }
}
