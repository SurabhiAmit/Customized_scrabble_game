package edu.gatech.seclass.words6300;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MenuActivity extends AppCompatActivity {

    final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] temp;
    private String[] letterValues = new String[26];

    private Set<String> defaultSettingsA;
    private Set<String> defaultSettingsB;
    private Set<String> defaultSettingsC;
    private Set<String> defaultSettingsD;
    private Set<String> defaultSettingsE;
    private Set<String> defaultSettingsF;
    private Set<String> defaultSettingsG;
    private Set<String> defaultSettingsH;
    private Set<String> defaultSettingsI;
    private Set<String> defaultSettingsJ;
    private Set<String> defaultSettingsK;
    private Set<String> defaultSettingsL;
    private Set<String> defaultSettingsM;
    private Set<String> defaultSettingsN;
    private Set<String> defaultSettingsO;
    private Set<String> defaultSettingsP;
    private Set<String> defaultSettingsQ;
    private Set<String> defaultSettingsR;
    private Set<String> defaultSettingsS;
    private Set<String> defaultSettingsT;
    private Set<String> defaultSettingsU;
    private Set<String> defaultSettingsV;
    private Set<String> defaultSettingsW;
    private Set<String> defaultSettingsX;
    private Set<String> defaultSettingsY;
    private Set<String> defaultSettingsZ;

    private Set[] hs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences preferences = getSharedPreferences("ScrabbleSettings", Context.MODE_PRIVATE);

        preferences.getString("SettingTurns", "100");

        defaultSettingsA = new HashSet<String>(Arrays.asList("a9", "b1"));
        defaultSettingsB = new HashSet<String>(Arrays.asList("a2", "b3"));
        defaultSettingsC = new HashSet<String>(Arrays.asList("a2", "b3"));
        defaultSettingsD = new HashSet<String>(Arrays.asList("a4", "b2"));
        defaultSettingsE = new HashSet<String>(Arrays.asList("a12", "b1"));
        defaultSettingsF = new HashSet<String>(Arrays.asList("a2", "b4"));
        defaultSettingsG = new HashSet<String>(Arrays.asList("a3", "b2"));
        defaultSettingsH = new HashSet<String>(Arrays.asList("a2", "b4"));
        defaultSettingsI = new HashSet<String>(Arrays.asList("a9", "b1"));
        defaultSettingsJ = new HashSet<String>(Arrays.asList("a1", "b8"));
        defaultSettingsK = new HashSet<String>(Arrays.asList("a1", "b5"));
        defaultSettingsL = new HashSet<String>(Arrays.asList("a4", "b1"));
        defaultSettingsM = new HashSet<String>(Arrays.asList("a2", "b3"));
        defaultSettingsN = new HashSet<String>(Arrays.asList("a6", "b1"));
        defaultSettingsO = new HashSet<String>(Arrays.asList("a8", "b1"));
        defaultSettingsP = new HashSet<String>(Arrays.asList("a2", "b3"));
        defaultSettingsQ = new HashSet<String>(Arrays.asList("a1", "b10"));
        defaultSettingsR = new HashSet<String>(Arrays.asList("a6", "b1"));
        defaultSettingsS = new HashSet<String>(Arrays.asList("a4", "b1"));
        defaultSettingsT = new HashSet<String>(Arrays.asList("a6", "b1"));
        defaultSettingsU = new HashSet<String>(Arrays.asList("a4", "b1"));
        defaultSettingsV = new HashSet<String>(Arrays.asList("a2", "b4"));
        defaultSettingsW = new HashSet<String>(Arrays.asList("a2", "b4"));
        defaultSettingsX = new HashSet<String>(Arrays.asList("a1", "b8"));
        defaultSettingsY = new HashSet<String>(Arrays.asList("a2", "b4"));
        defaultSettingsZ = new HashSet<String>(Arrays.asList("a1", "b10"));

        hs = new Set[]{defaultSettingsA, defaultSettingsB, defaultSettingsC, defaultSettingsD, defaultSettingsE, defaultSettingsF, defaultSettingsG, defaultSettingsH, defaultSettingsI, defaultSettingsJ, defaultSettingsK, defaultSettingsL, defaultSettingsM, defaultSettingsN, defaultSettingsO, defaultSettingsP, defaultSettingsQ, defaultSettingsR, defaultSettingsS, defaultSettingsT, defaultSettingsU, defaultSettingsV, defaultSettingsW, defaultSettingsX, defaultSettingsY, defaultSettingsZ};

        preferences.getStringSet("A", defaultSettingsB);
        preferences.getStringSet("B", defaultSettingsB);
        preferences.getStringSet("C", defaultSettingsB);
        preferences.getStringSet("D", defaultSettingsB);
        preferences.getStringSet("E", defaultSettingsB);
        preferences.getStringSet("F", defaultSettingsB);
        preferences.getStringSet("G", defaultSettingsB);
        preferences.getStringSet("H", defaultSettingsB);
        preferences.getStringSet("I", defaultSettingsB);
        preferences.getStringSet("J", defaultSettingsB);
        preferences.getStringSet("K", defaultSettingsB);
        preferences.getStringSet("L", defaultSettingsB);
        preferences.getStringSet("M", defaultSettingsB);
        preferences.getStringSet("N", defaultSettingsB);
        preferences.getStringSet("O", defaultSettingsB);
        preferences.getStringSet("P", defaultSettingsB);
        preferences.getStringSet("Q", defaultSettingsB);
        preferences.getStringSet("R", defaultSettingsB);
        preferences.getStringSet("S", defaultSettingsB);
        preferences.getStringSet("T", defaultSettingsB);
        preferences.getStringSet("U", defaultSettingsB);
        preferences.getStringSet("V", defaultSettingsB);
        preferences.getStringSet("W", defaultSettingsB);
        preferences.getStringSet("X", defaultSettingsB);
        preferences.getStringSet("Y", defaultSettingsB);
        preferences.getStringSet("Z", defaultSettingsB);
    }

    public void gameSettings(View view){
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public void playGame(View view){
        ArrayList<HashMap<String, String>> gameInfo;
        DB_Manager db = new DB_Manager(this);
        boolean returnGame = false;
        int id;
        Intent startGameIntent = new Intent(this, GameActivity.class);
        Intent returnIntent = new Intent(this, ReturnActivity.class);

        try {
            id = db.LastGameID();
        }catch(Exception ex){
            //DB is empty
            id = 0;
        }

        //Step1: Check if a game is still open
        //If yes, send to return to game view
        //If ID is not 0 which could mean there is no game or the last ID was deleted
        if (id == 0) {
            returnGame = false;
        } else {
            gameInfo = db.GetGameByGameId((int) db.LastGameID());
            if(Integer.parseInt(gameInfo.get(0).get("ended")) == 0){
                returnGame = true;
            }
        }

        if(!returnGame){
            SharedPreferences preferences = getSharedPreferences("ScrabbleSettings", Context.MODE_PRIVATE);

            //Save User Details
            db.insertGameDetails(0, false, 0, false);

            //Erase last Pool
            db.clearPool();

            //Retrieve last Settings
            for(int i = 0; i < 26; i++){
                String letter = alphabet[i];
                temp = Arrays.copyOf(preferences.getStringSet(letter, preferences.getStringSet(letter, hs[i])).toArray(), preferences.getStringSet(letter, preferences.getStringSet(letter, hs[i])).toArray().length, String[].class);
                Arrays.sort(temp);
                String str = temp[0].substring(1) + ", " + temp[1].substring(1);
                letterValues[i] = str;

                //Fill up pool
                db.poolInit(alphabet[i], Integer.parseInt(temp[0].substring(1)));
            }

            //Save Setting Details
            db.insertSettingsDetails(Integer.parseInt(preferences.getString("SettingTurns", "100")), letterValues[0], letterValues[1], letterValues[2], letterValues[3], letterValues[4], letterValues[5], letterValues[6], letterValues[7], letterValues[8], letterValues[9], letterValues[10], letterValues[11], letterValues[12], letterValues[13], letterValues[14], letterValues[15], letterValues[16], letterValues[17], letterValues[18], letterValues[19], letterValues[20], letterValues[21], letterValues[22], letterValues[23], letterValues[24], letterValues[25]);
            //Navigate to Play Game
            startActivity(startGameIntent);
        } else{ //Step 2 Send user to ReturnActivity
            startActivity(returnIntent);
        }
    }

    public void gameStats(View view){
        Intent statsIntent = new Intent(this, StatisticsViewActivity.class);
        startActivity(statsIntent);
    }
}
