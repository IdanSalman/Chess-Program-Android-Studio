package com.idansalman.chessprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.idansalman.chessprogram.Classes.Bishop;
import com.idansalman.chessprogram.Classes.Coordinates;
import com.idansalman.chessprogram.Classes.King;
import com.idansalman.chessprogram.Classes.Knight;
import com.idansalman.chessprogram.Classes.Pawn;
import com.idansalman.chessprogram.Classes.Piece;
import com.idansalman.chessprogram.Classes.Position;
import com.idansalman.chessprogram.Classes.Queen;
import com.idansalman.chessprogram.Classes.Rook;
import java.util.ArrayList;

public class Play extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TAG";
    public Position[][] Board = new Position[8][8];
    public TextView[][] PieceDisplay = new TextView[8][8];
    public TextView[][] BackgroundDisplay = new TextView[8][8];
    public ArrayList<Coordinates> Cords = new ArrayList<>();
    public Coordinates clickedPosition = new Coordinates(0, 0);
    public boolean Turn=true;/*true means white's turn false means black's turn*/
    public boolean pieceSelected=false;
    public Coordinates selectedPiece;/*The chosen piece to move*/
    public int check;/*1 if white checks, 2 if black checks, 3 if not checked*/
    public TextView game_over;
    public LinearLayout promotion;
    public Button play_again;

    Piece WKing=new King(true);
    Piece BKing=new King(false);

    Piece WQueen=new Queen(true);
    Piece BQueen=new Queen(false);

    Piece WKnight1=new Knight(true);
    Piece WKnight2=new Knight(true);
    Piece BKnight1=new Knight(false);
    Piece BKnight2=new Knight(false);

    Piece WBishop1=new Bishop(true);
    Piece WBishop2=new Bishop(true);
    Piece BBishop1=new Bishop(false);
    Piece BBishop2=new Bishop(false);

    Piece WRook1=new Rook(true);
    Piece WRook2=new Rook(true);
    Piece BRook1=new Rook(false);
    Piece BRook2=new Rook(false);

    Piece WPawn1=new Pawn(true);
    Piece WPawn2=new Pawn(true);
    Piece WPawn3=new Pawn(true);
    Piece WPawn4=new Pawn(true);
    Piece WPawn5=new Pawn(true);
    Piece WPawn6=new Pawn(true);
    Piece WPawn7=new Pawn(true);
    Piece WPawn8=new Pawn(true);
    Piece BPawn1=new Pawn(false);
    Piece BPawn2=new Pawn(false);
    Piece BPawn3=new Pawn(false);
    Piece BPawn4=new Pawn(false);
    Piece BPawn5=new Pawn(false);
    Piece BPawn6=new Pawn(false);
    Piece BPawn7=new Pawn(false);
    Piece BPawn8=new Pawn(false);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initializeBoard();
        game_over = (TextView)findViewById(R.id.game_over);
        promotion = (LinearLayout)findViewById(R.id.promotion);
        play_again = (Button)findViewById(R.id.button2);
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board[i][j] = new Position(null);
            }
        }
        Board[0][7].setPiece(WRook1);
        Board[1][7].setPiece(WKnight1);
        Board[2][7].setPiece(WBishop1);
        Board[3][7].setPiece(WQueen);
        Board[4][7].setPiece(WKing);
        Board[5][7].setPiece(WBishop2);
        Board[6][7].setPiece(WKnight2);
        Board[7][7].setPiece(WRook2);

        Board[0][6].setPiece(WPawn1);
        Board[1][6].setPiece(WPawn2);
        Board[2][6].setPiece(WPawn3);
        Board[3][6].setPiece(WPawn4);
        Board[4][6].setPiece(WPawn5);
        Board[5][6].setPiece(WPawn6);
        Board[6][6].setPiece(WPawn7);
        Board[7][6].setPiece(WPawn8);

        Board[0][0].setPiece(BRook1);
        Board[1][0].setPiece(BKnight1);
        Board[2][0].setPiece(BBishop1);
        Board[3][0].setPiece(BQueen);
        Board[4][0].setPiece(BKing);
        Board[5][0].setPiece(BBishop2);
        Board[6][0].setPiece(BKnight2);
        Board[7][0].setPiece(BRook2);

        Board[0][1].setPiece(BPawn1);
        Board[1][1].setPiece(BPawn2);
        Board[2][1].setPiece(BPawn3);
        Board[3][1].setPiece(BPawn4);
        Board[4][1].setPiece(BPawn5);
        Board[5][1].setPiece(BPawn6);
        Board[6][1].setPiece(BPawn7);
        Board[7][1].setPiece(BPawn8);

        PieceDisplay[0][0] = (TextView) findViewById(R.id.R00);
        BackgroundDisplay[0][0] = (TextView) findViewById(R.id.R000);
        PieceDisplay[1][0] = (TextView) findViewById(R.id.R10);
        BackgroundDisplay[1][0] = (TextView) findViewById(R.id.R010);
        PieceDisplay[2][0] = (TextView) findViewById(R.id.R20);
        BackgroundDisplay[2][0] = (TextView) findViewById(R.id.R020);
        PieceDisplay[3][0] = (TextView) findViewById(R.id.R30);
        BackgroundDisplay[3][0] = (TextView) findViewById(R.id.R030);
        PieceDisplay[4][0] = (TextView) findViewById(R.id.R40);
        BackgroundDisplay[4][0] = (TextView) findViewById(R.id.R040);
        PieceDisplay[5][0] = (TextView) findViewById(R.id.R50);
        BackgroundDisplay[5][0] = (TextView) findViewById(R.id.R050);
        PieceDisplay[6][0] = (TextView) findViewById(R.id.R60);
        BackgroundDisplay[6][0] = (TextView) findViewById(R.id.R060);
        PieceDisplay[7][0] = (TextView) findViewById(R.id.R70);
        BackgroundDisplay[7][0] = (TextView) findViewById(R.id.R070);

        PieceDisplay[0][1] = (TextView) findViewById(R.id.R01);
        BackgroundDisplay[0][1] = (TextView) findViewById(R.id.R001);
        PieceDisplay[1][1] = (TextView) findViewById(R.id.R11);
        BackgroundDisplay[1][1] = (TextView) findViewById(R.id.R011);
        PieceDisplay[2][1] = (TextView) findViewById(R.id.R21);
        BackgroundDisplay[2][1] = (TextView) findViewById(R.id.R021);
        PieceDisplay[3][1] = (TextView) findViewById(R.id.R31);
        BackgroundDisplay[3][1] = (TextView) findViewById(R.id.R031);
        PieceDisplay[4][1] = (TextView) findViewById(R.id.R41);
        BackgroundDisplay[4][1] = (TextView) findViewById(R.id.R041);
        PieceDisplay[5][1] = (TextView) findViewById(R.id.R51);
        BackgroundDisplay[5][1] = (TextView) findViewById(R.id.R051);
        PieceDisplay[6][1] = (TextView) findViewById(R.id.R61);
        BackgroundDisplay[6][1] = (TextView) findViewById(R.id.R061);
        PieceDisplay[7][1] = (TextView) findViewById(R.id.R71);
        BackgroundDisplay[7][1] = (TextView) findViewById(R.id.R071);

        PieceDisplay[0][2] = (TextView) findViewById(R.id.R02);
        BackgroundDisplay[0][2] = (TextView) findViewById(R.id.R002);
        PieceDisplay[1][2] = (TextView) findViewById(R.id.R12);
        BackgroundDisplay[1][2] = (TextView) findViewById(R.id.R012);
        PieceDisplay[2][2] = (TextView) findViewById(R.id.R22);
        BackgroundDisplay[2][2] = (TextView) findViewById(R.id.R022);
        PieceDisplay[3][2] = (TextView) findViewById(R.id.R32);
        BackgroundDisplay[3][2] = (TextView) findViewById(R.id.R032);
        PieceDisplay[4][2] = (TextView) findViewById(R.id.R42);
        BackgroundDisplay[4][2] = (TextView) findViewById(R.id.R042);
        PieceDisplay[5][2] = (TextView) findViewById(R.id.R52);
        BackgroundDisplay[5][2] = (TextView) findViewById(R.id.R052);
        PieceDisplay[6][2] = (TextView) findViewById(R.id.R62);
        BackgroundDisplay[6][2] = (TextView) findViewById(R.id.R062);
        PieceDisplay[7][2] = (TextView) findViewById(R.id.R72);
        BackgroundDisplay[7][2] = (TextView) findViewById(R.id.R072);

        PieceDisplay[0][3] = (TextView) findViewById(R.id.R03);
        BackgroundDisplay[0][3] = (TextView) findViewById(R.id.R003);
        PieceDisplay[1][3] = (TextView) findViewById(R.id.R13);
        BackgroundDisplay[1][3] = (TextView) findViewById(R.id.R013);
        PieceDisplay[2][3] = (TextView) findViewById(R.id.R23);
        BackgroundDisplay[2][3] = (TextView) findViewById(R.id.R023);
        PieceDisplay[3][3] = (TextView) findViewById(R.id.R33);
        BackgroundDisplay[3][3] = (TextView) findViewById(R.id.R033);
        PieceDisplay[4][3] = (TextView) findViewById(R.id.R43);
        BackgroundDisplay[4][3] = (TextView) findViewById(R.id.R043);
        PieceDisplay[5][3] = (TextView) findViewById(R.id.R53);
        BackgroundDisplay[5][3] = (TextView) findViewById(R.id.R053);
        PieceDisplay[6][3] = (TextView) findViewById(R.id.R63);
        BackgroundDisplay[6][3] = (TextView) findViewById(R.id.R063);
        PieceDisplay[7][3] = (TextView) findViewById(R.id.R73);
        BackgroundDisplay[7][3] = (TextView) findViewById(R.id.R073);

        PieceDisplay[0][4] = (TextView) findViewById(R.id.R04);
        BackgroundDisplay[0][4] = (TextView) findViewById(R.id.R004);
        PieceDisplay[1][4] = (TextView) findViewById(R.id.R14);
        BackgroundDisplay[1][4] = (TextView) findViewById(R.id.R014);
        PieceDisplay[2][4] = (TextView) findViewById(R.id.R24);
        BackgroundDisplay[2][4] = (TextView) findViewById(R.id.R024);
        PieceDisplay[3][4] = (TextView) findViewById(R.id.R34);
        BackgroundDisplay[3][4] = (TextView) findViewById(R.id.R034);
        PieceDisplay[4][4] = (TextView) findViewById(R.id.R44);
        BackgroundDisplay[4][4] = (TextView) findViewById(R.id.R044);
        PieceDisplay[5][4] = (TextView) findViewById(R.id.R54);
        BackgroundDisplay[5][4] = (TextView) findViewById(R.id.R054);
        PieceDisplay[6][4] = (TextView) findViewById(R.id.R64);
        BackgroundDisplay[6][4] = (TextView) findViewById(R.id.R064);
        PieceDisplay[7][4] = (TextView) findViewById(R.id.R74);
        BackgroundDisplay[7][4] = (TextView) findViewById(R.id.R074);

        PieceDisplay[0][5] = (TextView) findViewById(R.id.R05);
        BackgroundDisplay[0][5] = (TextView) findViewById(R.id.R005);
        PieceDisplay[1][5] = (TextView) findViewById(R.id.R15);
        BackgroundDisplay[1][5] = (TextView) findViewById(R.id.R015);
        PieceDisplay[2][5] = (TextView) findViewById(R.id.R25);
        BackgroundDisplay[2][5] = (TextView) findViewById(R.id.R025);
        PieceDisplay[3][5] = (TextView) findViewById(R.id.R35);
        BackgroundDisplay[3][5] = (TextView) findViewById(R.id.R035);
        PieceDisplay[4][5] = (TextView) findViewById(R.id.R45);
        BackgroundDisplay[4][5] = (TextView) findViewById(R.id.R045);
        PieceDisplay[5][5] = (TextView) findViewById(R.id.R55);
        BackgroundDisplay[5][5] = (TextView) findViewById(R.id.R055);
        PieceDisplay[6][5] = (TextView) findViewById(R.id.R65);
        BackgroundDisplay[6][5] = (TextView) findViewById(R.id.R065);
        PieceDisplay[7][5] = (TextView) findViewById(R.id.R75);
        BackgroundDisplay[7][5] = (TextView) findViewById(R.id.R075);

        PieceDisplay[0][6] = (TextView) findViewById(R.id.R06);
        BackgroundDisplay[0][6] = (TextView) findViewById(R.id.R006);
        PieceDisplay[1][6] = (TextView) findViewById(R.id.R16);
        BackgroundDisplay[1][6] = (TextView) findViewById(R.id.R016);
        PieceDisplay[2][6] = (TextView) findViewById(R.id.R26);
        BackgroundDisplay[2][6] = (TextView) findViewById(R.id.R026);
        PieceDisplay[3][6] = (TextView) findViewById(R.id.R36);
        BackgroundDisplay[3][6] = (TextView) findViewById(R.id.R036);
        PieceDisplay[4][6] = (TextView) findViewById(R.id.R46);
        BackgroundDisplay[4][6] = (TextView) findViewById(R.id.R046);
        PieceDisplay[5][6] = (TextView) findViewById(R.id.R56);
        BackgroundDisplay[5][6] = (TextView) findViewById(R.id.R056);
        PieceDisplay[6][6] = (TextView) findViewById(R.id.R66);
        BackgroundDisplay[6][6] = (TextView) findViewById(R.id.R066);
        PieceDisplay[7][6] = (TextView) findViewById(R.id.R76);
        BackgroundDisplay[7][6] = (TextView) findViewById(R.id.R076);

        PieceDisplay[0][7] = (TextView) findViewById(R.id.R07);
        BackgroundDisplay[0][7] = (TextView) findViewById(R.id.R007);
        PieceDisplay[1][7] = (TextView) findViewById(R.id.R17);
        BackgroundDisplay[1][7] = (TextView) findViewById(R.id.R017);
        PieceDisplay[2][7] = (TextView) findViewById(R.id.R27);
        BackgroundDisplay[2][7] = (TextView) findViewById(R.id.R027);
        PieceDisplay[3][7] = (TextView) findViewById(R.id.R37);
        BackgroundDisplay[3][7] = (TextView) findViewById(R.id.R037);
        PieceDisplay[4][7] = (TextView) findViewById(R.id.R47);
        BackgroundDisplay[4][7] = (TextView) findViewById(R.id.R047);
        PieceDisplay[5][7] = (TextView) findViewById(R.id.R57);
        BackgroundDisplay[5][7] = (TextView) findViewById(R.id.R057);
        PieceDisplay[6][7] = (TextView) findViewById(R.id.R67);
        BackgroundDisplay[6][7] = (TextView) findViewById(R.id.R067);
        PieceDisplay[7][7] = (TextView) findViewById(R.id.R77);
        BackgroundDisplay[7][7] = (TextView) findViewById(R.id.R077);
        Turn = true;
        setBoard();
    }
    private void setBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece p = Board[i][j].getPiece();
                int x;

                if (Board[i][j].getPiece() != null) {
                    if (p instanceof King)
                        x = 0;
                    else if (p instanceof Queen)
                        x = 1;
                    else if (p instanceof Rook)
                        x = 2;
                    else if (p instanceof Bishop)
                        x = 3;
                    else if (p instanceof Knight)
                        x = 4;
                    else if (p instanceof Pawn)
                        x = 5;
                    else
                        x = 6;
                    switch (x) {
                        case 0:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wking);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.bking);
                            }
                            break;

                        case 1:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wqueen);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.bqueen);
                            }
                            break;

                        case 2:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wrook);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.brook);
                            }
                            break;

                        case 3:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wbishop);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.bbishop);
                            }
                            break;

                        case 4:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wknight);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.bknight);
                            }
                            break;

                        case 5:
                            if (p.isWhite()) {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.wpawn);
                            } else {
                                PieceDisplay[i][j].setBackgroundResource(R.drawable.bpawn);
                            }
                            break;

                        default:

                    }
                }else{
                    PieceDisplay[i][j].setBackgroundResource(0);
                }
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.R00:
                clickedPosition.setX(0);
                clickedPosition.setY(0);
                break;
            case R.id.R10:
                clickedPosition.setX(1);
                clickedPosition.setY(0);
                break;
            case R.id.R20:
                clickedPosition.setX(2);
                clickedPosition.setY(0);
                break;
            case R.id.R30:
                clickedPosition.setX(3);
                clickedPosition.setY(0);
                break;
            case R.id.R40:
                clickedPosition.setX(4);
                clickedPosition.setY(0);
                break;
            case R.id.R50:
                clickedPosition.setX(5);
                clickedPosition.setY(0);
                break;
            case R.id.R60:
                clickedPosition.setX(6);
                clickedPosition.setY(0);
                break;
            case R.id.R70:
                clickedPosition.setX(7);
                clickedPosition.setY(0);
                break;

            case R.id.R01:
                clickedPosition.setX(0);
                clickedPosition.setY(1);
                break;
            case R.id.R11:
                clickedPosition.setX(1);
                clickedPosition.setY(1);
                break;
            case R.id.R21:
                clickedPosition.setX(2);
                clickedPosition.setY(1);
                break;
            case R.id.R31:
                clickedPosition.setX(3);
                clickedPosition.setY(1);
                break;
            case R.id.R41:
                clickedPosition.setX(4);
                clickedPosition.setY(1);
                break;
            case R.id.R51:
                clickedPosition.setX(5);
                clickedPosition.setY(1);
                break;
            case R.id.R61:
                clickedPosition.setX(6);
                clickedPosition.setY(1);
                break;
            case R.id.R71:
                clickedPosition.setX(7);
                clickedPosition.setY(1);
                break;

            case R.id.R02:
                clickedPosition.setX(0);
                clickedPosition.setY(2);
                break;
            case R.id.R12:
                clickedPosition.setX(1);
                clickedPosition.setY(2);
                break;
            case R.id.R22:
                clickedPosition.setX(2);
                clickedPosition.setY(2);
                break;
            case R.id.R32:
                clickedPosition.setX(3);
                clickedPosition.setY(2);
                break;
            case R.id.R42:
                clickedPosition.setX(4);
                clickedPosition.setY(2);
                break;
            case R.id.R52:
                clickedPosition.setX(5);
                clickedPosition.setY(2);
                break;
            case R.id.R62:
                clickedPosition.setX(6);
                clickedPosition.setY(2);
                break;
            case R.id.R72:
                clickedPosition.setX(7);
                clickedPosition.setY(2);
                break;

            case R.id.R03:
                clickedPosition.setX(0);
                clickedPosition.setY(3);
                break;
            case R.id.R13:
                clickedPosition.setX(1);
                clickedPosition.setY(3);
                break;
            case R.id.R23:
                clickedPosition.setX(2);
                clickedPosition.setY(3);
                break;
            case R.id.R33:
                clickedPosition.setX(3);
                clickedPosition.setY(3);
                break;
            case R.id.R43:
                clickedPosition.setX(4);
                clickedPosition.setY(3);
                break;
            case R.id.R53:
                clickedPosition.setX(5);
                clickedPosition.setY(3);
                break;
            case R.id.R63:
                clickedPosition.setX(6);
                clickedPosition.setY(3);
                break;
            case R.id.R73:
                clickedPosition.setX(7);
                clickedPosition.setY(3);
                break;

            case R.id.R04:
                clickedPosition.setX(0);
                clickedPosition.setY(4);
                break;
            case R.id.R14:
                clickedPosition.setX(1);
                clickedPosition.setY(4);
                break;
            case R.id.R24:
                clickedPosition.setX(2);
                clickedPosition.setY(4);
                break;
            case R.id.R34:
                clickedPosition.setX(3);
                clickedPosition.setY(4);
                break;
            case R.id.R44:
                clickedPosition.setX(4);
                clickedPosition.setY(4);
                break;
            case R.id.R54:
                clickedPosition.setX(5);
                clickedPosition.setY(4);
                break;
            case R.id.R64:
                clickedPosition.setX(6);
                clickedPosition.setY(4);
                break;
            case R.id.R74:
                clickedPosition.setX(7);
                clickedPosition.setY(4);
                break;

            case R.id.R05:
                clickedPosition.setX(0);
                clickedPosition.setY(5);
                break;
            case R.id.R15:
                clickedPosition.setX(1);
                clickedPosition.setY(5);
                break;
            case R.id.R25:
                clickedPosition.setX(2);
                clickedPosition.setY(5);
                break;
            case R.id.R35:
                clickedPosition.setX(3);
                clickedPosition.setY(5);
                break;
            case R.id.R45:
                clickedPosition.setX(4);
                clickedPosition.setY(5);
                break;
            case R.id.R55:
                clickedPosition.setX(5);
                clickedPosition.setY(5);
                break;
            case R.id.R65:
                clickedPosition.setX(6);
                clickedPosition.setY(5);
                break;
            case R.id.R75:
                clickedPosition.setX(7);
                clickedPosition.setY(5);
                break;

            case R.id.R06:
                clickedPosition.setX(0);
                clickedPosition.setY(6);
                break;
            case R.id.R16:
                clickedPosition.setX(1);
                clickedPosition.setY(6);
                break;
            case R.id.R26:
                clickedPosition.setX(2);
                clickedPosition.setY(6);
                break;
            case R.id.R36:
                clickedPosition.setX(3);
                clickedPosition.setY(6);
                break;
            case R.id.R46:
                clickedPosition.setX(4);
                clickedPosition.setY(6);
                break;
            case R.id.R56:
                clickedPosition.setX(5);
                clickedPosition.setY(6);
                break;
            case R.id.R66:
                clickedPosition.setX(6);
                clickedPosition.setY(6);
                break;
            case R.id.R76:
                clickedPosition.setX(7);
                clickedPosition.setY(6);
                break;

            case R.id.R07:
                clickedPosition.setX(0);
                clickedPosition.setY(7);
                break;
            case R.id.R17:
                clickedPosition.setX(1);
                clickedPosition.setY(7);
                break;
            case R.id.R27:
                clickedPosition.setX(2);
                clickedPosition.setY(7);
                break;
            case R.id.R37:
                clickedPosition.setX(3);
                clickedPosition.setY(7);
                break;
            case R.id.R47:
                clickedPosition.setX(4);
                clickedPosition.setY(7);
                break;
            case R.id.R57:
                clickedPosition.setX(5);
                clickedPosition.setY(7);
                break;
            case R.id.R67:
                clickedPosition.setX(6);
                clickedPosition.setY(7);
                break;
            case R.id.R77:
                clickedPosition.setX(7);
                clickedPosition.setY(7);
                break;
        }
        if(!pieceSelected){
            if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece()==null)
                return;
            else{
                if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece().isWhite()!=Turn)
                    return;
                else{
                    pieceSelected=true;
                    Cords.clear();
                    Cords=gameMoves(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece().AllowedMoves(clickedPosition,Board),clickedPosition);
                    BackgroundDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.color.colorSelected);
                    setColorAtAllowedPosition(Cords);
                }
            }
        }
        else{
            if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece()==null){
                if(moveIsAllowed(Cords,clickedPosition)) {
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(Board[selectedPiece.getX()][selectedPiece.getY()].getPiece());
                    Board[selectedPiece.getX()][selectedPiece.getY()].setPiece(null);
                    resetColorAtAllowedPosition(Cords);
                    resetColorAtLastPosition(selectedPiece);
                    pieceSelected=false;
                    Turn=!Turn;
                    isCheckmate();
                }
                else{
                    pieceSelected=false;
                    resetColorAtAllowedPosition(Cords);
                    resetColorAtLastPosition(selectedPiece);
                }
            }
            else{
                if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece().isWhite()==Turn){
                    pieceSelected=true;
                    resetColorAtAllowedPosition(Cords);
                    resetColorAtLastPosition(selectedPiece);

                    Cords.clear();
                    Cords=gameMoves(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece().AllowedMoves(clickedPosition,Board),clickedPosition);
                    BackgroundDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.color.colorSelected);
                    setColorAtAllowedPosition(Cords);
                }
                else{
                    if(moveIsAllowed(Cords,clickedPosition)) {
                        Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(Board[selectedPiece.getX()][selectedPiece.getY()].getPiece());
                        Board[selectedPiece.getX()][selectedPiece.getY()].setPiece(null);
                        resetColorAtAllowedPosition(Cords);
                        resetColorAtLastPosition(selectedPiece);
                        pieceSelected=false;
                        Turn=!Turn;
                        isCheckmate();
                    }
                    else{
                        pieceSelected=false;
                        resetColorAtAllowedPosition(Cords);
                        resetColorAtLastPosition(selectedPiece);
                    }
                }
            }
        }
        pawnPromotion();
        selectedPiece = new Coordinates(clickedPosition.getX(), clickedPosition.getY());
        setBoard();
    }
    private void resetColorAtAllowedPosition(ArrayList<Coordinates> Cords) {
        for(int i=0; i<Cords.size(); i++){
            if((Cords.get(i).getX() + Cords.get(i).getY())%2==0){
                BackgroundDisplay[Cords.get(i).getX()][Cords.get(i).getY()].setBackgroundResource(R.color.colorBoardDark);
            }else {
                BackgroundDisplay[Cords.get(i).getX()][Cords.get(i).getY()].setBackgroundResource(R.color.colorBoardLight);
            }
        }
    }
    private void setColorAtAllowedPosition(ArrayList<Coordinates> Cords) {
        for(int i=0;i< Cords.size();i++){
            BackgroundDisplay[Cords.get(i).getX()][Cords.get(i).getY()].setBackgroundResource(R.drawable.burble);
        }
    }
    private void resetColorAtLastPosition(Coordinates selectedPiece){
        if((selectedPiece.getX() + selectedPiece.getY())%2==0){
            BackgroundDisplay[selectedPiece.getX()][selectedPiece.getY()].setBackgroundResource(R.color.colorBoardDark);
        }else {
            BackgroundDisplay[selectedPiece.getX()][selectedPiece.getY()].setBackgroundResource(R.color.colorBoardLight);
        }
    }
    public int isChecked(){
        ArrayList<Coordinates> List = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Board[i][j].getPiece() != null){
                    List.clear();
                    Coordinates c = new Coordinates(i,j);
                    List = Board[i][j].getPiece().AllowedMoves(c,Board);
                    for (int x=0;x<List.size();x++){
                        if(Board[List.get(x).getX()][List.get(x).getY()].getPiece() instanceof King){
                            if(Board[i][j].getPiece().isWhite() != Board[List.get(x).getX()][List.get(x).getY()].getPiece().isWhite()){
                                if(Board[i][j].getPiece().isWhite())
                                    return 1;
                                else
                                    return 2;
                            }
                        }
                    }
                }
            }
        }
        return 3;
    }
    private void pawnPromotion(){
        if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece() instanceof Pawn){
            if(Board[clickedPosition.getX()][clickedPosition.getY()].getPiece().isWhite()){
                if(clickedPosition.getY() == 0){
                    promotion.setVisibility(View.VISIBLE);
                }
            }else{
                if(clickedPosition.getY() == 7){
                    promotion.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    private boolean moveIsAllowed(ArrayList<Coordinates> piece, Coordinates coordinate) {
        Boolean Allowed = false;
        for(int i =0;i<piece.size();i++){
            if(piece.get(i).getX() == coordinate.getX()  &&  piece.get(i).getY() == coordinate.getY()){
                Allowed = true;
                break;
            }
        }
        return Allowed;
    }
    private boolean causeCheck(Coordinates piece, Coordinates coordinate){
        if(Board[piece.getX()][piece.getY()].getPiece()==null)
            return false;
        int x=isChecked();
        boolean isPieceWhite=Board[piece.getX()][piece.getY()].getPiece().isWhite();
        Piece p1=Board[piece.getX()][piece.getY()].getPiece();
        Piece p2;
        if(Board[coordinate.getX()][coordinate.getY()].getPiece()!=null)
            p2=Board[coordinate.getX()][coordinate.getY()].getPiece();
        else
            p2=null;
        Board[coordinate.getX()][coordinate.getY()].setPiece(Board[piece.getX()][piece.getY()].getPiece());
        Board[piece.getX()][piece.getY()].setPiece(null);
        if(x<3&&isChecked()<3){
            Board[coordinate.getX()][coordinate.getY()].setPiece(p2);
            Board[piece.getX()][piece.getY()].setPiece(p1);
            return true;
        }
        if(isChecked()==2&&isPieceWhite){
            Board[coordinate.getX()][coordinate.getY()].setPiece(p2);
            Board[piece.getX()][piece.getY()].setPiece(p1);
            return true;
        }
        if(isChecked()==1&&!isPieceWhite){
            Board[coordinate.getX()][coordinate.getY()].setPiece(p2);
            Board[piece.getX()][piece.getY()].setPiece(p1);
            return true;
        }
        Board[coordinate.getX()][coordinate.getY()].setPiece(p2);
        Board[piece.getX()][piece.getY()].setPiece(p1);
        return false;
    }
    private ArrayList<Coordinates> gameMoves(ArrayList<Coordinates> allowed,Coordinates piece){
        ArrayList<Coordinates> temp=new ArrayList<>();
        temp.clear();
        for(int i=0;i<allowed.size();i++){
            if(!causeCheck(piece,allowed.get(i)))
                temp.add(allowed.get(i));
        }
        return temp;
    }
    public void promotion(View view) {
        int x = view.getId();
        switch (x){
            case R.id.pawn_queen :
                if(clickedPosition.getY() == 0){
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Queen(true));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.wqueen);
                }else{
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Queen(false));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.bqueen);
                }
                break;
            case R.id.pawn_rook :
                if(clickedPosition.getY() == 0){
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Rook(true));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.wrook);
                }else{
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Rook(false));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.brook);
                }
                break;
            case R.id.pawn_bishop :
                if(clickedPosition.getY() == 0){
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Bishop(true));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.wbishop);
                }else{
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Bishop(false));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.bbishop);
                }
                break;
            case R.id.pawn_knight :
                if(clickedPosition.getY() == 0){
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Knight(true));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.wknight);
                }else{
                    Board[clickedPosition.getX()][clickedPosition.getY()].setPiece(new Knight(false));
                    PieceDisplay[clickedPosition.getX()][clickedPosition.getY()].setBackgroundResource(R.drawable.bknight);

                }
                break;
        }
        promotion.setVisibility(View.INVISIBLE);
    }
    public void isCheckmate(){
        ArrayList<Coordinates> list=new ArrayList<>();
        Coordinates c;
        int x=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Board[i][j].getPiece()!=null&&Board[i][j].getPiece().isWhite()) {
                    list.clear();
                    c = new Coordinates(i, j);
                    list = gameMoves(Board[i][j].getPiece().AllowedMoves(c,Board), c);
                    if(!list.isEmpty())
                        x=1;
                }
            }
        }
        if(x==0){
            if(isChecked()==3){//tie
                game_over.setText("TIE, NO LEGAL MOVES FOR WHITE");
            }
            else{//black wins
                game_over.setText("CONGRATULATIONS BLACK WINS!!!");
            }
            game_over.setVisibility(View.VISIBLE);
            play_again.setVisibility(View.VISIBLE);
            return;
        }
        x=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Board[i][j].getPiece()!=null&&!Board[i][j].getPiece().isWhite()) {
                    list.clear();
                    c = new Coordinates(i, j);
                    list = gameMoves(Board[i][j].getPiece().AllowedMoves(c,Board), c);
                    if(!list.isEmpty())
                        x=2;
                }
            }
        }
        if(x==0){
            if(isChecked()==3){//tie
                game_over.setText("TIE, NO LEGAL MOVES FOR BLACK");
            }
            else{//white wins
                game_over.setText("CONGRATULATIONS WHITE WINS!!!");
            }
            game_over.setVisibility(View.VISIBLE);
            play_again.setVisibility(View.VISIBLE);
            return;
        }
    }

    public void playAgain(View view) {
        initializeBoard();
        game_over.setVisibility(View.INVISIBLE);
        play_again.setVisibility(View.INVISIBLE);
    }
}