package com.cyriljunior.scorecountplus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TeamAdd extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_add);
    }

    public void setTimerButton(View view){
        Intent setTimeIntent = new Intent(this,setTimer.class);
        startActivity(setTimeIntent);
    }



}
