package com.cyriljunior.scorecountplus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")


public class StartGame extends Activity {

//Create Text relations to the various Text Views
    TextView homeTeamView;
    TextView awayTeamView;
    TextView timer_text_view;
    TextView quarter_number;
    Button startButton;


//Global Variables we'll need
    int homeScore = 0;
    int awayScore = 0;
    int  quarter;
    int minutes;
    long min;
    int i=1;

    CounterClass timer;

//Assign TeXt Views to Elements in Java and getExtra from Intent
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);

    //Assign Text Views to the Elements we created
        homeTeamView = (TextView)findViewById(R.id.home_team_view);
        awayTeamView = (TextView)findViewById(R.id.away_team_view);
        timer_text_view = (TextView) findViewById(R.id.timer);
        quarter_number = (TextView) findViewById(R.id.quarter_number);
        startButton = (Button) findViewById(R.id.startButton);

    //GetExtras from previous Intent
        Intent StartGame = getIntent();
        String homeTeam = StartGame.getStringExtra("homeTeam");
        String awayTeam = StartGame.getStringExtra("awayTeam");
        quarter = StartGame.getIntExtra("quarter", 0);
        minutes = StartGame.getIntExtra("minutes", 0);
        min = StartGame.getLongExtra("min", 0);


        homeTeamView.setText(homeTeam);
        awayTeamView.setText(awayTeam);
        timer_text_view.setText("00:" + minutes + ":00");
        quarter_number.setText("1");

        timer = new CounterClass(min, 1000);

    }




    public void startTimer(View view){

        timer.start();

    }
    public void resetTimer(View view){
        timer.cancel();
        homeScore = 0;
        awayScore = 0;
        displayScoreHome(0);
        displayScoreAway(0);
        timer_text_view.setText("00:" + minutes + ":00");
    }



//Display
    private void displayScoreHome(int points){
        TextView homeScore = (TextView) findViewById(R.id.homeScore);
        homeScore.setText(String.valueOf(points));
    }
    private void displayScoreAway(int points){
        TextView awayScore = (TextView)findViewById(R.id.awayScore);
        awayScore.setText(String.valueOf(points));
    }

    public void pointAddHome(int points){
        homeScore += points;
    }
    public void pointAddAway(int points){
        awayScore += points;
    }

    public void threePointsHome(View view){
        pointAddHome(3);
        displayScoreHome(homeScore);
    }
    public void twoPointsHome(View view){
        pointAddHome(2);
        displayScoreHome(homeScore);
    }
    public void onePointHome(View view){
        pointAddHome(1);
        displayScoreHome(homeScore);
    }


    public void threePointsAway(View view){
        pointAddAway(3);
        displayScoreAway(awayScore);
    }
    public void twoPointsAway(View view){
        pointAddAway(2);
        displayScoreAway(awayScore);
    }
    public void onePointAway(View view){
        pointAddAway(1);
        displayScoreAway(awayScore);
    }






    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer{



        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;




            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            timer_text_view.setText(hms);
        }

        @Override
        public void onFinish() {
            if(i<quarter) {
                timer_text_view.setText("00:" + minutes + ":00");
                i++;
                quarter_number.setText(String.valueOf(i));
                startButton.setText("Start Quarter " + i);

            }
            else
                timer_text_view.setText("FT");

        }
    }

}
