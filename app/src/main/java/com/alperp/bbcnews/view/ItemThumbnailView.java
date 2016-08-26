package com.alperp.bbcnews.view;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

public class ItemThumbnailView extends SimpleDraweeView {

    private static final float ASPECT_RATIO = 1.7f;

    public ItemThumbnailView(Context context) {
        this(context, null);
    }

    public ItemThumbnailView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemThumbnailView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int newWidth = getMeasuredWidth();
        int newHeight = (int) (newWidth / ASPECT_RATIO);

        setMeasuredDimension(newWidth, newHeight);
    }
}
