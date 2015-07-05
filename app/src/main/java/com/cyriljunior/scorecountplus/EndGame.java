package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    String homeTeam, awayTeam, hScore, aScore;
    int homeScore, awayScore, minutes, quarter;

    GameDatabaseAdapter gameHelper;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        gameHelper = new GameDatabaseAdapter(this);


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

        hScore = String.valueOf(homeScore);
        aScore = String.valueOf(awayScore);

    }


    public void cancel(View view){
        Intent initial = new Intent(this, Home.class);
        startActivity(initial);
    }


    public void saveGame(View view){
        long id = gameHelper.insertData(homeTeam, awayTeam, homeScore, awayScore);

        if(id<0){
            Message.message(this, "Unable to Save Game");
        }
        else{
            Message.message(this,"Game Successfully Saved");
        }

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        }

}
