package com.idansalman.chessprogram.Classes;

public class Move {
    private boolean isWhite;
    private Spot start;
    private Spot end;

    public Move(boolean isWhite,Spot start,Spot end){
        this.isWhite=isWhite;
        this.start=start;
        this.end=end;
    }
}
