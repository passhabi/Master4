package com.example.pedram.master4;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Pedram on 6/24/2017.
 */

public class Timer {
    private int time;
    private CountDownTimer countDownTimer;

    public Timer(final TextView timerTextView, final LinearLayout summeryLayout, final MediaPlayer mediaPlayer) {

        countDownTimer = new CountDownTimer(60000 + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = (int) (millisUntilFinished / 1000);
                if (time >= 10)
                    timerTextView.setText("0:" + String.valueOf(time));
                else
                    timerTextView.setText("0:0" + String.valueOf(time));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0:00");
                summeryLayout.setVisibility(View.VISIBLE);
                mediaPlayer.start();
            }
        }.start();
    }

    public void resetTimer() {
        countDownTimer.cancel();
        countDownTimer.start();
    }
}
