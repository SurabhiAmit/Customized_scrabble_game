/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/
/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/

package edu.gatech.seclass.words6300;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.database.Cursor;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;


import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class WordBankActivity extends AppCompatActivity {
    private static final String TAG = "WordBankActivity";
    private ArrayList<String> nword=new ArrayList<>();
    private ArrayList<String> nusedtime=new ArrayList<>();
    private int lastgameid;
    DB_Manager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db=new DB_Manager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_bank);
        Log.d(TAG, "onCreate: started.");
        initmap();

    }
    private void initmap(){
        Log.d(TAG, "initmap: preparing bitmaps.");
        ArrayList<String> buffer=new  ArrayList();
        ArrayList<String> reverse=new ArrayList();
        ArrayList<String> sword=new ArrayList<String>();
        ArrayList<String> susedtime=new ArrayList<String>();
        try {
            lastgameid = db.LastGameID();
        }catch(Exception ex){
            //DB is empty
            lastgameid = 0;
        }
        if (lastgameid>0){
            Cursor res=db.GetWordBank();
            while (res.moveToNext()){
                buffer.add(res.getString(0));
            }
            for (int i=buffer.size()-1; i>=0; i--){
                reverse.add(buffer.get(i));
            }


            HashMap<String,Integer> map=new HashMap<>();
            int length=buffer.size();
            for (int i=0; i<length; i++){
                if (map.containsKey(reverse.get(i))){
                    int count=map.get(reverse.get(i));
                    map.put(reverse.get(i),count+1);
                }else{
                    map.put(reverse.get(i),1);
                    nword.add(reverse.get(i));

                }

            }
            int size=map.size();

            for (int i=0; i<size;i++) {
                String word=nword.get(i);
                nusedtime.add(Integer.toString(map.get(word)));
            }

           /* sort

            PriorityQueue<SortHashMap> sortmap=new PriorityQueue<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key=entry.getKey();
                int value=entry.getValue();
                sortmap.add(new SortHashMap(key,value));
            }
            //
            while (!sortmap.isEmpty()){
                SortHashMap map2=sortmap.poll();
                nword.add(map2.getKey());
                nusedtime.add(map2.mapvalue());

            }
            */




        }


        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.wordbankstaview);
        RecycleWordAdapter adapter = new RecycleWordAdapter(nword,nusedtime);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }










}
