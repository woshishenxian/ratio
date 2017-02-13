package com.qi.ratio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by vince on 17/2/13.
 */

public class RatioImageView extends ImageView {

    public static final int FIXEDEDGE_WIDTH = 0;
    public static final int FIXEDEDGE_HEIGHT = 1;

    private float aspectRatio = 0;
    private int fixedEdge = FIXEDEDGE_WIDTH;

    public float getAspectRatio() {
        return aspectRatio;
    }


    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.RatioView);
        aspectRatio = a.getFloat(R.styleable.RatioView_aspectRatio, 0f);
        fixedEdge = a.getInt(R.styleable.RatioView_fixedEdge, FIXEDEDGE_WIDTH);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int factHeightMeasureSpec = heightMeasureSpec;
        int factWidthMeasureSpec = widthMeasureSpec;
        if (aspectRatio >= 0) {
            if (fixedEdge == FIXEDEDGE_WIDTH) {
                factHeightMeasureSpec = MeasureSpec
                        .makeMeasureSpec(
                                (int) (MeasureSpec.getSize(widthMeasureSpec) * aspectRatio),
                                MeasureSpec.EXACTLY);
            } else {
                factWidthMeasureSpec = MeasureSpec
                        .makeMeasureSpec(
                                (int) (MeasureSpec.getSize(heightMeasureSpec) * aspectRatio),
                                MeasureSpec.EXACTLY);
            }

        }
        super.onMeasure(factWidthMeasureSpec, factHeightMeasureSpec);
    }
}
