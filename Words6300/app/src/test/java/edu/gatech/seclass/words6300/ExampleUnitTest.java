package edu.gatech.seclass.words6300;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    // Word cannot be empty
    @Test(expected = GameException.class)
    public void checkIfWord() throws GameException
    {
        Word word = new Word();
        word.checkWord();
        //Letter ltr = new Letter( 'A', Letter.BELONGS_TO.BOARD);
        //word.addLetter(ltr);
       // System.out.println(word.hasBoardLetter());
        //assertTrue("Word cannot be empty", word.checkWord());
    }

    // Word should have atleast one board letter
    @Test (expected = GameException.class)
    public void checkBoardLetterInWord() throws GameException
    {
        Word word = new Word();
        Letter ltr = new Letter( 'A', Letter.BELONGS_TO.RACK);
        word.addLetter(ltr);
        word.checkWord();
        //System.out.println(word.hasBoardLetter());
        //assertTrue("Board letter should be included", word.hasBoardLetter());
    }

    // Word cannot be reused in a game, word inserted into wordBank for a partcilar game cannot be used again for the same game
    @Test
    public void checkIfUsedWord()
    {
        Word word1 = new Word();
        Letter ltr = new Letter( 'A', Letter.BELONGS_TO.BOARD);
        word1.addLetter(ltr);
        Letter lt = new Letter( 'C', Letter.BELONGS_TO.RACK);
        word1.addLetter(lt);
        WordBank wordbank = new WordBank();
        wordbank.addToBank(String.valueOf(word1));
        assertTrue("same word cannot be reused in a game",wordbank.isInBank(String.valueOf(word1)) );
    }

    // Word should have atleast one rack letter as a board letter by itself cannot form a word (More than 1 letter needed)
    @Test (expected = GameException.class)
    public void checkRackLetterInWord() throws GameException
    {
        Word word = new Word();
        Letter ltr = new Letter( 'A', Letter.BELONGS_TO.BOARD);
        word.addLetter(ltr);
        word.checkWord();
        //System.out.println(word.hasBoardLetter());
        //assertTrue("Board letter should be included", word.hasBoardLetter());
    }

    //Board can have maximum 4 letters
    @Test (expected = GameException.class)
    public void BoardMax4Letters() throws GameException{
        Board board = new Board();
        Letter ltr1 = new Letter( 'C', Letter.BELONGS_TO.RACK);
        Letter ltr2 = new Letter( 'C', Letter.BELONGS_TO.RACK);
        Letter ltr3 = new Letter( 'C', Letter.BELONGS_TO.RACK);
        Letter ltr4 = new Letter( 'C', Letter.BELONGS_TO.RACK);
        board.addLetters(ltr1);
        board.addLetters(ltr2);
        board.addLetters(ltr3);
        board.addLetters(ltr4);
        board.addLetters(ltr2);
    }

    //Letter push to rack is working (as part of swap functionality)
    @Test
    public void fillRack() throws GameException {
        Rack rack = new Rack();
        Letter ltr = new Letter( 'C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr);
        //System.out.println(rack.getRackLetter().get(0).equals(ltr));
        assertTrue("Rack push worked",rack.getRackLetter().get(0).equals(ltr));
    }

    //Board selection for word formation works
    @Test
    public void boardSelection() throws GameException{
        Board board = new Board();
        Letter ltr = new Letter( 'C', Letter.BELONGS_TO.BOARD);
        board.addLetters(ltr);
        board.removeLetters(ltr);

    }
    // Word should have atleast one letter - It cannot be empty
    @Test (expected = GameException.class)
    public void checkIfWordEmpty() throws GameException
    {
        Word word = new Word();
        word.checkWord();
        //System.out.println(word.hasBoardLetter());
        //assertTrue("Board letter should be included", word.hasBoardLetter());
    }

    //The board letter in the word is correctly returned by word.hasBoardLetter() function
    @Test
    public void checkBoardLetter()
    {
        Word word = new Word();
        Letter ltr = new Letter( 'A', Letter.BELONGS_TO.BOARD);
        word.addLetter(ltr);
        //System.out.println(word.hasBoardLetter());
        assertTrue("Should return board letter in word", word.hasBoardLetter());
    }

    //More than 7 letters cannot be swapped from rack, 7 letters added, tried to swap 8 letters from swap
    @Test (expected = GameException.class)
    public void Swap7lettersMax() throws GameException {
        Rack rack = new Rack();
        Letter ltr1 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr1);
        Letter ltr2 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr2);
        Letter ltr3 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr3);
        Letter ltr4 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr4);
        Letter ltr5 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr5);
        Letter ltr6 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr6);
        Letter ltr7 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr7);
        rack.removeLetters(ltr1);
        rack.removeLetters(ltr2);
        rack.removeLetters(ltr3);
        rack.removeLetters(ltr4);
        rack.removeLetters(ltr5);
        rack.removeLetters(ltr6);
        rack.removeLetters(ltr7);
        rack.removeLetters(ltr1);
    }

    //Atleast there should be 1 letter to swap from the rack
    @Test (expected = GameException.class)
    public void Swap1LetterMin() throws GameException {
        Rack rack = new Rack();
        Letter ltr = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.removeLetters(ltr);
    }

    //Rack can take as much as 7 letters but not more
    @Test (expected = GameException.class)
    public void RackMax7Letters() throws GameException {
        Rack rack = new Rack();
        Letter ltr1 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr1);
        Letter ltr2 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr2);
        Letter ltr3 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr3);
        Letter ltr4 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr4);
        Letter ltr5 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr5);
        Letter ltr6 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr6);
        Letter ltr7 = new Letter('C', Letter.BELONGS_TO.RACK);
        rack.addLetter(ltr7);
        rack.addLetter(ltr3);
    }





}
