package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by CyrilJnr on 7/2/15.
 */
public class Home extends Activity {


    GameDatabaseAdapter gameHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gameHelper = new GameDatabaseAdapter(this);
    }

    public void NewGame(View view){
            Intent teamAddIntent = new Intent(this, TeamAdd.class);
            startActivity(teamAddIntent);
    }
    public void GameHistory(View view){
        String data = gameHelper.getAllData();
        Message.message(this, data);
    }
}
