package com.example.pedram.master4;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout summeryLinearLayout;
    //TextView
    TextView questionTextView;
    TextView scoreTextView;
    TextView timerTextView;
    TextView finalScoreTextView;
    TextView highscoreTextView;
    TextView isCorrectTextView;
    //button
    Button optionAButton;
    Button optionBButton;
    Button optionCButton;
    Button optionDButton;
    //Classes
    MediaPlayer mediaPlayer;
    Problem problem;
    Options options;
    Score score;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialization
        summeryLinearLayout = (LinearLayout) findViewById(R.id.summeryLinearLayout);
        questionTextView = (TextView) findViewById(R.id.questionTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        timerTextView = (TextView) findViewById(R.id.timeTextView);
        highscoreTextView = (TextView) findViewById(R.id.highscoreTextView);
        finalScoreTextView = (TextView) findViewById(R.id.finalScoreTextView);
        isCorrectTextView = (TextView) findViewById(R.id.isCorrect);
        optionAButton = (Button) findViewById(R.id.AButton);
        optionBButton = (Button) findViewById(R.id.BButton);
        optionCButton = (Button) findViewById(R.id.CButton);
        optionDButton = (Button) findViewById(R.id.DButton);
        //Incantation
        mediaPlayer = MediaPlayer.create(this, R.raw.ding);
        timer = new Timer(timerTextView, summeryLinearLayout, mediaPlayer);
        problem = new Problem();
        options = new Options();
        score = new Score();
        reset();
    }

    public void click(View view) {
        Button optionButton = (Button) view;
        score.setChoice(Integer.parseInt(optionButton.getText().toString()), problem);
        scoreTextView.setText(score.getScore());
        finalScoreTextView.setText(score.getScore());
        highscoreTextView.setText(score.getHighScore());
        isCorrectTextView.setText(score.getIsCorrect());
        if (isCorrectTextView.getText() == "TRUE")
            isCorrectTextView.setTextColor(Color.rgb(50, 200, 100));
        else
            isCorrectTextView.setTextColor(Color.RED);
        reset();
    }
    public void reset() {
        problem.generate();
        questionTextView.setText(problem.getQuestion());
        options.generate(problem);
        optionAButton.setText(options.getOptionA());
        optionBButton.setText(options.getOptionB());
        optionCButton.setText(options.getOptionC());
        optionDButton.setText(options.getOptionD());
    }
    public void restart(View view) {
        reset();
        score.reset();
        scoreTextView.setText("0");
        timer.resetTimer();
        summeryLinearLayout.setVisibility(View.INVISIBLE);
    }
}