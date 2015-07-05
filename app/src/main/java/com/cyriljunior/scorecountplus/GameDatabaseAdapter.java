package com.cyriljunior.scorecountplus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CyrilJnr on 7/5/15.
 */
public class GameDatabaseAdapter{

    GameHelper helper;
    public GameDatabaseAdapter(Context context){
        helper = new GameHelper(context);
    }
    public long insertData(String homeTeam, String awayTeam, int homeScore, int awayScore){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GameHelper.HOMETEAM, homeTeam);
        contentValues.put(GameHelper.AWAYTEAM, awayTeam);
        contentValues.put(GameHelper.HOMESCORE, homeScore);
        contentValues.put(GameHelper.AWAYSCORE, awayScore);
        long id = db.insert(GameHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getAllData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {GameHelper.UID, GameHelper.HOMETEAM, GameHelper.AWAYTEAM, GameHelper.HOMESCORE, GameHelper.AWAYSCORE};
        Cursor cursor = db.query(GameHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {

            int cid = cursor.getInt(0);
            String homeTeam = cursor.getString(1);
            String awayTeam = cursor.getString(2);
            String homeScore = cursor.getString(3);
            String awayScore = cursor.getString(4);

            buffer.append (cid + " " +homeTeam+ " (" +homeScore+ ") vs "+awayTeam+ " (" +awayScore+ ")\n" );
        }
        return buffer.toString();
    }

    static class GameHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "GameTimeDB";
        private static final String TABLE_NAME = "GAMESHISTORY";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String HOMETEAM = "homeTeam";
        private static final String AWAYTEAM = "awayTeam";
        private static final String HOMESCORE = "homeScore";
        private static final String AWAYSCORE = "awayScore";
        private static final String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+HOMETEAM+" VARCHAR(255), "+AWAYTEAM+" VARCHAR(255), " +
                ""+HOMESCORE+" INTEGER, "+AWAYSCORE+" INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

        private Context context;

        public GameHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Message.message(context, ""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Message.message(context, ""+e);
            }
        }
    }
}
