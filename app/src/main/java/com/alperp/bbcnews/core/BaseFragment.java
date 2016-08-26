package com.alperp.bbcnews.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(getResourceLayoutId(), container, false);

        initUserInterface(inflater, rootView);

        return rootView;
    }

    /**
     * Return the fragment tag.
     * Override this to define a custom tag.
     *
     * @return fragment tag
     */
    protected String getFragmentTag() {
        return this.getClass().getSimpleName();
    }

    /**
     * Override this to initialize the layout.
     *
     * @param inflater inflater
     * @param rootView root view
     */
    protected abstract void initUserInterface(LayoutInflater inflater, View rootView);

    /**
     * Override this to define the layout.
     *
     * @return resource layout id
     */
    protected abstract @LayoutRes int getResourceLayoutId();
}
