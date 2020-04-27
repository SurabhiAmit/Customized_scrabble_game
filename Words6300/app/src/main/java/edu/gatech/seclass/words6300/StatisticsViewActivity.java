package edu.gatech.seclass.words6300;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class StatisticsViewActivity extends AppCompatActivity {
    private TextView bestscore;
    int lastgameid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_view);
        bestscore=(TextView)findViewById(R.id.BestScore);
        DB_Manager db=new DB_Manager(this);



        try {
            lastgameid = db.LastGameID();
        }catch(Exception ex){
            //DB is empty
            lastgameid = 0;
        }
        if(lastgameid>0){
            int [] allscore=new int[lastgameid];
            for (int i=0; i<lastgameid;i++) {
                ArrayList<HashMap<String, String>> gameinfo = db.GetGameByGameId(i+1);
                HashMap<String, String> sta_gameinfo = gameinfo.get(0);
                int score = Integer.parseInt(sta_gameinfo.get("score"));
                allscore[i]=score;
                gameinfo.clear();
            }
            int highscore=allscore[0];
            for (int i=1; i<lastgameid;i++){
                if (allscore[i]>highscore){
                    highscore=allscore[i];
                }

            }
            bestscore.setText(Integer.toString(highscore));
        }



    }
    public void ScoreSta(View view){

        Intent scorestaIntent = new Intent(this, GameScoreStatisticsActivity.class);

        startActivity(scorestaIntent);
    }
    public void LetterSta(View view){
        Intent letterstaIntent = new Intent(this, LetterStatisticsActivity.class);
        startActivity(letterstaIntent);
    }
    public void WordBankSta(View view){
        Intent wordbankstaIntent = new Intent(this, WordBankActivity.class);
        startActivity(wordbankstaIntent);
    }
}
