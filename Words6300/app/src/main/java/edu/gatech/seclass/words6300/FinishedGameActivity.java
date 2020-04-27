package edu.gatech.seclass.words6300;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class FinishedGameActivity extends AppCompatActivity {

    private TextView finalScore, finalExtra, finalTotalScore, finishType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_game);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // TextViews
        finalScore = (TextView) findViewById(R.id.finalScore);
        finalExtra = (TextView) findViewById(R.id.finalExtra);
        finalTotalScore = (TextView) findViewById(R.id.finalTotalScore);
        finishType = (TextView) findViewById(R.id.finishType);

        // Pull info from DB
        DB_Manager db = new DB_Manager(this);
        ArrayList<HashMap<String, String>> gameInfo = db.GetGameByGameId(db.LastGameID());

        //Final Score
        int score = Integer.parseInt(gameInfo.get(0).get("score"));

        if(Integer.parseInt(gameInfo.get(0).get("add10")) == 1){
            finalScore.setText(Integer.toString(score-10));
            finalExtra.setText("10");
            finalTotalScore.setText(Integer.toString(score));
            finishType.setText("Pool is empty!");
        } else{
            finalScore.setText(Integer.toString(score));
            finalExtra.setText("0");
            finalTotalScore.setText(Integer.toString(score));
            finishType.setText("Maximum # of turns has been reached!");
        }
    }

    protected void onReturn(){
        // TextViews
        finalScore = (TextView) findViewById(R.id.finalScore);
        finalExtra = (TextView) findViewById(R.id.finalExtra);
        finalTotalScore = (TextView) findViewById(R.id.finalTotalScore);
        finishType = (TextView) findViewById(R.id.finishType);

        // Pull info from DB
        DB_Manager db = new DB_Manager(this);
        ArrayList<HashMap<String, String>> gameInfo = db.GetGameByGameId(db.LastGameID());

        //Final Score
        int score = Integer.parseInt(gameInfo.get(0).get("score"));

        if(Integer.parseInt(gameInfo.get(0).get("add10")) == 1){
            finalScore.setText(Integer.toString(score-10));
            finalExtra.setText("10");
            finalTotalScore.setText(Integer.toString(score));
            finishType.setText("Pool is empty!");
        } else{
            finalScore.setText(Integer.toString(score));
            finalExtra.setText("0");
            finalTotalScore.setText(Integer.toString(score));
            finishType.setText("Maximum # of turns has been reached!");
        }
    }

    public void showInstructions(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        //builder.setMessage(R.string.instr_text);
        builder.setMessage("For each turn, you can either form a word or swap letters back to the rack. When you form a word, one of the letters has to be present in the board. You'll receive points per each letter used in that word. In order to end the game, you should deplete the pool (and win extra ten points!) or reach the maximum number of turns.");
        builder.setTitle(R.string.instr_title);
        builder.setPositiveButton(R.string.instr_positive,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //no-op
            }
        });
        builder.setNegativeButton(R.string.instr_negative,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //no-op
            }
        });

        builder.show();
    }

    //Go back to main menu
    public void returnToMenu(View view){
        Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
    }
}
