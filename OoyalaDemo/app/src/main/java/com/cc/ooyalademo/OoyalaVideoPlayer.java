package com.cc.ooyalademo;

import android.view.ViewGroup;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.OoyalaPlayerLayout;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.ui.OoyalaPlayerLayoutController;

public class OoyalaVideoPlayer {

    public static final String DOMAIN = "http://android.cc.com";
    public static final String ADSET_CODE = "b684d84a764b487d9aea08751caf245b";//"545689667ddd485eafeb574426315d86";
    private static final String PCODE = "94b2a1894a934bf480f92b7834111093";
    private OoyalaPlayer mOoyalaPlayer;
    private OoyalaPlayerLayoutController mPlayerLayoutController;

    public void init(ViewGroup videoPlayerLayout) {
        if (mOoyalaPlayer == null) {

            mOoyalaPlayer = new OoyalaPlayer(PCODE, new PlayerDomain(DOMAIN));
            mPlayerLayoutController =
                    new OoyalaPlayerLayoutController((OoyalaPlayerLayout)videoPlayerLayout,
                            mOoyalaPlayer);

            mPlayerLayoutController.setFullscreenButtonShowing(false);
        }
    }

    public void playVideo(String videoToPlay) {
        mOoyalaPlayer.setEmbedCodeWithAdSetCode(videoToPlay, ADSET_CODE);
        mOoyalaPlayer.setPlayheadTime(0);
        mOoyalaPlayer.play();
    }

    public void pause() {
        mOoyalaPlayer.pause();
    }

    public void suspend() {
        mOoyalaPlayer.suspend();
    }

    public void setVisibility(int visibility) {
        mOoyalaPlayer.getLayout().setVisibility(visibility);
        if (visibility == ViewGroup.VISIBLE) {
            mPlayerLayoutController.getControls().setVisible(true);
        } else {
            mPlayerLayoutController.getControls().setVisible(false);
        }
    }

    public void seek(int playHeadTime) {
        mOoyalaPlayer.seek(playHeadTime);
    }
}
