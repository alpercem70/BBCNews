package com.alperp.bbcnews.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

public class BBCSwipeRefreshLayout extends SwipeRefreshLayout {

    private static final int DEFAULT_DISTANCE_TO_SWIPE = 100;

    public BBCSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public BBCSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        setDistanceToTriggerSync(DEFAULT_DISTANCE_TO_SWIPE);
    }
}
