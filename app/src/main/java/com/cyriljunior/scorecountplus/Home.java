package com.cyriljunior.scorecountplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by CyrilJnr on 7/2/15.
 */
public class Home extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void NewGame(View view){
            Intent teamAddIntent = new Intent(this, TeamAdd.class);
            startActivity(teamAddIntent);

    }
}
