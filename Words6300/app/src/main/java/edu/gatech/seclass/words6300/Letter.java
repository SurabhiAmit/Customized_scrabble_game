package edu.gatech.seclass.words6300;

import java.util.Objects;

public class Letter {
    public Character symbol;
    public Integer letterNumber;
    public Float letterPoints;

    enum BELONGS_TO {BOARD,POOL,RACK};
    BELONGS_TO belongsTo;

    public Letter(Character symbol)
    {
        this(symbol, BELONGS_TO.POOL);
    }

    public Letter(Character symbol, BELONGS_TO belongs_to) {
        this.symbol = symbol;
        this.belongsTo = belongs_to;
    }

    public void setCharacter(char character){
        this.symbol = character;
    }
    public void adjustLetterNumber(Integer letterNumber){
        this.letterNumber = letterNumber;
    }

    public void adjustLetterPoints(Float letterPoints){
        this.letterPoints = letterPoints;
    }

    @Override
    public boolean equals(Object o) {
        return symbol.equals( ((Letter)o).symbol )
                && this.belongsTo == ((Letter) o).belongsTo ;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    public BELONGS_TO getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(BELONGS_TO belongsTo) {
        this.belongsTo = belongsTo;
    }

    @Override
    public String toString() {
        return symbol + "";
    }
}
