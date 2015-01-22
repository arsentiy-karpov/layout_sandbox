package com.example.akarpov.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by akarpov on 1/20/15.
 */
public class ExtendendGroup extends LinearLayout {

    int mDisplayHeight;

    public ExtendendGroup(Context context) {
        super(context);
    }

    public ExtendendGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendendGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDisplayHeight(int displayHeight) {
        mDisplayHeight = displayHeight;
    }

    private int getDesiredHeight() {
        return Math.round(mDisplayHeight * 1.7f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDesiredHeight();
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST);
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        measureChildren(widthSpec, heightSpec);
        setMeasuredDimension(width, height);
        Log.d("Width, height:", String.valueOf(width) + " " + String.valueOf(height));
    }
}
