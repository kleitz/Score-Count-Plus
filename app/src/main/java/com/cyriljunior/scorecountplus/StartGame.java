package com.cyriljunior.scorecountplus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.lang.annotation.Target;
import java.util.concurrent.CountDownLatch;

/**
 * Created by CyrilJnr on 6/28/15.
 */


public class StartGame extends Activity {

//Create Text relations to the various Text Views
    TextView homeTeamView;
    TextView awayTeamView;
    TextView timer;


//Global Variables we'll need
    int homeScore = 0;
    int awayScore = 0;
    int minute, quarter;
    int millisecs = minute * 60 * 60;

//Assign TeXt Views to Elements in Java and getExtra from Intent
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);

    //Assign Text Views to the Elements we created
        homeTeamView = (TextView)findViewById(R.id.home_team_view);
        awayTeamView = (TextView)findViewById(R.id.away_team_view);
        timer = (TextView) findViewById(R.id.timer);

    //GetExtras from previous Intent
        Intent StartGame = getIntent();
        String homeTeam = StartGame.getStringExtra("homeTeam");
        String awayTeam = StartGame.getStringExtra("awayTeam");
        minute = StartGame.getIntExtra("minutes", 0);
        quarter = StartGame.getIntExtra("quarters",0);


        homeTeamView.setText(homeTeam);
        awayTeamView.setText(awayTeam);
        timer.setText(minute + ":00");
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

}
