/*
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sk.kebapp.weer.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import sk.kebapp.weer.R;

public class Settings {
    private Context mAppContext;
    private SharedPreferences mSharedPreferences;

    public static final int PV_PLAYER__Auto = 0;
    public static final int PV_PLAYER__AndroidMediaPlayer = 1;
    public static final int PV_PLAYER__IjkMediaPlayer = 2;
    public static final int PV_PLAYER__IjkExoMediaPlayer = 3;

    public Settings(Context context) {
        mAppContext = context.getApplicationContext();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mAppContext);
    }

    public boolean getEnableBackgroundPlay() {
//        String key = mAppContext.getString(R.string.pref_key_enable_background_play);
        return false;
    }

    public int getPlayer() {
//        String key = mAppContext.getString(R.string.pref_key_player);
//        String value = mSharedPreferences.getString(key, "");
        try {
            return 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public boolean getUsingMediaCodec() {
        return true;
    }

    public boolean getUsingMediaCodecAutoRotate() {

        return false;
    }

    public boolean getUsingOpenSLES() {

        return true;
    }

    public String getPixelFormat() {
        return null;
    }

    public boolean getEnableNoView() {
        return false;
    }

    public boolean getEnableSurfaceView() {
//        String key = mAppContext.getString(R.string.pref_key_enable_surface_view);
        return false;
    }

    public boolean getEnableTextureView() {
//        String key = mAppContext.getString(R.string.pref_key_enable_texture_view);
        return true;
    }

    public boolean getEnableDetachedSurfaceTextureView() {
//        String key = mAppContext.getString(R.string.pref_key_enable_detached_surface_texture);
        return true;
    }

    public String getLastDirectory() {
//        String key = mAppContext.getString(R.string.pref_key_last_directory);
        return null;
    }

    public void setLastDirectory(String path) {
//        String key = mAppContext.getString(R.string.pref_key_last_directory);
//        mSharedPreferences.edit().putString(key, path).apply();
    }
}
