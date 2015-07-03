package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CyrilJnr on 7/2/15.
 */
public class EndGame extends Activity {


//Text Views We'll be Updating
    TextView quarterView;
    TextView minutesView;
    TextView homeTeamView;
    TextView homeScoreView;
    TextView awayTeamView;
    TextView awayScoreView;

//Global Variables we'll need
    String homeTeam, awayTeam;
    int homeScore, awayScore, minutes, quarter;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

    //Assign TextView elements to xml TextViews
        quarterView = (TextView)findViewById(R.id.end_game_quarter_view);
        minutesView = (TextView)findViewById(R.id.end_game_minutes_view);
        homeTeamView = (TextView)findViewById(R.id.end_game_home_view);
        homeScoreView = (TextView)findViewById(R.id.end_game_home_score_view);
        awayTeamView = (TextView)findViewById(R.id.end_game_away_view);
        awayScoreView = (TextView)findViewById(R.id.end_game_away_score_view);

    //Receive Data from Intent
        Intent intent = getIntent();
        homeTeam = intent.getStringExtra("homeTeamView");
        awayTeam = intent.getStringExtra("awayTeamView");
        homeScore = intent.getIntExtra("homeScore", 0);
        awayScore = intent.getIntExtra("awayScore", 0);
        minutes = intent.getIntExtra("minutes", 0);
        quarter = intent.getIntExtra("quarter",0);

    //Set TextViews with values passed form intent
        quarterView.setText(String.valueOf(quarter));
        minutesView.setText(String.valueOf(minutes));
        homeScoreView.setText(String.valueOf(homeScore));
        awayScoreView.setText(String.valueOf(awayScore));
        homeTeamView.setText(homeTeam);
        awayTeamView.setText(awayTeam);

    }


    public void cancel(View view){
        Intent initial = new Intent(this, Home.class);
        startActivity(initial);
    }


    public void saveGame(View view){

        }


}
