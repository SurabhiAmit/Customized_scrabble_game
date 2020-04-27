package edu.gatech.seclass.words6300;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rack {
    public final Integer rackSize = 7;
    List<Letter> rackLetter = new ArrayList<Letter>();
    public Integer currCount =0;

    public   void addLetter( Letter rackLetter1 ) throws GameException {
        if( currCount>=7 ) throw new GameException("Max number of letter in rack can only be 7");
        this.rackLetter.add(rackLetter1);

        currCount++;
    }

    public void removeLetters(Letter rackLetter )  throws GameException{
        if( currCount == 0 ) throw new GameException("Cannot delete from rack");
        this.rackLetter.remove(rackLetter);

        currCount--;
    }
    /*
    public void swapLetters(Letter[] rackLetter, Pool pool){
       removeLetters(rackLetter);
        // randomly select from pool rackLetter.length count of letterTiles
        Random random = new Random();
        List<Letter> poolLetter = new ArrayList<Letter>();

        for (int i=0;i<rackLetter.length;i++){
            //poolLetter.add(pool.get((random.nextInt(rackLetter.length)));
        }}*/

    public void setupRack(DB_Manager db_manager) throws GameException {
        //if ( letters.length != 4 ) throw new GameException("Board should have 4 letters");
        if( rackLetter.size() < rackSize )
        {
            Letter temp;
            for( int i = rackLetter.size(); i<rackSize; i++) {
                temp = new Letter(db_manager.giveLetter().charAt(0));
                temp.setBelongsTo(Letter.BELONGS_TO.RACK);
                rackLetter.add(temp);

                currCount++;
            }
        }
        else throw new GameException("Pool size limit reached!");
    }

    public List<Letter> getRackLetter() {
        return rackLetter;
    }

    public void setRackLetter(List<Letter> rackLetter) {
        this.rackLetter = rackLetter;
    }
}
