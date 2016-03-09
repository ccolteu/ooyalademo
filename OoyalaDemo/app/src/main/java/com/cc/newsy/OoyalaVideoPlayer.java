package com.cc.newsy;

import android.util.Log;
import android.view.ViewGroup;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.OoyalaPlayerLayout;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.ui.OoyalaPlayerLayoutController;

import java.util.Observable;
import java.util.Observer;

public class OoyalaVideoPlayer implements Observer {

    public static final String DOMAIN = "http://android.newsy.com";
    public static final String ADSET_CODE = "545689667ddd485eafeb574426315d86";
    private static final String PCODE = "94b2a1894a934bf480f92b7834111093";
    private OoyalaPlayer mOoyalaPlayer;
    private OoyalaPlayerLayoutController mPlayerLayoutController;

    public void init(ViewGroup videoPlayerLayout) {
        if (mOoyalaPlayer == null) {
            mOoyalaPlayer = new OoyalaPlayer(PCODE, new PlayerDomain(DOMAIN));
            mPlayerLayoutController = new OoyalaPlayerLayoutController((OoyalaPlayerLayout)videoPlayerLayout, mOoyalaPlayer);
            mPlayerLayoutController.setFullscreenButtonShowing(false);
            mOoyalaPlayer.addObserver(this);
        }
    }

    public void playVideo(String videoToPlay) {
        mOoyalaPlayer.setEmbedCodeWithAdSetCode(videoToPlay, ADSET_CODE);
        mOoyalaPlayer.setPlayheadTime(0);
        mOoyalaPlayer.play();
    }

    @Override
         public void update(Observable observable, Object data) {
        if (data == OoyalaPlayer.AD_COMPLETED_NOTIFICATION){
            Log.d("toto", data + " - state: " + mOoyalaPlayer.getState());
        }
        if (data == OoyalaPlayer.AD_STARTED_NOTIFICATION){
            Log.d("toto", data + " - state: " + mOoyalaPlayer.getState());
        }
    }
}
