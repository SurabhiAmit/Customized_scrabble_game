/*Utilized tutorialspoint.com as resource.*/

package edu.gatech.seclass.words6300;


import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.DatabaseUtils;
import java.util.Random;

public class DB_Manager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SingleScrabbler.db";

    public static final String GAME_TABLE_NAME = "GameInfo";
    public static final String GAME_COLUMN_ID = "id_game";
    public static final String GAME_COLUMN_SCORE = "score";
    public static final String GAME_COLUMN_ADD10 = "add10";
    public static final String GAME_COLUMN_TURNCOUNT = "turnCount";
    public static final String GAME_COLUMN_ENDED = "gameFinish";
    public static final String GAME_COLUMN_BOARD = "board";
    public static final String GAME_COLUMN_RACK = "rack";

    public static final String SETTINGS_TABLE_NAME = "GameSettings";
    public static final String SETTINGS_COLUMN_ID = "id_settings";
    public static final String SETTINGS_COLUMN_MAXTURNS = "maxTurns";
    public static final String SETTINGS_COLUMN_A = "A";
    public static final String SETTINGS_COLUMN_B = "B";
    public static final String SETTINGS_COLUMN_C = "C";
    public static final String SETTINGS_COLUMN_D = "D";
    public static final String SETTINGS_COLUMN_E = "E";
    public static final String SETTINGS_COLUMN_F = "F";
    public static final String SETTINGS_COLUMN_G = "G";
    public static final String SETTINGS_COLUMN_H = "H";
    public static final String SETTINGS_COLUMN_I = "I";
    public static final String SETTINGS_COLUMN_J = "J";
    public static final String SETTINGS_COLUMN_K = "K";
    public static final String SETTINGS_COLUMN_L = "L";
    public static final String SETTINGS_COLUMN_M = "M";
    public static final String SETTINGS_COLUMN_N = "N";
    public static final String SETTINGS_COLUMN_O = "O";
    public static final String SETTINGS_COLUMN_P = "P";
    public static final String SETTINGS_COLUMN_Q = "Q";
    public static final String SETTINGS_COLUMN_R = "R";
    public static final String SETTINGS_COLUMN_S = "S";
    public static final String SETTINGS_COLUMN_T = "T";
    public static final String SETTINGS_COLUMN_U = "U";
    public static final String SETTINGS_COLUMN_V = "V";
    public static final String SETTINGS_COLUMN_W = "W";
    public static final String SETTINGS_COLUMN_X = "X";
    public static final String SETTINGS_COLUMN_Y = "Y";
    public static final String SETTINGS_COLUMN_Z = "Z";

    public static final String WB_TABLE_NAME = "WordBank";
    public static final String WB_COLUMN_ID = "id_word";
    public static final String WB_COLUMN_WORD = "word";

    public static final String STATS_TABLE_NAME = "LetterStats";
    public static final String STATS_COLUMN_ID = "id_letterStats";
    public static final String STATS_COLUMN_A = "A";
    public static final String STATS_COLUMN_B = "B";
    public static final String STATS_COLUMN_C = "C";
    public static final String STATS_COLUMN_D = "D";
    public static final String STATS_COLUMN_E = "E";
    public static final String STATS_COLUMN_F = "F";
    public static final String STATS_COLUMN_G = "G";
    public static final String STATS_COLUMN_H = "H";
    public static final String STATS_COLUMN_I = "I";
    public static final String STATS_COLUMN_J = "J";
    public static final String STATS_COLUMN_K = "K";
    public static final String STATS_COLUMN_L = "L";
    public static final String STATS_COLUMN_M = "M";
    public static final String STATS_COLUMN_N = "N";
    public static final String STATS_COLUMN_O = "O";
    public static final String STATS_COLUMN_P = "P";
    public static final String STATS_COLUMN_Q = "Q";
    public static final String STATS_COLUMN_R = "R";
    public static final String STATS_COLUMN_S = "S";
    public static final String STATS_COLUMN_T = "T";
    public static final String STATS_COLUMN_U = "U";
    public static final String STATS_COLUMN_V = "V";
    public static final String STATS_COLUMN_W = "W";
    public static final String STATS_COLUMN_X = "X";
    public static final String STATS_COLUMN_Y = "Y";
    public static final String STATS_COLUMN_Z = "Z";

    public static final String POOL_TABLE_NAME = "Pool";
    public static final String POOL_COLUMN_ID = "letterID";
    public static final String POOL_COLUMN_LETTER = "letter";
    public static final String POOL_COLUMN_COUNT = "count";
    public static final String POOL_COLUMN_LETTERFINISHED = "letterFinished";

    private HashMap hp;

    public DB_Manager(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //GameInfo
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + GAME_TABLE_NAME + "("
                + GAME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + GAME_COLUMN_SCORE + " INTEGER,"
                + GAME_COLUMN_TURNCOUNT + " INTEGER,"
                + GAME_COLUMN_ADD10 + " BOOLEAN,"
                + GAME_COLUMN_ENDED + " BOOLEAN,"
                + GAME_COLUMN_BOARD + " TEXT,"
                + GAME_COLUMN_RACK + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);

        //Settings
        String CREATE_TABLE_SETTINGS = "CREATE TABLE IF NOT EXISTS " + SETTINGS_TABLE_NAME + "("
                + SETTINGS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SETTINGS_COLUMN_MAXTURNS + " INTEGER,"
                + SETTINGS_COLUMN_A + " TEXT,"
                + SETTINGS_COLUMN_B + " TEXT,"
                + SETTINGS_COLUMN_C + " TEXT,"
                + SETTINGS_COLUMN_D + " TEXT,"
                + SETTINGS_COLUMN_E + " TEXT,"
                + SETTINGS_COLUMN_F + " TEXT,"
                + SETTINGS_COLUMN_G + " TEXT,"
                + SETTINGS_COLUMN_H + " TEXT,"
                + SETTINGS_COLUMN_I + " TEXT,"
                + SETTINGS_COLUMN_J + " TEXT,"
                + SETTINGS_COLUMN_K + " TEXT,"
                + SETTINGS_COLUMN_L + " TEXT,"
                + SETTINGS_COLUMN_M + " TEXT,"
                + SETTINGS_COLUMN_N + " TEXT,"
                + SETTINGS_COLUMN_O + " TEXT,"
                + SETTINGS_COLUMN_P + " TEXT,"
                + SETTINGS_COLUMN_Q + " TEXT,"
                + SETTINGS_COLUMN_R + " TEXT,"
                + SETTINGS_COLUMN_S + " TEXT,"
                + SETTINGS_COLUMN_T + " TEXT,"
                + SETTINGS_COLUMN_U + " TEXT,"
                + SETTINGS_COLUMN_V + " TEXT,"
                + SETTINGS_COLUMN_W + " TEXT,"
                + SETTINGS_COLUMN_X + " TEXT,"
                + SETTINGS_COLUMN_Y + " TEXT,"
                + SETTINGS_COLUMN_Z + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE_SETTINGS);

        //WordBank
        String CREATE_TABLE_WB = "CREATE TABLE IF NOT EXISTS " + WB_TABLE_NAME + "("
                + WB_COLUMN_WORD + " TEXT,"
                + WB_COLUMN_ID + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_WB);

        //LetterStats, id 1=played, 2=traded, 3=drawn
        String CREATE_TABLE_LETTERSTATS = "CREATE TABLE IF NOT EXISTS " + STATS_TABLE_NAME + "("
                + STATS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + STATS_COLUMN_A + " INTEGER,"
                + STATS_COLUMN_B + " INTEGER,"
                + STATS_COLUMN_C + " INTEGER,"
                + STATS_COLUMN_D + " INTEGER,"
                + STATS_COLUMN_E + " INTEGER,"
                + STATS_COLUMN_F + " INTEGER,"
                + STATS_COLUMN_G + " INTEGER,"
                + STATS_COLUMN_H + " INTEGER,"
                + STATS_COLUMN_I + " INTEGER,"
                + STATS_COLUMN_J + " INTEGER,"
                + STATS_COLUMN_K + " INTEGER,"
                + STATS_COLUMN_L + " INTEGER,"
                + STATS_COLUMN_M + " INTEGER,"
                + STATS_COLUMN_N + " INTEGER,"
                + STATS_COLUMN_O + " INTEGER,"
                + STATS_COLUMN_P + " INTEGER,"
                + STATS_COLUMN_Q + " INTEGER,"
                + STATS_COLUMN_R + " INTEGER,"
                + STATS_COLUMN_S + " INTEGER,"
                + STATS_COLUMN_T + " INTEGER,"
                + STATS_COLUMN_U + " INTEGER,"
                + STATS_COLUMN_V + " INTEGER,"
                + STATS_COLUMN_W + " INTEGER,"
                + STATS_COLUMN_X + " INTEGER,"
                + STATS_COLUMN_Y + " INTEGER,"
                + STATS_COLUMN_Z + " INTEGER"+ ")";
        db.execSQL(CREATE_TABLE_LETTERSTATS);

        //Pool
        String CREATE_TABLE_POOL = "CREATE TABLE IF NOT EXISTS " + POOL_TABLE_NAME + "("
                + POOL_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + POOL_COLUMN_LETTER + " TEXT,"
                + POOL_COLUMN_COUNT + " INTEGER,"
                + POOL_COLUMN_LETTERFINISHED + " BOOLEAN" + ")";
        db.execSQL(CREATE_TABLE_POOL);

        //INSERT_TABLE_LETTERSTATS ="Insert into " + STATS_TABLE_NAME + " values (3,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0)";
        //db.execSQL(INSERT_TABLE_LETTERSTATS);*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + GAME_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SETTINGS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + WB_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + STATS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + POOL_TABLE_NAME);
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new Game Details
    public void insertGameDetails(int score, boolean add10, int turncount, boolean ended){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(GAME_COLUMN_SCORE, score);
        cValues.put(GAME_COLUMN_ADD10, add10);
        cValues.put(GAME_COLUMN_TURNCOUNT, turncount);
        cValues.put(GAME_COLUMN_ENDED, ended);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(GAME_TABLE_NAME,null, cValues);

        db.close();
    }

    // Get Game Details
    public ArrayList<HashMap<String, String>> GetGames(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> gameList = new ArrayList<>();
        String query = "SELECT score, add10, turncount, ended FROM "+ GAME_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("score",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_SCORE)));
            user.put("add10",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_ADD10)));
            user.put("turncount",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_TURNCOUNT)));
            user.put("ended",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_ENDED)));
            gameList.add(user);
        }
        cursor.close();
        return  gameList;
    }

    // Get Game Details based on userid
    public ArrayList<HashMap<String, String>> GetGameByGameId(int gameid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> gameList = new ArrayList<>();
        String query = "SELECT score, add10, turncount, ended FROM "+ GAME_TABLE_NAME;
        Cursor cursor = db.query(GAME_TABLE_NAME, new String[]{GAME_COLUMN_SCORE, GAME_COLUMN_ADD10, GAME_COLUMN_TURNCOUNT, GAME_COLUMN_ENDED}, GAME_COLUMN_ID+ "=?",new String[]{String.valueOf(gameid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> game = new HashMap<>();
            game.put("score",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_SCORE)));
            game.put("add10",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_ADD10)));
            game.put("turncount",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_TURNCOUNT)));
            game.put("ended",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_ENDED)));
            gameList.add(game);
        }
        cursor.close();
        return  gameList;
    }

    // Update Game Details
    public int UpdateGameDetails(int score, boolean add10, int turncount, boolean ended, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(GAME_COLUMN_SCORE, score);
        cVals.put(GAME_COLUMN_ADD10, add10);
        cVals.put(GAME_COLUMN_TURNCOUNT, turncount);
        cVals.put(GAME_COLUMN_ENDED, ended);
        int count = db.update(GAME_TABLE_NAME, cVals, GAME_COLUMN_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }

    // GetLastGameID
    public int LastGameID(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT MAX(" + GAME_COLUMN_ID + ") FROM " + GAME_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        String count = cursor.getString(0);
        cursor.close();
        return  Integer.parseInt(count);
    }

    // Update the value in the board and the rack at end of each turn @ GameActivity
    public int updateBoardRack(int id, String board, String rack){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(GAME_COLUMN_BOARD, board);
        cVals.put(GAME_COLUMN_RACK, rack);
        int count = db.update(GAME_TABLE_NAME, cVals, GAME_COLUMN_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }

    // When returning to a game left in stand-by, we need to get the previous letters found both in the board and in the rack
    public ArrayList<HashMap<String, String>> getBoardRack(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> gameList = new ArrayList<>();
        String query = "SELECT board, rack FROM "+ GAME_TABLE_NAME;
        Cursor cursor = db.query(GAME_TABLE_NAME, new String[]{GAME_COLUMN_BOARD, GAME_COLUMN_RACK}, GAME_COLUMN_ID+ "=?",new String[]{String.valueOf(id)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> game = new HashMap<>();
            game.put("board",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_BOARD)));
            game.put("rack",cursor.getString(cursor.getColumnIndex(GAME_COLUMN_RACK)));
            gameList.add(game);
        }
        cursor.close();
        return  gameList;
    }

    // Delete Game Details
    public void DeleteGame(int gameid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GAME_TABLE_NAME, GAME_COLUMN_ID+" = ?",new String[]{String.valueOf(gameid)});
        db.close();
    }

    // Adding new Settings Details
    public void insertSettingsDetails(int maxTurns, String A, String B, String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V, String W, String X, String Y, String Z){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(SETTINGS_COLUMN_MAXTURNS, maxTurns);
        cValues.put(SETTINGS_COLUMN_A, A);
        cValues.put(SETTINGS_COLUMN_B, B);
        cValues.put(SETTINGS_COLUMN_C, C);
        cValues.put(SETTINGS_COLUMN_D, D);
        cValues.put(SETTINGS_COLUMN_E, E);
        cValues.put(SETTINGS_COLUMN_F, F);
        cValues.put(SETTINGS_COLUMN_G, G);
        cValues.put(SETTINGS_COLUMN_H, H);
        cValues.put(SETTINGS_COLUMN_I, I);
        cValues.put(SETTINGS_COLUMN_J, J);
        cValues.put(SETTINGS_COLUMN_K, K);
        cValues.put(SETTINGS_COLUMN_L, L);
        cValues.put(SETTINGS_COLUMN_M, M);
        cValues.put(SETTINGS_COLUMN_N, N);
        cValues.put(SETTINGS_COLUMN_O, O);
        cValues.put(SETTINGS_COLUMN_P, P);
        cValues.put(SETTINGS_COLUMN_Q, Q);
        cValues.put(SETTINGS_COLUMN_R, R);
        cValues.put(SETTINGS_COLUMN_S, S);
        cValues.put(SETTINGS_COLUMN_T, T);
        cValues.put(SETTINGS_COLUMN_U, U);
        cValues.put(SETTINGS_COLUMN_V, V);
        cValues.put(SETTINGS_COLUMN_W, W);
        cValues.put(SETTINGS_COLUMN_X, X);
        cValues.put(SETTINGS_COLUMN_Y, Y);
        cValues.put(SETTINGS_COLUMN_Z, Z);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(SETTINGS_TABLE_NAME,null, cValues);
        db.close();
    }

    // Get Settings
    public ArrayList<HashMap<String, String>> GetSettings(int settingsid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> settingsList = new ArrayList<>();
        String query = "SELECT maxTurns, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z FROM "+ SETTINGS_TABLE_NAME+ " where id_settings = "+settingsid;
        Cursor cursor = db.query(SETTINGS_TABLE_NAME, new String[]{SETTINGS_COLUMN_MAXTURNS, SETTINGS_COLUMN_A, SETTINGS_COLUMN_B, SETTINGS_COLUMN_C, SETTINGS_COLUMN_D, SETTINGS_COLUMN_E, SETTINGS_COLUMN_F, SETTINGS_COLUMN_G, SETTINGS_COLUMN_H, SETTINGS_COLUMN_I, SETTINGS_COLUMN_J, SETTINGS_COLUMN_K, SETTINGS_COLUMN_L, SETTINGS_COLUMN_M, SETTINGS_COLUMN_N, SETTINGS_COLUMN_O, SETTINGS_COLUMN_P, SETTINGS_COLUMN_Q, SETTINGS_COLUMN_R, SETTINGS_COLUMN_S, SETTINGS_COLUMN_T, SETTINGS_COLUMN_U, SETTINGS_COLUMN_V, SETTINGS_COLUMN_W, SETTINGS_COLUMN_X, SETTINGS_COLUMN_Y, SETTINGS_COLUMN_Z}, SETTINGS_COLUMN_ID+ "=" + settingsid,null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> settings = new HashMap<>();
            settings.put("maxTurns",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_MAXTURNS)));
            settings.put("A",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_A)));
            settings.put("B",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_B)));
            settings.put("C",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_C)));
            settings.put("D",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_D)));
            settings.put("E",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_E)));
            settings.put("F",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_F)));
            settings.put("G",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_G)));
            settings.put("H",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_H)));
            settings.put("I",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_I)));
            settings.put("J",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_J)));
            settings.put("K",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_K)));
            settings.put("L",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_L)));
            settings.put("M",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_M)));
            settings.put("N",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_N)));
            settings.put("O",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_O)));
            settings.put("P",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_P)));
            settings.put("Q",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_Q)));
            settings.put("R",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_R)));
            settings.put("S",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_S)));
            settings.put("T",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_T)));
            settings.put("U",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_U)));
            settings.put("V",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_V)));
            settings.put("W",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_W)));
            settings.put("X",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_X)));
            settings.put("Y",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_Y)));
            settings.put("Z",cursor.getString(cursor.getColumnIndex(SETTINGS_COLUMN_Z)));
            settingsList.add(settings);
        }
        cursor.close();
        return  settingsList;
    }

    // Adding to WordBank
    public void insertWBDetails(int id, String word){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(WB_COLUMN_WORD, word);
        cValues.put(WB_COLUMN_ID, id);
        // Insert the new row, returning the primary key value of the new row
        db.insert(WB_TABLE_NAME,null, cValues);
        db.close();
    }

    // Get Word Count
    public int GetWordCount(String wordToCount){
        //SQLiteDatabase db = this.getWritableDatabase();
        /*Cursor mCount= db.rawQuery("select count(*) from WordBank where word='" + wordToCount +"'", null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;*/

        SQLiteDatabase db = getReadableDatabase();
        try {
            String selectQuery =
                    "SELECT COUNT(*)" +
                            " FROM " + WB_TABLE_NAME +
                            " WHERE " + WB_COLUMN_WORD + " LIKE '" + wordToCount + "'";
            return (int) (long) DatabaseUtils.longForQuery(db, selectQuery, null);
        } finally {
            db.close();
        }
    }

    // Get Word Count for a specific game
    public Boolean checkIfUsed(int id, String wordToCount){
        //SQLiteDatabase db = this.getWritableDatabase();
        /*Cursor mCount= db.rawQuery("select count(*) from WordBank where word='" + wordToCount +"'", null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;*/

        SQLiteDatabase db = getReadableDatabase();
        try {
            String selectQuery =
                    "SELECT COUNT(*)" +
                            " FROM " + WB_TABLE_NAME +
                            " WHERE " + WB_COLUMN_WORD + " LIKE '" + wordToCount + "'" +
                            " AND " + WB_COLUMN_ID + " = " + id;
            return DatabaseUtils.longForQuery(db, selectQuery, null) > 0;
        } finally {
            db.close();
        }
    }

    // Prepare Letter Statistics - NOTE: MUST ONLY BE CALLED ONCE
    public void prepareLetterStats(){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Find the maximum id
        String query = "SELECT MAX(" + STATS_COLUMN_ID + ") FROM " + STATS_TABLE_NAME;
        //Number of rows
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int rows = cursor.getInt(0);
        //If the number of rows is 3 it means it was already created
        if(rows != 3){
            //Create a new map of values, where column names are the keys
            ContentValues cValues = new ContentValues();
            cValues.put(STATS_COLUMN_A, 0);
            cValues.put(STATS_COLUMN_B, 0);
            cValues.put(STATS_COLUMN_C, 0);
            cValues.put(STATS_COLUMN_D, 0);
            cValues.put(STATS_COLUMN_E, 0);
            cValues.put(STATS_COLUMN_F, 0);
            cValues.put(STATS_COLUMN_G, 0);
            cValues.put(STATS_COLUMN_H, 0);
            cValues.put(STATS_COLUMN_I, 0);
            cValues.put(STATS_COLUMN_J, 0);
            cValues.put(STATS_COLUMN_K, 0);
            cValues.put(STATS_COLUMN_L, 0);
            cValues.put(STATS_COLUMN_M, 0);
            cValues.put(STATS_COLUMN_N, 0);
            cValues.put(STATS_COLUMN_O, 0);
            cValues.put(STATS_COLUMN_P, 0);
            cValues.put(STATS_COLUMN_Q, 0);
            cValues.put(STATS_COLUMN_R, 0);
            cValues.put(STATS_COLUMN_S, 0);
            cValues.put(STATS_COLUMN_T, 0);
            cValues.put(STATS_COLUMN_U, 0);
            cValues.put(STATS_COLUMN_V, 0);
            cValues.put(STATS_COLUMN_W, 0);
            cValues.put(STATS_COLUMN_X, 0);;
            cValues.put(STATS_COLUMN_Y, 0);
            cValues.put(STATS_COLUMN_Z, 0);
            // Insert three times since we want to make ONLY three rows 1. Played 2. Traded 3. Drawn
            for(int i = 0; i < 3; i++) {
                long newRowId = db.insert(STATS_TABLE_NAME, null, cValues);
            }
            db.close();
        }
    }

    // Update Letter Stats Details
    public void UpdateLetterDetails(String letter, int amount, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + STATS_TABLE_NAME + " SET " + letter.toUpperCase() + " = " + letter.toUpperCase() + " + " + amount + " WHERE " + STATS_COLUMN_ID + " = " + id;
        //String query = "UPDATE " + STATS_TABLE_NAME + " SET " + letter.toUpperCase() + " = " + amount + " WHERE " + STATS_COLUMN_ID + " = " + id;
        System.out.println(query);
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        cursor.close();
    }

    // Get Letter Stats based on action id
    public ArrayList<HashMap<String, String>> GetLetterStaId(int actionid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> letterstaList = new ArrayList<>();
        String query = "SELECT id_letterStats, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z FROM "+ STATS_TABLE_NAME;
        Cursor cursor = db.query(STATS_TABLE_NAME, new String[]{ STATS_COLUMN_A, STATS_COLUMN_B, STATS_COLUMN_C, STATS_COLUMN_D, STATS_COLUMN_E, STATS_COLUMN_F, STATS_COLUMN_G, STATS_COLUMN_H, STATS_COLUMN_I, STATS_COLUMN_J, STATS_COLUMN_K, STATS_COLUMN_L, STATS_COLUMN_M, STATS_COLUMN_N, STATS_COLUMN_O, STATS_COLUMN_P, STATS_COLUMN_Q, STATS_COLUMN_R, STATS_COLUMN_S, STATS_COLUMN_T, STATS_COLUMN_U, STATS_COLUMN_V, STATS_COLUMN_W, STATS_COLUMN_X, STATS_COLUMN_Y, STATS_COLUMN_Z}, STATS_COLUMN_ID+ "=?",new String[]{String.valueOf(actionid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> lettersta = new HashMap<>();
            lettersta.put("A",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_A)));
            lettersta.put("B",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_B)));
            lettersta.put("C",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_C)));
            lettersta.put("D",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_D)));
            lettersta.put("E",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_E)));
            lettersta.put("F",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_F)));
            lettersta.put("G",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_G)));
            lettersta.put("H",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_H)));
            lettersta.put("I",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_I)));
            lettersta.put("J",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_J)));
            lettersta.put("K",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_K)));
            lettersta.put("L",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_L)));
            lettersta.put("M",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_M)));
            lettersta.put("N",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_N)));
            lettersta.put("O",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_O)));
            lettersta.put("P",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_P)));
            lettersta.put("Q",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_Q)));
            lettersta.put("R",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_R)));
            lettersta.put("S",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_S)));
            lettersta.put("T",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_T)));
            lettersta.put("U",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_U)));
            lettersta.put("V",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_V)));
            lettersta.put("W",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_W)));
            lettersta.put("X",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_X)));
            lettersta.put("Y",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_Y)));
            lettersta.put("Z",cursor.getString(cursor.getColumnIndex(STATS_COLUMN_Z)));
            letterstaList.add(lettersta);
        }
        cursor.close();
        return  letterstaList;
    }

    /*https://www.youtube.com/watch?v=kDZES1wtKUY*/
    public Cursor GetDataforLetter(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor allletterdata=db.rawQuery("select * from "+STATS_TABLE_NAME,null);
        return allletterdata;
    }
    public Cursor GetAllSettingData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor allsettingdata=db.rawQuery("select * from "+SETTINGS_TABLE_NAME,null);
        return allsettingdata;
    }
    public Cursor GetWordBank(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor allworddata=db.rawQuery("select * from "+WB_TABLE_NAME,null);
        return allworddata;
    }

    //  Pool Init
    public void poolInit(String letter, int count){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(POOL_COLUMN_LETTER, letter);
        cValues.put(POOL_COLUMN_COUNT, count);
        cValues.put(POOL_COLUMN_LETTERFINISHED, false);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(POOL_TABLE_NAME,null, cValues);
    }

    // Clear the old pool
    public void clearPool(){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Clear out the table
        db.execSQL("DROP TABLE " + POOL_TABLE_NAME);
        String CREATE_TABLE_POOL = "CREATE TABLE IF NOT EXISTS " + POOL_TABLE_NAME + "("
                + POOL_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + POOL_COLUMN_LETTER + " TEXT,"
                + POOL_COLUMN_COUNT + " INTEGER,"
                + POOL_COLUMN_LETTERFINISHED + " BOOLEAN" + ")";
        db.execSQL(CREATE_TABLE_POOL);
    }

    // Put a letter back to the pool
    public void putInPool(String letter){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + POOL_TABLE_NAME + " SET count = (count + 1)" + " WHERE " + POOL_COLUMN_LETTER + " = '" + letter.toUpperCase()+ "'";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        cursor.close();
    }

    // Decrease # the count for the Pool
    public void removeFromPool(String letter){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE " + POOL_TABLE_NAME + " SET count = (count - 1)" + " WHERE " + POOL_COLUMN_LETTER + " = '" + letter.toUpperCase()+ "'";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        String query2 = "SELECT " + POOL_COLUMN_COUNT + " FROM " + POOL_TABLE_NAME + " WHERE " + POOL_COLUMN_LETTER + " = '" + letter.toUpperCase()+ "'";
        Cursor mCount = db.rawQuery(query2, null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);

        //If the tiles for the letter have been used up
        if(count == 0){
            String query3 = "UPDATE " + POOL_TABLE_NAME + " SET " + POOL_COLUMN_LETTERFINISHED + " = 1 " + " WHERE " + POOL_COLUMN_LETTER + " = '" + letter.toUpperCase()+ "'";
            Cursor uCursor = db.rawQuery(query3,null);
            uCursor.moveToFirst();
            uCursor.close();
        }

        mCount.close();
        cursor.close();
    }

    // Give a pool letter. Please make sure the pool is not empty
    public String giveLetter(){
        SQLiteDatabase db = this.getReadableDatabase();
        Random rand = new Random();
        // Obtain a number between [0 - 25].
        int n = rand.nextInt(26) + 65;
        String randomLetter = Character.toString((char) n);
        if(!this.isEmpty()){
            while(this.isEmpty(randomLetter)){
                n = rand.nextInt(26) + 65;
                randomLetter = Character.toString((char) n);
            }
            this.removeFromPool(randomLetter);
            return randomLetter;
        }
        return null;
    }

    // Verify if a letter has no more tiles of that same letter
    public Boolean isEmpty(String letter){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select " + POOL_COLUMN_LETTERFINISHED + " FROM " + POOL_TABLE_NAME + " WHERE " + POOL_COLUMN_LETTER + " = '" + letter.toUpperCase() +"'";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        int empty = cursor.getInt(0);
        cursor.close();
        return empty == 1;
    }

    // Verify if pool is Empty
    public Boolean isEmpty(){
        SQLiteDatabase db = getReadableDatabase();
        try {
            String selectQuery =
                    "SELECT COUNT(*)" +
                            " FROM " + POOL_TABLE_NAME +
                            " WHERE " + POOL_COLUMN_LETTERFINISHED + " = 1";
            return (DatabaseUtils.longForQuery(db, selectQuery, null) == 26);
        } finally {
            db.close();
        }
    }
}

