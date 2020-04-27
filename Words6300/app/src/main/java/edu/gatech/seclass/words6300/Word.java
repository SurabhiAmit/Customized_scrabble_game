package edu.gatech.seclass.words6300;

import java.util.ArrayList;
import java.util.Objects;

public class Word {
    ArrayList<Letter> allLetters = new ArrayList<Letter>();
    boolean boardLetter;

    public void reset()
    {
        allLetters.clear();
        boardLetter = false;
    }

    public void checkWord() throws GameException
    {
        if( allLetters.isEmpty() ) throw new GameException("Word cannot be empty");
        if( !boardLetter ) throw new GameException("Board letter should be included");
        if( allLetters.size() == 1 ) throw new GameException("Rack letter should be selected");
    }

    public void addLetter( Letter ltr )
    {
        if( !boardLetter && ltr.getBelongsTo() == Letter.BELONGS_TO.BOARD ) {
            boardLetter = true;
        }
        allLetters.add(ltr);
    }

    public Letter removeLetter() throws GameException {
        if(allLetters.size() == 0) throw new GameException("No more letters remaining!!");
        Letter ltr = allLetters.remove(allLetters.size()-1);
        if(boardLetter && ltr.getBelongsTo() == Letter.BELONGS_TO.BOARD)
        {
            boardLetter = false;
        }
        //allLetters.remove(ltr);
        return ltr;
    }

    public String toString()
    {
        String word = "";
        for (Letter ltr: allLetters) {
            word+=ltr.toString();
        }
        return word;
    }

    public boolean hasBoardLetter() {
        return boardLetter;
    }

    public int wordLength()
    {
        return allLetters.size();
    }
}
