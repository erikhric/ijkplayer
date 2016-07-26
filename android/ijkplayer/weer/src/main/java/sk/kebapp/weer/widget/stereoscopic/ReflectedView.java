package sk.kebapp.weer.widget.stereoscopic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import sk.kebapp.weer.R;
import sk.kebapp.weer.widget.media.IjkVideoView;
import sk.kebapp.weer.widget.media.SurfaceRenderView;
import sk.kebapp.weer.widget.media.TextureRenderView;
import sk.kebapp.weer.widget.opengl.GLRenderable;
import sk.kebapp.weer.widget.opengl.ViewToGLRenderer;

public class ReflectedView extends View implements GLRenderable{

    private IjkVideoView reflecting;


    public ReflectedView(Context context) {
        super(context);
    }

    public ReflectedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReflectedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private ViewToGLRenderer mViewToGLRenderer;

    @Override
    public void setViewToGLRenderer(ViewToGLRenderer mViewToGLRenderer) {
        this.mViewToGLRenderer = mViewToGLRenderer;
    }

//    @Override
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
////        returns canvas attached to gl texture to draw on
//        Canvas glAttachedCanvas = mViewToGLRenderer.onDrawViewBegin();
//        if(glAttachedCanvas != null) {
//            //translate canvas to reflect view scrolling
//            float xScale = glAttachedCanvas.getWidth() / (float)canvas.getWidth();
//            glAttachedCanvas.scale(xScale, xScale);
//            glAttachedCanvas.translate(-getScrollX(), -getScrollY());
//            //draw the view to provided canvas
//
//            reflecting.draw(glAttachedCanvas);
//        }
//        // notify the canvas is updated
//        mViewToGLRenderer.onDrawViewEnd();
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (reflecting != null)
            reflecting.draw(canvas);
        invalidate();
    }

    public void setReflecting(IjkVideoView reflecting) {
        this.reflecting = reflecting;
    }
}
