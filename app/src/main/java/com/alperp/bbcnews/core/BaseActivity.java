package com.alperp.bbcnews.core;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;

import com.alperp.bbcnews.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentResourceId());

        final BaseFragment fragment = getContainedFragment();

        if (fragment != null) {
            String tag = fragment.getFragmentTag();
            addFragment(fragment, tag, false);
        }

        setupActionBar();

        Icepick.restoreInstanceState(this, savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            if (getParent() != null) {
                NavUtils.navigateUpFromSameTask(this);
            } else {
                finish();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Override to customize the action bar title.
     * @return action bar title
     */
    protected String getActionBarTitle() {
        return "";
    }

    /**
     * Return if action bar has a back button, default is false.
     * Override to have a action bar with back button.
     *
     * @return true if activity has a back button, false o/w
     */
    protected boolean displayHomeAsUpEnabled() {
        return false;
    }

    /**
     * Override this to define the contained fragment.
     *
     * @return fragment
     */
    protected abstract BaseFragment getContainedFragment();

    /**
     * Return the layout of activity.
     * Override to define a custom a layout.
     *
     * @return activity layout.
     */
    protected @LayoutRes int getContentResourceId() {
        return R.layout.activity_base;
    }

    /**
     * Return base frame layout of activity, this is the frame that will hold the fragments.
     * Override to define a custom layout (and therefore a new base frame).
     *
     * @return base frame layout id
     */
    protected @IdRes int getBaseFrameLayoutId() {
        return R.id.activity_base_frame;
    }

    protected void addFragment(BaseFragment fragment) {
        addFragment(fragment, fragment.getFragmentTag());
    }

    protected void addFragment(BaseFragment fragment, String tag) {
        addFragment(fragment, tag, true);
    }

    protected void addFragment(BaseFragment fragment, String tag, boolean addToBackStack) {
        addFragment(getSupportFragmentManager(), fragment, tag, getBaseFrameLayoutId(), true);
    }

    protected void replaceFragment(BaseFragment fragment) {
        replaceFragment(fragment, fragment.getFragmentTag());
    }

    protected void replaceFragment(BaseFragment fragment, String tag) {
        replaceFragment(fragment, tag, true);
    }

    protected void replaceFragment(BaseFragment fragment, String tag, boolean addToBackStack) {
        replaceFragment(getSupportFragmentManager(), fragment, tag, getBaseFrameLayoutId(), addToBackStack);
    }

    protected Fragment findFragment() {
        return getSupportFragmentManager().findFragmentById(getBaseFrameLayoutId());
    }

    protected Fragment findFragment(int id) {
        return getSupportFragmentManager().findFragmentById(id);
    }

    protected Fragment findFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    private void setupActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled());

            final String toolbarTitle = getActionBarTitle();
            if (!TextUtils.isEmpty(toolbarTitle)) {
                actionBar.setTitle(toolbarTitle);
            }
        }
    }

    private void addFragment(
            FragmentManager fragmentManager,
            BaseFragment fragment,
            String tag,
            int frameLayoutId,
            boolean addToBackStack) {

        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(frameLayoutId, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commit();
    }

    private void replaceFragment(
            FragmentManager fragmentManager,
            BaseFragment fragment,
            String tag,
            int frameLayoutId,
            boolean addToBackStack) {

        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(frameLayoutId, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commit();
    }
}
