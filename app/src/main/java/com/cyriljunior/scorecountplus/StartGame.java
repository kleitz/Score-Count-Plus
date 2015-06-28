package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CyrilJnr on 6/28/15.
 */
public class StartGame extends Activity {

    TextView homeTeamView;
    TextView awayTeamView;
    TextView timer;

    int homeScore = 0;
    int awayScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);

        homeTeamView = (TextView)findViewById(R.id.home_team_view);
        awayTeamView = (TextView)findViewById(R.id.away_team_view);
        timer = (TextView) findViewById(R.id.timer);
    }
    public void displayScoreHome(int points){
        TextView homeScore = (TextView) findViewById(R.id.homeScore);
        homeScore.setText(String.valueOf(points));
    }
    public void displayScoreAway(int points){
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
