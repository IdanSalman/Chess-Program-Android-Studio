package com.idansalman.chessprogram.Classes;

import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(boolean white) { super(white); }
    @Override
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        allowedMoves.clear();
        Coordinates c;

        if(board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
            if((coordinates.getY())<7 && (coordinates.getY())>=1){//Going Forward
                if(board[coordinates.getX()][coordinates.getY()-1].getPiece()==null){
                    c=new Coordinates(coordinates.getX() , coordinates.getY() - 1);
                    allowedMoves.add(c);

                    if((coordinates.getY() == 6) && (board[coordinates.getX()][coordinates.getY() - 2].getPiece() == null)){
                        c = new Coordinates(coordinates.getX(), coordinates.getY() - 2);
                        allowedMoves.add(c);
                    }
                }
            }

            if((coordinates.getX())<7 && (coordinates.getY())>=1) {//Eating piece to the right
                if (board[coordinates.getX() + 1][coordinates.getY() - 1].getPiece() != null) {
                    if(!(board[coordinates.getX() + 1][coordinates.getY() - 1].getPiece().isWhite())){
                        c = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
                        allowedMoves.add(c);
                    }
                }

            }

            if((coordinates.getX())>=1 && (coordinates.getY())>=1) {///Eating piece to the left
                if (board[coordinates.getX() - 1][coordinates.getY() - 1].getPiece() != null) {
                    if(!(board[coordinates.getX() - 1][coordinates.getY() - 1].getPiece().isWhite())){
                        c = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
                        allowedMoves.add(c);
                    }
                }
            }
            //Add en Passant

        }else{

            if((coordinates.getY())<7 && (coordinates.getY())>=1) {//Going Forward
                if (board[coordinates.getX()][coordinates.getY() + 1].getPiece() == null) {
                    c = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
                    allowedMoves.add(c);

                    if(coordinates.getY() == 1 && (board[coordinates.getX()][coordinates.getY() + 2].getPiece() == null)){
                        c = new Coordinates(coordinates.getX(), coordinates.getY() + 2);
                        allowedMoves.add(c);
                    }
                }
            }

            if((coordinates.getX())<7 && (coordinates.getY())<7) {//Eating to the right
                if (board[coordinates.getX() + 1][coordinates.getY() + 1].getPiece() != null) {
                    if(board[coordinates.getX() + 1][coordinates.getY() + 1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
                        allowedMoves.add(c);
                    }
                }
            }

            if((coordinates.getX())>=1 && (coordinates.getY())<7) {//Eating to the left
                if (board[coordinates.getX() - 1][coordinates.getY() + 1].getPiece() != null) {
                    if(board[coordinates.getX() - 1][coordinates.getY() + 1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
                        allowedMoves.add(c);
                    }
                }
            }
            //add en Passant
        }
        return allowedMoves;
    }
}
