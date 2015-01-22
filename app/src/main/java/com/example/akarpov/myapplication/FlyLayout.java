package com.example.akarpov.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by akarpov on 1/18/15.
 */
public class FlyLayout extends ImageView {

    public FlyLayout(Context context) {
        super(context);
    }

    public FlyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
