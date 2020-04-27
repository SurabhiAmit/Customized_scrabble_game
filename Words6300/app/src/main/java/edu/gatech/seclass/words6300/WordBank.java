package edu.gatech.seclass.words6300;

import java.util.HashSet;
import java.util.Set;

public class WordBank {
   /* Word wordUsed=new Word();
    int playCount=new int();
    private static list(Word word){

    }
    private static Map (Word wordused, int playCount){

    }*/
   Set<String> wordsBank = new HashSet<String>();

   public void addToBank(String newStr)
   {
       wordsBank.add(newStr);
   }


   public boolean isInBank( String contains )
   {
       return wordsBank.contains(contains);
   }
}
