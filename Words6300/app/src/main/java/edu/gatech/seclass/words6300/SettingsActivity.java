package edu.gatech.seclass.words6300;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.util.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SettingsActivity extends AppCompatActivity{

    private Spinner settingsSpinner;
    private EditText maxTurns, countText, pointsText;
    private String[] temp;
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

    private String selected;
    private Integer alphaPos;

    private Set[] hs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        maxTurns = (EditText) findViewById(R.id.maxTurnsSetting);
        countText = (EditText) findViewById(R.id.letterCountSetting);
        pointsText = (EditText) findViewById(R.id.letterPointsSetting);
        //Spinner
        settingsSpinner = (Spinner) findViewById(R.id.settingLetters);

        //Alphabet letters for the tiles
        final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alphabet);
        settingsSpinner.setAdapter(myAdapter);

        SharedPreferences preferences = getSharedPreferences("ScrabbleSettings", Context.MODE_PRIVATE);

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

        //To utilize in the spinner when a letter is changed
        hs = new Set[]{defaultSettingsA, defaultSettingsB, defaultSettingsC, defaultSettingsD, defaultSettingsE, defaultSettingsF, defaultSettingsG, defaultSettingsH, defaultSettingsI, defaultSettingsJ, defaultSettingsK, defaultSettingsL, defaultSettingsM, defaultSettingsN, defaultSettingsO, defaultSettingsP, defaultSettingsQ, defaultSettingsR, defaultSettingsS, defaultSettingsT, defaultSettingsU, defaultSettingsV, defaultSettingsW, defaultSettingsX, defaultSettingsY, defaultSettingsZ};

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

        //Set default preferences
        maxTurns.setText(preferences.getString("SettingTurns", "100"));
        temp = Arrays.copyOf(preferences.getStringSet("A", defaultSettingsA).toArray(), preferences.getStringSet("A", defaultSettingsA).toArray().length, String[].class);
        Arrays.sort(temp);
        countText.setText(temp[0].substring(1));
        pointsText.setText(temp[1].substring(1));

        //Performing action onItemSelected and onNothing selected
        settingsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                SharedPreferences preferences = getSharedPreferences("ScrabbleSettings", Context.MODE_PRIVATE);
                preferences.getString("firstSetting", "yes");
                if (preferences.getString("firstSetting", "yes") == "yes") {
                    preferences.edit().putString("firstSetting", "no").apply();
                } else {
                    //Update the countText and pointsText when the letter is changed
                    selected = (String) parent.getItemAtPosition(position);
                    alphaPos = (int) (selected.charAt(0));
                    temp = Arrays.copyOf(preferences.getStringSet(selected, preferences.getStringSet(selected, hs[alphaPos - 65])).toArray(), preferences.getStringSet(selected, preferences.getStringSet(selected, hs[alphaPos - 65])).toArray().length, String[].class);
                    Arrays.sort(temp);
                    countText.setText(temp[0].substring(1));
                    pointsText.setText(temp[1].substring(1));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing here for the moment...
            }
        });
    }

    public void saveSettings(View view){
        //When save button is clicked it will update the SharedPreferences with whatever was selected
        SharedPreferences preferences = getSharedPreferences("ScrabbleSettings", Context.MODE_PRIVATE);
        alphaPos = (int) (selected.charAt(0));

        int numTemp;
        Boolean invalid = false;

        //Verifies for invalid maxTurns
        try {
            if (maxTurns.getText().toString().matches("[0-9]+")) {
                numTemp = Integer.parseInt(maxTurns.getText().toString());
                if (numTemp > 0 && numTemp < 1001) {
                    preferences.edit().putString("SettingTurns", maxTurns.getText().toString()).apply();
                } else {
                    maxTurns.setError("Invalid Input");
                    invalid = true;
                }
            } else {
                maxTurns.setError("Invalid Input");
                invalid = true;
            }
        } catch(Exception ex){
            invalid = true;
            Log.e("IllegalArgument", "Turns value should be a number between 1 and 100, inclusive.");
        }

        //Verifies for invalid Count value
        try {
            if (!countText.getText().toString().matches("[0-9]+") || ((Integer.parseInt(countText.getText().toString()) < 1) || (Integer.parseInt(countText.getText().toString()) > 20))) {
                countText.setError("Invalid Input.");
                invalid = true;
            }
        } catch(Exception ex){
            invalid = true;
            Log.e("IllegalArgument", "Count value should be a number between 1 and 20, inclusive.");
        }

        //Verifies for invalid Points value
        try {
            if(!pointsText.getText().toString().matches("[0-9]+") || ((Integer.parseInt(pointsText.getText().toString()) < 0) || (Integer.parseInt(pointsText.getText().toString()) > 100))){
                pointsText.setError("Invalid Input.");
                invalid = true;
            }
        }  catch(Exception ex){
            Log.e("IllegalArgument", "Points value should be a number between 0 and 100, inclusive.");
            invalid = true;
        }

        //Save if not invalid, otherwise error message
        if (!invalid){
            //Find the letter or get the selected and save the newly entered values for letterCount and letterPoints
            preferences.edit().putStringSet(selected, new HashSet<String>(Arrays.asList("a" + countText.getText().toString(), "b" + pointsText.getText().toString()))).apply();
            Toast.makeText(getBaseContext(), "New settings have been saved. Saved settings will take place from next new game onwards!", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getBaseContext(), "Invalid input/s.", Toast.LENGTH_LONG).show();
        }
    }

    public void showInstructions(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        //builder.setMessage(R.string.instr_text);
        builder.setMessage("Default:\n" +
                "\t- 2 blank tiles (scoring 0 points)\n" +
                "\t- 1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4\n" +
                "\t- 2 points: D ×4, G ×3\n" +
                "\t- 3 points: B ×2, C ×2, M ×2, P ×2\n" +
                "\t- 4 points: F ×2, H ×2, V ×2, W ×2, Y ×2\n" +
                "\t- 5 points: K ×1\n" +
                "\t- 8 points: J ×1, X ×1\n" +
                "\t- 10 points: Q ×1, Z ×1\n\n" +
                "Requirements:\n" +
                "Max # of Turns: 0-1000\n" +
                "Count: 1-20\n" +
                "Points: 0-100");
        builder.setTitle(R.string.instr_title);
        builder.setPositiveButton(R.string.instr_positive,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //nothing to show
            }
        });
        builder.setNegativeButton(R.string.instr_negative,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //nothing to show
            }
        });

        builder.show();
    }
}
