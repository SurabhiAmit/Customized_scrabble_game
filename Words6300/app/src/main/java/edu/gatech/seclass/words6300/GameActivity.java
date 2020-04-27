package edu.gatech.seclass.words6300;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class GameActivity extends AppCompatActivity {
    WordGameUiController uiC = new WordGameUiController();
    Button btnSubmitWord;
    Button btnSwapWord;
    TextView turn, gameScore;
    TextView boardLetter1,boardLetter2,boardLetter3,boardLetter4;
    TextView txtRack1,txtRack2,txtRack3,txtRack4,txtRack5,txtRack6,txtRack7;
    EditText answerWord;
    ImageView deleteView;
    DB_Manager db = new DB_Manager(this);
    Integer gameID, maxTurns, letterScore, wordScore, turnInt, gameScoreInt;
    ArrayList<HashMap<String, String>> settingsList = new ArrayList<>();
    ArrayList<HashMap<String, String>> gameList = new ArrayList<>();
    ArrayList<HashMap<String, String>> boardRack = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        startWordGame();
    }

    private void initGame()
    {
        try {
            if( getIntent().getExtras().getString(ReturnActivity.CONTINUE).equals(ReturnActivity.CONTINUE_NO) ) {
                uiC.initGame(db);
            }


            db.prepareLetterStats();
            gameID = (int)db.LastGameID();
            settingsList = db.GetSettings(gameID);
            System.out.println("Value for Game ID is: " + gameID);
            gameList = db.GetGameByGameId(gameID);
            boardRack = db.getBoardRack(gameID);
            turn.setText(String.valueOf(gameList.get(0).get("turncount")));
            gameScore.setText(String.valueOf(gameList.get(0).get("score")));
            gameScoreInt = Integer.parseInt(String.valueOf(gameScore.getText()));
            maxTurns = Integer.parseInt(settingsList.get(0).get("maxTurns"));
            System.out.println("Value for MaxTurns is: " + maxTurns);

            String boardSet = boardRack.get(0).get("board");
            String rackSet =  boardRack.get(0).get("rack");
            System.out.println("BOARDSET IS: ");
            System.out.println(boardSet);
            System.out.println("RACKSET IS: ");
            System.out.println(rackSet);
            String a ="";
            String b="";
            String c="";
            String d="";

            if (boardSet!= null) {
                //System.out.println("BOARSDET IS NOT NULL");

                a = Character.toString(boardSet.charAt(0));
                b = Character.toString(boardSet.charAt(1));
                c = Character.toString(boardSet.charAt(2));
                d = Character.toString(boardSet.charAt(3));
                uiC.getCurrBoard().addLetters(new Letter(a.charAt(0), Letter.BELONGS_TO.BOARD));
                uiC.getCurrBoard().addLetters(new Letter(b.charAt(0), Letter.BELONGS_TO.BOARD));
                uiC.getCurrBoard().addLetters(new Letter(c.charAt(0), Letter.BELONGS_TO.BOARD));
                uiC.getCurrBoard().addLetters(new Letter(d.charAt(0), Letter.BELONGS_TO.BOARD));

            }
            else

            {
                //System.out.println("BOARSDET IS NULL");
                a = uiC.getCurrBoard().getBoardLetters().get(0).toString();
                b = uiC.getCurrBoard().getBoardLetters().get(1).toString();
                c = uiC.getCurrBoard().getBoardLetters().get(2).toString();
                d = uiC.getCurrBoard().getBoardLetters().get(3).toString();
                db.UpdateLetterDetails(a,1,3);
                db.UpdateLetterDetails(b,1,3);
                db.UpdateLetterDetails(c,1,3);
                db.UpdateLetterDetails(d,1,3);

            }

            boardLetter1.setText( a );
            boardLetter2.setText( b );
            boardLetter3.setText( c );
            boardLetter4.setText( d );

            String e = "";
            String f = "";
            String g = "";
            String h = "";
            String i = "";
            String j = "";
            String k = "";

            if (rackSet != null) {

                e = Character.toString(rackSet.charAt(0));
                f = Character.toString(rackSet.charAt(1));
                g = Character.toString(rackSet.charAt(2));
                h = Character.toString(rackSet.charAt(3));
                i = Character.toString(rackSet.charAt(4));
                j = Character.toString(rackSet.charAt(5));
                k = Character.toString(rackSet.charAt(6));
                uiC.getRack().addLetter(new Letter(e.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(f.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(g.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(h.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(i.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(j.charAt(0), Letter.BELONGS_TO.RACK));
                uiC.getRack().addLetter(new Letter(k.charAt(0), Letter.BELONGS_TO.RACK));
            }
            else {
                e = uiC.getRack().getRackLetter().get(0).toString();
                f = uiC.getRack().getRackLetter().get(1).toString();
                g = uiC.getRack().getRackLetter().get(2).toString();
                h = uiC.getRack().getRackLetter().get(3).toString();
                i = uiC.getRack().getRackLetter().get(4).toString();
                j = uiC.getRack().getRackLetter().get(5).toString();
                k = uiC.getRack().getRackLetter().get(6).toString();
                db.UpdateLetterDetails(e ,1,3);
                db.UpdateLetterDetails(f ,1,3);
                db.UpdateLetterDetails(g ,1,3);
                db.UpdateLetterDetails(h ,1,3);
                db.UpdateLetterDetails(i ,1,3);
                db.UpdateLetterDetails(j ,1,3);
                db.UpdateLetterDetails(k ,1,3);
            }

            txtRack1.setText( e );
            txtRack2.setText( f );
            txtRack3.setText( g );
            txtRack4.setText( h );
            txtRack5.setText( i );
            txtRack6.setText( j );
            txtRack7.setText( k );

        }

        catch(GameException e)
        {
            showErrorMsg(e.msg);
        }
    }


    private void showErrorMsg( String errorMessage )
    {
        Toast errorToast = Toast.makeText(GameActivity.this, errorMessage, Toast.LENGTH_SHORT);
        errorToast.show();
    }


    private void initComponents()
    {
        btnSubmitWord =  findViewById(R.id.btnSubmitWord);
        btnSwapWord = findViewById(R.id.btnSwap);
        //maxTurns = findViewById(R.id.maxTurnsSetting);
        boardLetter1 = findViewById(R.id.boardLetter1);
        boardLetter2 = findViewById(R.id.boardLetter2);
        boardLetter3 = findViewById(R.id.boardLetter3);
        boardLetter4 = findViewById(R.id.boardLetter4);
        turn = findViewById(R.id.lblTurn);
        gameScore = findViewById(R.id.lblScore);

        txtRack1 = findViewById(R.id.txtRack1);
        txtRack2 = findViewById(R.id.txtRack2);
        txtRack3 = findViewById(R.id.txtRack3);
        txtRack4 = findViewById(R.id.txtRack4);
        txtRack5 = findViewById(R.id.txtRack5);
        txtRack6 = findViewById(R.id.txtRack6);
        txtRack7 = findViewById(R.id.txtRack7);

        deleteView = findViewById(R.id.imageView4);

        answerWord=findViewById(R.id.editText2);

        //answerWord.setEnabled(false);

        deleteView.setOnClickListener(new View.OnClickListener() {
            private void resetBoardLetter( TextView view, Letter ltr, boolean isRack )
            {
                if( !view.isEnabled() && view.getText().equals( ltr.getSymbol() + "" ) )
                {
                    view.setEnabled(true);
                    view.setTextColor( Color.BLACK );
                    try {
                        if( !isRack ) uiC.getCurrBoard().addLetters( ltr );
                        else uiC.getRack().addLetter( ltr );
                    } catch (GameException e) {
                        showErrorMsg(e.msg);
                    }
                }

            }

            @Override
            public void onClick(View view) {
                try {
                    Letter ltr = uiC.getWord().removeLetter();
                    if(ltr.getBelongsTo()== Letter.BELONGS_TO.BOARD)
                    {
                        resetBoardLetter( boardLetter1, ltr, false );
                        resetBoardLetter( boardLetter2, ltr, false );
                        resetBoardLetter( boardLetter3, ltr, false );
                        resetBoardLetter( boardLetter4, ltr, false );
                    }
                    else
                    {
                        resetBoardLetter( txtRack1, ltr, true );
                        resetBoardLetter( txtRack2, ltr, true );
                        resetBoardLetter( txtRack3, ltr , true);
                        resetBoardLetter( txtRack4, ltr , true);
                        resetBoardLetter( txtRack5, ltr , true);
                        resetBoardLetter( txtRack6, ltr , true);
                        resetBoardLetter( txtRack7, ltr , true);
                    }

                    answerWord.setText( uiC.getWord().toString() );
                }catch(GameException e)
                {
                    showErrorMsg(e.msg);
                }
            }
        });

        //all eventing goes below
        btnSubmitWord.setOnClickListener(new View.OnClickListener() {
            //After word submit, refill the board and rack with pool letters
            private void reInitLetter( TextView view, boolean rack )
            {

                if( view.isEnabled() )
                {
                    return; //do nothing keep the word
                }

                view.setEnabled(true);
                view.setTextColor(Color.BLACK);
                try{
                    Letter ltr = new Letter ( rack ? db.giveLetter().charAt(0) : getNextAvailableRack(),
                                                rack ? Letter.BELONGS_TO.RACK: Letter.BELONGS_TO.BOARD);
                    //Letter ltr = new Letter (db.giveLetter().charAt(0), Letter.BELONGS_TO.RACK);
                    view.setText("" + ltr.getSymbol());
                    String lt = String.valueOf(ltr);

                    if( rack )
                    {
                        uiC.getRack().addLetter(ltr);
                        db.UpdateLetterDetails(lt,1,3);
                    }
                    else
                    {
                       /* String wordUsed = String.valueOf(uiC.getWord());
                        System.out.println("Word formed:" + wordUsed );
                        String boardLetterUsed = String.valueOf(uiC.getWord().boardLetter);
                        System.out.println("Board letter:" + boardLetterUsed );
                        String wordNew = wordUsed.replaceFirst(boardLetterUsed, "");
                        System.out.println("Word without board letter is: ");
                        System.out.println(wordNew);
                        Random random = new Random();
                        int index = random.nextInt(wordNew.length());
                        Letter ltr1 = new Letter(wordNew.charAt(index), Letter.BELONGS_TO.BOARD);
                        System.out.println("Next turn's board letter is : ");
                        System.out.println(ltr1);
                        view.setText("" + ltr1.getSymbol());*/
                        uiC.getCurrBoard().addLetters(ltr);
                    }
                }catch(GameException e)

                {   turnInt = Integer.parseInt(turn.getText().toString());
                    db.UpdateGameDetails(gameScoreInt+10, true,turnInt, true, gameID);
                    showErrorMsg(e.msg);    //POOL: Empty
                    view.setText("");
                    view.setEnabled(false);
                }

            }




            public void setGameScore(TextView gs, Integer addScore){
                try{

                    String presentScore = gs.getText().toString();
                    int presentIntScore = Integer.parseInt(presentScore);
                    presentIntScore+=addScore;
                    gs.setText(""+presentIntScore);

                }
                catch(Exception e)
                {

                    showErrorMsg("The score addition cannot be performed!");


                }
            }

            private Character getNextAvailableRack()
            {
                if( !txtRack1.isEnabled() )
                {
                    return txtRack1.getText().charAt(0);
                }
                else if( !txtRack2.isEnabled() )
                {
                    return txtRack2.getText().charAt(0);
                }
                else if( !txtRack3.isEnabled() )
                {
                    return txtRack3.getText().charAt(0);
                }
                else if( !txtRack4.isEnabled() )
                {
                    return txtRack4.getText().charAt(0);
                }
                else if( !txtRack5.isEnabled() )
                {
                    return txtRack5.getText().charAt(0);
                }
                else if( !txtRack6.isEnabled() )
                {
                    return txtRack6.getText().charAt(0);
                }
                else if( !txtRack7.isEnabled() )
                {
                    return txtRack7.getText().charAt(0);
                }
                return null;
            }

            @Override
            public void onClick(View view) {

                try {
                    uiC.getWord().checkWord();
                }
                catch(GameException e)
                {
                    showErrorMsg(e.msg);
                    return;
                }
                // * checkIfWordused(String word, int lastgameID) : Boolean
                //if( uiC.getWordBank().isInBank( uiC.getWord().toString() ) )
                if(db.checkIfUsed(gameID,uiC.getWord().toString() ))
                {
                    showErrorMsg("This word was already used in this game");
                    return;
                }

                else
                    {
                    wordScore=0;
                    String word_formed = String.valueOf(uiC.getWord());
                    db.insertWBDetails(db.LastGameID(), word_formed);
                    //Test to check if wordbank is updated
                    //Integer count =db.GetWordCount(word_formed);
                    //System.out.println("Get word count");
                    //System.out.println(count);
                    System.out.println(word_formed);
                    for (int i = 0; i < word_formed.length(); i++){
                        char c = Character.toUpperCase(word_formed.charAt(i));
                        String s =  Character.toString(c);
                        System.out.println("The points for letters: ");
                        System.out.println(s);
                        System.out.println("Getting the letter statistics : ");
                        System.out.println(db.GetLetterStaId(1).get(0).get(s));
                        db.UpdateLetterDetails(s,1,1);
                        //System.out.println(db.GetLetterStaId(1).get(0).get(s));
                        letterScore = Integer.parseInt(settingsList.get(0).get(s).split(",")[1].trim());
                        System.out.println( letterScore);
                        wordScore += letterScore;
                    }
                    System.out.println("WORDSCORE IS");
                    System.out.println(  wordScore);
                    setGameScore(gameScore, wordScore);
                    gameScoreInt = Integer.parseInt(gameScore.getText().toString());






                //pool initialize
                //testing purpose
                //uiC.getPool().refillPool();
                //board initialize
                reInitLetter( boardLetter1, false );
                reInitLetter( boardLetter2, false );
                reInitLetter( boardLetter3, false );
                reInitLetter( boardLetter4, false );

                //rack initialize
                reInitLetter( txtRack1, true );
                reInitLetter( txtRack2, true );
                reInitLetter( txtRack3, true );
                reInitLetter( txtRack4, true );
                reInitLetter( txtRack5, true );
                reInitLetter( txtRack6, true );
                reInitLetter( txtRack7, true );

                uiC.getWord().reset();    //reset the word object

                uiC.getWordBank().addToBank( uiC.getWord().toString() );

                answerWord.setText("");

                        //incTurn(turn);
                        try
                        {
                            String presentValStr = turn.getText().toString();
                            int presentIntVal = Integer.parseInt(presentValStr);
                            presentIntVal++;
                            //tv.setText(""+presentIntVal);

                            //String presentMaxStr=maxTurns.getText().toString();
                            //int presentMaxVal=Integer.parseInt(presentMaxStr);
                            //Since the DB layer is WIP, 20 is kept as the default maxTurns
                            int presentMaxVal = maxTurns;
                            //turnInt = Integer.parseInt(turn.getText().toString());
                            if (presentIntVal < presentMaxVal) {
                                turn.setText(""+presentIntVal);
                                db.UpdateGameDetails(gameScoreInt, false,presentIntVal, false, gameID);
                            }
                            else {
                                db.UpdateGameDetails(gameScoreInt, false,presentIntVal, true, gameID);
                                showErrorMsg("The turn count has reached maximum number of turns set for this game.");
                                Intent i = new Intent(getApplicationContext(),FinishedGameActivity.class);
                                startActivity(i);
                            }

                        }
                        catch(Exception e)
                        {
                            //e.printStackTrace();
                            showErrorMsg("The turn count cannot be updated.");
                            //Log.e("MYAPP", "exception", e);

                        }

                        List<Letter> board= uiC.getCurrBoard().boardLetters;
                        String boardString ="";
                        for (int i=0;i<board.size(); i++){
                            boardString+=board.get(i).toString();
                        }

                        System.out.println("The board string is:");
                        System.out.println(boardString);
                        List<Letter> rack= uiC.getRack().rackLetter;
                        String rackString="";
                        for (int i=0;i<rack.size(); i++){
                            rackString+=rack.get(i).toString();
                        }
                        System.out.println("The rack string is:");
                        System.out.println(rackString);
                        db.updateBoardRack(gameID, boardString, rackString );

                    }

            }
        });

        btnSwapWord.setOnClickListener(new View.OnClickListener() {
            // Swap- pool empty!
            void resetLetter( TextView view )
            {
                if( !view.isEnabled() )
                {
                    view.setEnabled(true);
                    view.setTextColor(Color.BLACK);
                    try {
                        Letter ltr = new Letter(db.giveLetter().charAt(0), Letter.BELONGS_TO.RACK);
                        view.setText(""+ ltr.getSymbol());
                        uiC.getRack().addLetter( ltr );
                        String l = String.valueOf(ltr);
                        db.UpdateLetterDetails(l,1,3);
                    } catch (GameException e) {
                        turnInt = Integer.parseInt(turn.getText().toString());
                        db.UpdateGameDetails(gameScoreInt+10, true,turnInt, true, gameID);
                        showErrorMsg(e.msg);        //POOL: Empty
                        view.setText("");
                        view.setEnabled(false);
                    }
                }
            }

            @Override

            public void onClick(View view) {


                if( uiC.getWord().hasBoardLetter() )
                {
                    showErrorMsg("Cannot swap board letters");
                    return;
                }

                if( uiC.getWord().wordLength() == 0 )
                {
                    showErrorMsg("Letters should be selected from Rack that needs to be swapped");
                    return;
                }

                else
                {
                    try {
                        while (uiC.getWord().wordLength() != 0) {
                            Letter sendBackToPool = uiC.getWord().removeLetter();

                            String letr = String.valueOf(sendBackToPool);

                            db.putInPool(letr);
                            db.UpdateLetterDetails(letr, 1, 2);
                        }
                        uiC.getWord().reset();

                        //reset Rack with letters that were swapped out
                        resetLetter( txtRack1 );
                        resetLetter( txtRack2 );
                        resetLetter( txtRack3 );
                        resetLetter( txtRack4 );
                        resetLetter( txtRack5 );
                        resetLetter( txtRack6 );
                        resetLetter( txtRack7 );

                        answerWord.setText("");
                    }catch( GameException e )
                    {
                        showErrorMsg(e.msg);
                    }

                    //incTurn(turn);
                    try
                    {
                        String presentValStr=turn.getText().toString();
                        int presentIntVal=Integer.parseInt(presentValStr);
                        presentIntVal++;
                        //tv.setText(""+presentIntVal);

                        //String presentMaxStr=maxTurns.getText().toString();
                        //int presentMaxVal=Integer.parseInt(presentMaxStr);
                        //Since the DB layer is WIP, 20 is kept as the default maxTurns
                        int presentMaxVal = maxTurns;
                        if (presentIntVal < presentMaxVal) {
                            turn.setText(""+presentIntVal);
                            db.UpdateGameDetails(gameScoreInt, false,presentIntVal, false, gameID);
                        }
                        else {
                            db.UpdateGameDetails(gameScoreInt, false, presentIntVal, true, gameID);
                            showErrorMsg("The turn count has reached maximum number of turns set for this game");
                            Intent i = new Intent(getApplicationContext(), FinishedGameActivity.class);
                            startActivity(i);
                        }


                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                        showErrorMsg("The turn count cannot be updated");
                        //Log.e("MYAPP", "exception", e);

                    }

                    List<Letter> board= uiC.getCurrBoard().boardLetters;
                    String boardString ="";
                    for (int j=0;j<board.size(); j++){
                        boardString+=board.get(j).toString();
                    }
                    //String[] boardArray = board.toArray(new String[] {});
                    //String boardString = Arrays.toString(boardArray);
                    System.out.println("The board string after swap is:");
                    System.out.println(boardString);

                    List<Letter> rack= uiC.getRack().rackLetter;
                    String rackString="";
                    for (int j=0;j<rack.size(); j++){
                        rackString+=rack.get(j).toString();
                    }
                    System.out.println("The rack string after swap is:");
                    System.out.println(rackString);
                    db.updateBoardRack(gameID, boardString, rackString );


                }




            }
        });
    }

    private void startWordGame()
    {

        initComponents();
        initGame();


    }

    public void boardSelection(View view)
    {
        if(uiC.getWord().hasBoardLetter())
        {
            showErrorMsg("Only one board letter can be selected!!");
            return;
        }

        TextView txtBoardLtr = ((TextView)view);
        txtBoardLtr.setTextColor(Color.RED);
        String wordSelected = (String) txtBoardLtr.getText();
        Letter wordLtr = new Letter(wordSelected.charAt(0), Letter.BELONGS_TO.BOARD);
        uiC.getWord().addLetter(wordLtr);
        try {
            uiC.getCurrBoard().removeLetters( wordLtr );
        } catch (GameException e) {
            showErrorMsg(e.msg);
            return;
        }

        answerWord.setText( uiC.getWord().toString() );
        view.setEnabled(false);
    }

    public void rackSelection(View view) {
        if( !view.isEnabled() )
        {
            showErrorMsg("You already made this selection");
            return;
        }
        TextView txtBoardLtr = ((TextView)view);
        txtBoardLtr.setTextColor(Color.RED);
        String wordSelected = (String) txtBoardLtr.getText();
        Letter wordLtr = new Letter(wordSelected.charAt(0), Letter.BELONGS_TO.RACK);
        uiC.getWord().addLetter(wordLtr);
        try {
            uiC.getRack().removeLetters(wordLtr);
        } catch (GameException e) {
            showErrorMsg(e.msg);
            return;
        }
        answerWord.setText( uiC.getWord().toString() );
        view.setEnabled(false);
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
}

class WordGameUiController
{
    Board currBoard = new Board();


    public WordBank getWordBank() {
        return wordBank;
    }

    public void setWordBank(WordBank wordBank) {
        this.wordBank = wordBank;
    }

    Rack rack = new Rack();
    Word word = new Word();
    WordBank wordBank = new WordBank();

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

   public void initGame(DB_Manager db_manager) throws GameException {

        //pool.refillPool(15);

        currBoard.setupBoard( db_manager );

        rack.setupRack(db_manager);
    }

    public Board getCurrBoard() {
        return currBoard;
    }

    public void setCurrBoard(Board currBoard) {
        this.currBoard = currBoard;
    }




    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
