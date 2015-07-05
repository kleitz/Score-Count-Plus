package com.cyriljunior.scorecountplus;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by CyrilJnr on 7/5/15.
 */
public class Message {
    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
