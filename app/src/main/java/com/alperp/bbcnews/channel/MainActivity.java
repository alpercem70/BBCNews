package com.alperp.bbcnews.channel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.core.BaseActivity;
import com.alperp.bbcnews.core.BaseFragment;
import com.alperp.bbcnews.network.BBCServiceProvider;
import com.alperp.bbcnews.network.model.Item;
import com.alperp.bbcnews.network.model.Rss;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements MainFragment.Listener {

    @Override
    protected BaseFragment getContainedFragment() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getRssFeeds();
        }
    }

    @Override
    public void onRefreshData() {
        getRssFeeds();
    }

    private void getRssFeeds() {
        BBCServiceProvider.getService().getRssFeed().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {

                final ArrayList<Item> items = response.body().getChannel().getItems();

                final Fragment fragment = findFragment();
                if (fragment != null && fragment instanceof MainFragment) {
                    ((MainFragment) fragment).refreshData(items);
                } else {
                    MainFragment mainFragment = new MainFragmentBuilder(items).build();
                    addFragment(mainFragment);
                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_general, Toast.LENGTH_LONG).show();
            }
        });
    }

}
