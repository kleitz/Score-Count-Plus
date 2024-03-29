package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TeamAdd extends Activity {

    EditText homeTeam;
    EditText awayTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_add);

        homeTeam = (EditText)findViewById(R.id.homeTeam);
        awayTeam = (EditText) findViewById(R.id.awayTeam);
    }



    public void btnSetTimer(View view){
        if(homeTeam.getText().toString().isEmpty() && awayTeam.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter Home & Away Teams", Toast.LENGTH_LONG).show();
        }
        else{
            Intent setTimeIntent = new Intent(this, setTimer.class);
            setTimeIntent.putExtra("homeTeam", homeTeam.getText().toString());
            setTimeIntent.putExtra("awayTeam", awayTeam.getText().toString());
            startActivity(setTimeIntent);
        }

    }


}
