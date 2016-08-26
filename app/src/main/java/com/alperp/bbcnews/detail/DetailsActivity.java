package com.alperp.bbcnews.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alperp.bbcnews.core.BaseActivity;
import com.alperp.bbcnews.core.BaseFragment;

public class DetailsActivity extends BaseActivity {

    private static final String KEY_DETAILS_LINK = "keyDetailsLink";

    private String link;

    public static Intent newIntent(Context context, String link) {
        return new Intent(context, DetailsActivity.class).putExtra(KEY_DETAILS_LINK, link);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.link = getIntent().getStringExtra(KEY_DETAILS_LINK);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseFragment getContainedFragment() {
        return new DetailsFragmentBuilder(link).build();
    }
}
