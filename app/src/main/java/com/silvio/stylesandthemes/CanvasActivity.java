package com.silvio.stylesandthemes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class CanvasActivity extends View {

    private float radius;
    private float x;
    private float y;
    private final Paint mPaint = new Paint();
    private AnimatorSet pulseAnimatorSet = new AnimatorSet();
    private static final int COLOR_ADJUSTER = 5;
    private static final int ANIMATION_DURATION = 4000;
    private static final int ANIMATION_DELAY = 1000;

    public CanvasActivity(Context context) {
        this(context, null);
    }

    public CanvasActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRadius(float radius) {
        this.radius = radius;
        this.mPaint.setColor(Color.GREEN + (int) radius / COLOR_ADJUSTER);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            this.x = event.getX();
            this.y = event.getY();
            if(pulseAnimatorSet != null && pulseAnimatorSet.isRunning()) {
                pulseAnimatorSet.cancel();
            }
            pulseAnimatorSet.start();
        }
        return super.onTouchEvent(event);
    }



}
