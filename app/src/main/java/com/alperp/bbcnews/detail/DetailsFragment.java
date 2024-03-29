package com.alperp.bbcnews.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alperp.bbcnews.R;
import com.alperp.bbcnews.core.BaseFragment;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import butterknife.BindView;

@FragmentWithArgs
public class DetailsFragment extends BaseFragment {

    @Arg
    String link;

    @BindView(R.id.fragment_details_webview_content)
    WebView webView;

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(link);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_details;
    }
}
