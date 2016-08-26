package com.alperp.bbcnews.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class BBCTextView extends AppCompatTextView {

    public BBCTextView(Context context) {
        this(context, null);
    }

    public BBCTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BBCTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
