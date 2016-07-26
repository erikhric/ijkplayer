package sk.kebapp.weer.testing;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

/**
 * Application's main Activity. Does nothing special apart from putting the app
 * in fullscreen mode and creating a GLLayer object as well as a Preview object.
 * 
 * @author Niels
 *
 */
public class GLCamTest extends Activity {
	private Preview mPreview;
	private GLLayer glView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        final Window win = getWindow(); 
        win.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        glView=new GLLayer(this);
        mPreview = new Preview(this, glView);

        setContentView(glView);
        addContentView(mPreview, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }
}