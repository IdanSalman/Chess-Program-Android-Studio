package com.idansalman.chessprogram.Classes;

public class Spot {
    private Piece piece;
    private Coordinates coordinates;

    public Spot(Piece piece, Coordinates coordinates){
        this.piece=piece;
        this.coordinates.setX(coordinates.getX());
        this.coordinates.setY(coordinates.getY());
    }
}
