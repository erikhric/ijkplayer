package sk.kebapp.weer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sk.kebapp.weer.R;

public class StereoscopicActivity extends VideoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_stereoscopic);


    }

    @Override
    public int getIjkVideoViewID() {
        return R.id.video_viewLeftEye;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_stereoscopic;
    }

    public static Intent newIntent(Context context, String videoPath, String videoTitle) {
        Intent intent = new Intent(context, StereoscopicActivity.class);
        intent.putExtra("videoPath", videoPath);
        intent.putExtra("videoTitle", videoTitle);
        return intent;
    }

    public static void intentTo(Context context, String videoPath, String videoTitle) {
        context.startActivity(newIntent(context, videoPath, videoTitle));
    }

    public int getHudID() {
        return R.id.hud_view3;
    }
}
