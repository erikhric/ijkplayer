package tv.danmaku.ijk.media.example.widget.stereoscopic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewAnimationUtils;

import tv.danmaku.ijk.media.example.R;
import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;
import tv.danmaku.ijk.media.example.widget.media.SurfaceRenderView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * TODO: document your custom view class.
 */
public class ReflectedView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private IjkVideoView reflecting;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public ReflectedView(Context context) {
        super(context);
        init(null, 0);
    }

    public ReflectedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ReflectedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ReflectedView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.ReflectedView_exampleString);
        mExampleColor = a.getColor(
                R.styleable.ReflectedView_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.ReflectedView_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.ReflectedView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.ReflectedView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (reflecting != null) {
//            reflecting.getBitmapFromView(reflecting, getMeasuredWidth(), getMeasuredHeight());
//            canvas.drawBitmap(reflecting.getBitmapFromView(reflecting, getMeasuredWidth(), getMeasuredHeight()),0,0,null);
        reflecting.draw(canvas);

//            view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache(true);
//        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(),0 ,0 , 100, 100);
//            if (bitmap != null)
//            canvas.drawBitmap(bitmap, 0, 0, null);

//            IjkMediaPlayer mediaPlayer = (IjkMediaPlayer) reflecting.mMediaPlayer;

//        }
        invalidate();
    }


    private void invalidateTextPaintAndMeasurements() {
        mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
//        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        // TODO: consider storing these as member variables to reduce
//        // allocations per draw cycle.
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//
//        int contentWidth = getWidth() - paddingLeft - paddingRight;
//        int contentHeight = getHeight() - paddingTop - paddingBottom;
//
//        // Draw the text.
//        canvas.drawText(mExampleString,
//                paddingLeft + (contentWidth - mTextWidth) / 2,
//                paddingTop + (contentHeight + mTextHeight) / 2,
//                mTextPaint);
//
//        // Draw the example drawable on top of the text.
//        if (mExampleDrawable != null) {
//            mExampleDrawable.setBounds(paddingLeft, paddingTop,
//                    paddingLeft + contentWidth, paddingTop + contentHeight);
//            mExampleDrawable.draw(canvas);
//        }
//    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getExampleString() {
        return mExampleString;
    }

    /**
     * Sets the view's example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
    public void setExampleString(String exampleString) {
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return mExampleColor;
    }

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    public float getExampleDimension() {
        return mExampleDimension;
    }

    /**
     * Sets the view's example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
    public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
    public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }

    public void setReflecting(IjkVideoView reflecting) {
        this.reflecting = reflecting;
    }
}
