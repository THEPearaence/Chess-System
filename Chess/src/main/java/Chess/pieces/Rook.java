package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;



public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }



    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];

        Position p = new Position(0,0);

        // above
        p.setValues(position.getRow()-1,position.getColum());
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // Left

        p.setValues(position.getRow(),position.getColum()-1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // Right

        p.setValues(position.getRow(),position.getColum()+1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // Below

        p.setValues(position.getRow()+1,position.getColum());
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
