package sk.kebapp.weer.activities;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.webkit.WebView;

import sk.kebapp.weer.R;
import sk.kebapp.weer.widget.opengl.GLRenderable;
import sk.kebapp.weer.widget.opengl.ViewToGLRenderer;
import sk.kebapp.weer.widget.opengl.renderer.CubeGLRenderer;
import sk.kebapp.weer.widget.stereoscopic.ReflectedView;

public class SimulatedStereoscopic extends VideoActivity {


    private GLSurfaceView mGLSurfaceView;
    private GLRenderable mGLLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simulated_stereoscopic);

        ReflectedView reflectedView = (ReflectedView) findViewById(R.id.reflected);
        reflectedView.setReflecting(getmVideoView());

//
        ViewToGLRenderer viewToGlRenderer = new CubeGLRenderer(this);

//        mGLSurfaceView = (GLSurfaceView) findViewById(R.id.left_gl_surface_view);
        mGLLinearLayout = reflectedView;


//        mGLSurfaceView.setEGLContextClientVersion(2);
//        mGLSurfaceView.setRenderer(viewToGlRenderer);

        mGLLinearLayout.setViewToGLRenderer(viewToGlRenderer);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_simulated_stereoscopic;
    }

    public int getIjkVideoViewID(){
        return R.id.video_viewLeft;
    }


    public static Intent newIntent(Context context, String videoPath, String videoTitle) {
        Intent intent = new Intent(context, SimulatedStereoscopic.class);
        intent.putExtra("videoPath", videoPath);
        intent.putExtra("videoTitle", videoTitle);
        return intent;
    }
    public static void intentTo(Context context, String videoPath, String videoTitle) {
        context.startActivity(newIntent(context, videoPath, videoTitle));
    }
}
