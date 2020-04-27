/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/

package edu.gatech.seclass.words6300;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class SingleScoreViewActivity extends AppCompatActivity {
    private static final String TAG = "SingleScoreViewActivity";
    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<String> mLetterpoint=new ArrayList<>();
    private ArrayList<String> mLettercount=new ArrayList<>();
    private TextView score;
    private TextView turn;
    private HashMap<String, String> sta_settinginfo;


    DB_Manager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_score_view);
        db= new DB_Manager(this);
        int gameid=getIntent().getIntExtra("Gameid",0);
        if (gameid>0){
            ArrayList<HashMap<String, String>> settinginfo=db.GetSettings(gameid);
            sta_settinginfo=settinginfo.get(0);
            score=(TextView)findViewById(R.id.finalTotalScore);
            turn=(TextView)findViewById(R.id.score12);
            ArrayList<HashMap<String, String>> gameinfo=db.GetGameByGameId(gameid);
            HashMap<String, String> sta_gameinfo=gameinfo.get(0);
            score.setText(sta_gameinfo.get("score"));
            turn.setText(sta_settinginfo.get("maxTurns"));
            Log.d(TAG, "onCreate: started.");
            initlettermap();
        }



    }

    private void initlettermap() {


        Log.d(TAG, "lettermap: preparing bitmaps");
        String [] sletter= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String [] spoint= new String [26];
        String [] snumber=new String[26];
        ArrayList<String> allsetting=new ArrayList<>();
        allsetting.add(sta_settinginfo.get("A"));
        allsetting.add(sta_settinginfo.get("B"));
        allsetting.add(sta_settinginfo.get("C"));
        allsetting.add(sta_settinginfo.get("D"));
        allsetting.add(sta_settinginfo.get("E"));
        allsetting.add(sta_settinginfo.get("F"));
        allsetting.add(sta_settinginfo.get("G"));
        allsetting.add(sta_settinginfo.get("H"));
        allsetting.add(sta_settinginfo.get("I"));
        allsetting.add(sta_settinginfo.get("J"));
        allsetting.add(sta_settinginfo.get("K"));
        allsetting.add(sta_settinginfo.get("L"));
        allsetting.add(sta_settinginfo.get("M"));
        allsetting.add(sta_settinginfo.get("N"));
        allsetting.add(sta_settinginfo.get("O"));
        allsetting.add(sta_settinginfo.get("P"));
        allsetting.add(sta_settinginfo.get("Q"));
        allsetting.add(sta_settinginfo.get("R"));
        allsetting.add(sta_settinginfo.get("S"));
        allsetting.add(sta_settinginfo.get("T"));
        allsetting.add(sta_settinginfo.get("U"));
        allsetting.add(sta_settinginfo.get("V"));
        allsetting.add(sta_settinginfo.get("W"));
        allsetting.add(sta_settinginfo.get("X"));
        allsetting.add(sta_settinginfo.get("Y"));
        allsetting.add(sta_settinginfo.get("Z"));







        for (int i=0; i<26; i++){
            String [] sta_setting=allsetting.get(i).split(",");
            spoint[i]=sta_setting[1];
            snumber[i]=sta_setting[0];
            mNames.add(sletter[i]);
            mLettercount.add(snumber[i]);
            mLetterpoint.add(spoint[i]);

        }
        initRecyclerView();
        
            
        }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerview=findViewById(R.id.letterscoreview);
        RecyclerSingleLetterAdapter adapter = new RecyclerSingleLetterAdapter(mNames,mLettercount,mLetterpoint);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


    }


}
