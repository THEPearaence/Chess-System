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

    private void plceNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }

    private void initialSetup(){
        plceNewPiece('b',6, new Rook(board, Color.WHITE));
        plceNewPiece('e',8,new King(board,Color.black));
        plceNewPiece('e',1,new King(board,Color.white));
    }

}
