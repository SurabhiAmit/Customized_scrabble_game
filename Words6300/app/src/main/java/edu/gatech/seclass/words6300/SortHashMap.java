/*https://www.callicoder.com/java-priority-queue/*/

package edu.gatech.seclass.words6300;

import android.support.annotation.NonNull;

public class SortHashMap implements Comparable<SortHashMap>{
    private String key;
    private int value;

    public SortHashMap (String key, int value){
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }
    public int getValue(){
        return value;
    }
    public String mapvalue(){
        return Integer.toString(value);
    }
    public void setKey(String key){
        this.key=key;
    }
    public void setValue(int value){
        this.value=value;
    }
    @Override
    public int compareTo(SortHashMap map){
        if(this.getValue()>map.getValue()){
            return 1;
        }else if (this.getValue()<map.getValue()){
            return -1;
        }else{
            return 0;
        }
    }



}
