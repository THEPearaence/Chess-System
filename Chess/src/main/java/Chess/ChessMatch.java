package Chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
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

}
