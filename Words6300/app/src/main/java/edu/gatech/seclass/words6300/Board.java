package edu.gatech.seclass.words6300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.seclass.words6300.Letter;
//import edu.gatech.seclass.words6300.LetterTile;

public class Board {
    public final Integer boardSize = 4;
    public List<Letter> boardLetters = new ArrayList<Letter>();
    public Letter letterForNextTurn;
    public Integer currCount =0;

    public void addLetters(Letter letters) throws GameException{
        if( currCount >= boardSize ) throw new GameException("board size exceeded");
        currCount ++;
        boardLetters.add(letters);
    }
    public void removeLetters(Letter letter) throws GameException{
        if( currCount == 0 ) throw new GameException("board size cannot be 0");
        currCount --;
        boardLetters.remove(letter);
    }
    public void setupBoard(DB_Manager db_manager) throws GameException {
        if ( boardLetters.size() > boardSize ) throw new GameException("Board should have 4 letters");
        Letter temp;
        for( int i=boardLetters.size() ; i< boardSize;i++ ) {
            temp = new Letter(db_manager.giveLetter().charAt(0));
            temp.setBelongsTo(Letter.BELONGS_TO.BOARD);
            boardLetters.add( temp );
            currCount++;
        }
    }

    public List<Letter> getBoardLetters() {
        return boardLetters;
    }

    public void setBoardLetters(List<Letter> boardLetters) {
        this.boardLetters = boardLetters;
    }
}
