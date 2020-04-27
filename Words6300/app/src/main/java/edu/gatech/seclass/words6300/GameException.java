package edu.gatech.seclass.words6300;

public class GameException extends Throwable {
    String msg;

    public GameException(String s) {
        this.msg = s;
    }
}
