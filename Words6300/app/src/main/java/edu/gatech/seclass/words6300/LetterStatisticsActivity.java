/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/
/*https://www.callicoder.com/java-priority-queue/*/
package edu.gatech.seclass.words6300;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LetterStatisticsActivity extends AppCompatActivity {
    private static final String TAG = "LetterStatisticsActivit";
    private ArrayList<String> nsta_letterfixed=new ArrayList<>();
    private ArrayList<String> nsta_letterplayed=new ArrayList<>();
    private ArrayList<String> nsta_lettertraded=new ArrayList<>();
    private ArrayList<String> nsta_letterpercent=new ArrayList<>();
    DB_Manager db;
    int lastgameid;
    HashMap<String, String> LetterStaplayed;
    HashMap<String, String> LetterStatraded;
    HashMap<String, String> LetterStadrawned;
    HashMap<String,String> Letterpercent;
    HashMap<String,String> Lettersorted;
    PriorityQueue<SortHashMap> sortmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db=new DB_Manager(this);
        try {
            lastgameid = db.LastGameID();
        }catch(Exception ex){
            //DB is empty
            lastgameid = 0;
        }
        if (lastgameid>0){
            ArrayList<HashMap<String, String>> GetLetterStaplayed=db.GetLetterStaId(1);
            ArrayList<HashMap<String, String>> GetLetterStatraded=db.GetLetterStaId(2);
            ArrayList<HashMap<String, String>> GetLetterStadrawned=db.GetLetterStaId(3);
            LetterStaplayed = GetLetterStaplayed.get(0);
            LetterStatraded = GetLetterStatraded.get(0);
            LetterStadrawned = GetLetterStadrawned.get(0);
            Letterpercent=new HashMap<String,String>();
            int played= 0;
            int drawn=1;
            sortmap=new PriorityQueue<>();
            for (HashMap.Entry<String, String> entry : LetterStaplayed.entrySet()) {
                played=Integer.parseInt(LetterStaplayed.get(entry.getKey()));
                drawn=Integer.parseInt(LetterStadrawned.get(entry.getKey()));
                if (drawn>0){
                    int calc=100*played/drawn;
                    Letterpercent.put(entry.getKey(), Integer.toString(calc));
                }else{
                    Letterpercent.put(entry.getKey(), "0");
                }


                sortmap.add(new SortHashMap(entry.getKey(),played));
            }





        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_statistics);
        Log.d(TAG, "onCreate: started.");
        initlettermap();
    }
    private void initlettermap() {
        Log.d(TAG, "lettermap: preparing bitmaps");
        String [] sletter= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String [] splayed= new String [26];
        String [] strade=new String[26];
        String [] spercent=new String[26];
        if (lastgameid>0){
            while (!sortmap.isEmpty()){
                SortHashMap map2=sortmap.poll();
                String key=map2.getKey();
                String value=map2.mapvalue();
                nsta_letterfixed.add(key);
                nsta_letterplayed.add(LetterStaplayed.get(key));
                nsta_lettertraded.add(LetterStatraded.get(key));
                nsta_letterpercent.add(Letterpercent.get(key)+"%");


            }

        }else{
            for (int i=0; i<26; i++){
                splayed[i]=" ";
                strade[i]=" ";
                spercent[i]=" ";
                nsta_letterfixed.add(sletter[i]);
                nsta_letterplayed.add(splayed[i]);
                nsta_lettertraded.add(strade[i]);
                nsta_letterpercent.add(spercent[i]);
            }

        }



        initRecyclerView();


    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerview=findViewById(R.id.letterstaview);
        RecyclerLetterSta adapter = new RecyclerLetterSta(nsta_letterfixed,nsta_letterplayed,nsta_lettertraded,nsta_letterpercent);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


    }



}
