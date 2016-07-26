package sk.kebapp.weer.activities;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import sk.kebapp.weer.R;
import sk.kebapp.weer.widget.opengl.GLRenderable;
import sk.kebapp.weer.widget.opengl.ViewToGLRenderer;
import sk.kebapp.weer.widget.opengl.renderer.CubeGLRenderer;

public class TestActivity extends VideoActivity {

    private GLSurfaceView mGLSurfaceView;
    private GLRenderable mGLLinearLayout;
    public static ViewToGLRenderer viewToGlRenderer;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        initViews();
//    }

    private void initViews() {
        viewToGlRenderer = new CubeGLRenderer(this);

        mGLSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);
        mGLLinearLayout = (GLRenderable) findViewById(R.id.gl_layout);
//        mWebView = (WebView) findViewById(R.id.web_view);

        mGLSurfaceView.setEGLContextClientVersion(2);
        mGLSurfaceView.setRenderer(viewToGlRenderer);

        mGLLinearLayout.setViewToGLRenderer(viewToGlRenderer);

        mGLSurfaceView.bringToFront();

//        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.setWebChromeClient(new WebChromeClient());
//        mWebView.loadUrl("https://github.com/google/grafika");
    }

    public static Intent newIntent(Context context, String videoPath, String videoTitle) {
        Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra("videoPath", videoPath);
        intent.putExtra("videoTitle", videoTitle);
        return intent;
    }

    public static void intentTo(Context context, String videoPath, String videoTitle) {
        context.startActivity(newIntent(context, videoPath, videoTitle));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    public int getIjkVideoViewID(){
        return R.id.video_viewLeft;
    }

}
