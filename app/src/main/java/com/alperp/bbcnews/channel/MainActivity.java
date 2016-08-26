package com.alperp.bbcnews.channel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.core.BaseActivity;
import com.alperp.bbcnews.core.BaseFragment;
import com.alperp.bbcnews.network.BBCServiceProvider;
import com.alperp.bbcnews.network.model.Rss;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

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

    private void getRssFeeds() {
        BBCServiceProvider.getService().getRssFeed().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                MainFragment fragment = new MainFragmentBuilder(response.body().getChannel().getItems()).build();
                addFragment(fragment);
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_general, Toast.LENGTH_LONG).show();
            }
        });
    }
}
