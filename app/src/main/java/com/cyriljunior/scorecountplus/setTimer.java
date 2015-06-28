package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class setTimer extends Activity {

    TextView homeTeamView;
    TextView awayTeamView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_timer);

        homeTeamView = (TextView)findViewById(R.id.homeTeamName);
        awayTeamView = (TextView)findViewById(R.id.awayTeamName);

        Intent setTimer = getIntent();

        String homeTeam = setTimer.getStringExtra("homeTeam");
        String awayTeam = setTimer.getStringExtra("awayTeam");

        homeTeamView.setText(homeTeam);
        awayTeamView.setText(awayTeam);

    }

    int quarter = 1;
    int minutes = 1;

    public void displayQuarter(int quarters) {
        TextView quarter = (TextView) findViewById(R.id.quarter_text_view);
        quarter.setText(String.valueOf(quarters));
    }

    public void displayMinutes(int minutes){
        TextView minute = (TextView) findViewById(R.id.minutes_text_view);
        minute.setText(String.valueOf(minutes));
    }

    public void addQuarter(View view){
        if (quarter>=4){
            quarter = 4;
        }
        else {
            quarter += 1;
        }
        displayQuarter(quarter);
    }
    public void subtractQuarter(View view){
        if (quarter==1){
            quarter = 1;
        }
        else {
            quarter -= 1;
        }
        displayQuarter(quarter);
    }

        public void addMinute(View view){
            if (minutes>=15)
            {
                minutes = 15;
            }
            else{
                minutes += 1;
            }
        displayMinutes(minutes);
    }
    public void subtractMinute(View view){
        if (minutes==1){
            minutes = 1;
        }
        else {
            minutes -= 1;
        }
        displayMinutes(minutes);
    }

    public void startGame(View view){
        Intent intent = new Intent(this,StartGame.class);
        intent = intent.putExtra("minutes", minutes);
        intent = intent.putExtra("quarter", quarter);
        intent = intent.putExtra("homeTeam", homeTeamView.getText().toString());
        intent = intent.putExtra("awayTeam", awayTeamView.getText().toString());
        startActivity(intent);
    }


}
