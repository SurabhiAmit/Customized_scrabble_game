package edu.gatech.seclass.words6300;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScoreStatisticsActivity extends AppCompatActivity {
    private TextView turn1;
    private TextView turn2;
    private TextView turn3;
    private TextView turn4;
    private TextView turn5;
    private TextView turn6;
    private TextView turn7;
    private TextView turn8;
    private TextView turn9;

    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;
    private TextView score5;
    private TextView score6;
    private TextView score7;
    private TextView score8;
    private TextView score9;

    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;



    DB_Manager db;
    private int lastgameid;
    private String[] sta_score = new String[9];
    private String[] sta_turn = new String[9];
    private String[] sta_ave = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_score_statistics);
        db=new DB_Manager(this);
        try {
            lastgameid = db.LastGameID();
        }catch(Exception ex){
            //DB is empty
            lastgameid = 0;
        }

        for ( int i=0;i<9;i++){
            sta_score[i]=" ";
            sta_turn[i]=" ";
            sta_ave[i]=" ";
        }
        turn1=(TextView)findViewById(R.id.turn1);
        turn2=(TextView)findViewById(R.id.turn2);
        turn3=(TextView)findViewById(R.id.turn3);
        turn4=(TextView)findViewById(R.id.turn4);
        turn5=(TextView)findViewById(R.id.turn5);
        turn6=(TextView)findViewById(R.id.turn6);
        turn7=(TextView)findViewById(R.id.turn7);
        turn8=(TextView)findViewById(R.id.turn8);
        turn9=(TextView)findViewById(R.id.turn9);

        score1=(TextView)findViewById(R.id.score1);
        score2=(TextView)findViewById(R.id.score2);
        score3=(TextView)findViewById(R.id.score3);
        score4=(TextView)findViewById(R.id.score4);
        score5=(TextView)findViewById(R.id.score5);
        score6=(TextView)findViewById(R.id.score6);
        score7=(TextView)findViewById(R.id.score7);
        score8=(TextView)findViewById(R.id.score8);
        score9=(TextView)findViewById(R.id.score9);

        textView9=(TextView)findViewById(R.id.textView9);
        textView10=(TextView)findViewById(R.id.textView10);
        textView11=(TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);
        textView13=(TextView)findViewById(R.id.textView13);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView16=(TextView)findViewById(R.id.textView16);
        textView17=(TextView)findViewById(R.id.textView17);



        if (lastgameid>0){

            for (int i=0; i<lastgameid;i++){
                ArrayList<HashMap<String, String>> gameinfo=db.GetGameByGameId(lastgameid-i);
                HashMap<String, String> sta_gameinfo=gameinfo.get(0);
                int score=Integer.parseInt(sta_gameinfo.get("score"));
                int turn= Integer.parseInt(sta_gameinfo.get("turncount")) ;

                if(i>8){
                    break;
                }
                if (turn!=0){
                    int avescore=score/turn;
                    sta_ave[i]=Integer.toString(avescore);
                }

                sta_score[i]=Integer.toString(score);
                sta_turn[i]=Integer.toString(turn);
                gameinfo.clear();
            }
        }









        turn1.setText(sta_turn[0]);
        turn2.setText(sta_turn[1]);
        turn3.setText(sta_turn[2]);
        turn4.setText(sta_turn[3]);
        turn5.setText(sta_turn[4]);
        turn6.setText(sta_turn[5]);
        turn7.setText(sta_turn[6]);
        turn8.setText(sta_turn[7]);
        turn9.setText(sta_turn[8]);

        score1.setText(sta_ave[0]);
        score2.setText(sta_ave[1]);
        score3.setText(sta_ave[2]);
        score4.setText(sta_ave[3]);
        score5.setText(sta_ave[4]);
        score6.setText(sta_ave[5]);
        score7.setText(sta_ave[6]);
        score8.setText(sta_ave[7]);
        score9.setText(sta_ave[8]);

        textView9.setText(sta_score[0]);
        textView10.setText(sta_score[1]);
        textView11.setText(sta_score[2]);
        textView12.setText(sta_score[3]);
        textView13.setText(sta_score[4]);
        textView14.setText(sta_score[5]);
        textView15.setText(sta_score[6]);
        textView16.setText(sta_score[7]);
        textView17.setText(sta_score[8]);






    }



    public void gamesettingSta1(View view){

        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>0){
            gamesettingstaIntent.putExtra("Gameid",lastgameid);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }

        startActivity(gamesettingstaIntent);


    }
    public void gamesettingSta2(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>1){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-1);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);


    }
    public void gamesettingSta3(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>2){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-2);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta4(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>3){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-3);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta5(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>4){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-4);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta6(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>5){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-5);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta7(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>6){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-6);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta8(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>7){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-7);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }
    public void gamesettingSta9(View view){
        Intent gamesettingstaIntent = new Intent(this, SingleScoreViewActivity.class);
        if(lastgameid>8){
            gamesettingstaIntent.putExtra("Gameid",lastgameid-8);
        }else{
            gamesettingstaIntent.putExtra("Gameid",-1);
        }
        startActivity(gamesettingstaIntent);

    }

}
