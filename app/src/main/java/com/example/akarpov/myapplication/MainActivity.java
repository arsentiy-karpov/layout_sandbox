package com.example.akarpov.myapplication;

import com.parse.ParseObject;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImageView mLogo;

    TextView mTextV;

    ExtendendGroup mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        findViewById(R.id.up_btn).setOnClickListener(this);
        findViewById(R.id.down_btn).setOnClickListener(this);
//        mLogo = (ImageView) findViewById(R.id.toolbar_image);
        mContainer = (ExtendendGroup) findViewById(R.id.container);
        mContainer.setDisplayHeight(getWindowManager().getDefaultDisplay().getHeight());
    }

    @Override
    public void onClick(View view) {
//        ParseObject testObject = new ParseObject("Guest");
//        testObject.put("name", "Jenya");
//        testObject.put("is_approved", true);
//        testObject.saveInBackground();
        switch (view.getId()) {
            case R.id.up_btn:
//                mContainer.smoothScrollBy(0, getResources().getDisplayMetrics().heightPixels / 2);
//                animateAlpha();
                moveUp();
                break;
            case R.id.down_btn:
//                mContainer.smoothScrollBy(0, -getResources().getDisplayMetrics().heightPixels / 2);
                moveDown();
                break;
        }
    }

    private void animateAlpha() {
        ValueAnimator a = ObjectAnimator.ofFloat(mLogo, "alpha", 1f, 0.2f);
        a.setInterpolator(new AccelerateDecelerateInterpolator());
        a.setDuration(400);
        a.start();
    }

    private void moveUp() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer, "translationY", mContainer.getTranslationY(),
                        mContainer.getTranslationY()
                                - getResources().getDisplayMetrics().heightPixels * 2f / 3f);
        a.setDuration(500);
        a.setInterpolator(new OvershootInterpolator(2f));
        a.start();
    }

    private void moveDown() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer.getTranslationY(), 0);
        a.setDuration(400);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContainer.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });
        a.start();
    }

}
