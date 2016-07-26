package sk.kebapp.weer.widget.stereoscopic;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import sk.kebapp.weer.widget.media.IjkVideoView;

/**
 * Created by erikhric on 19/07/16.
 */
public class LeftEyeView extends IjkVideoView {
    public LeftEyeView(Context context) {
        super(context);
    }

    public LeftEyeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftEyeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LeftEyeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.translate(50,50);
//        canvas.restore();
    }
}
