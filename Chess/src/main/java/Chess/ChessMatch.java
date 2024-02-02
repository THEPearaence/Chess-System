package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Position;

import java.awt.*;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] GETpieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColum()];
        for (int i = 0;i< board.getRow();i++){
            for (int j=0;j< board.getColum();j++){
                mat[i][j] =(ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
        board.placePiece(new King(board,Color.black),new Position(0,4));
        board.placePiece(new King(board,Color.white),new Position(7,4));
    }

}
