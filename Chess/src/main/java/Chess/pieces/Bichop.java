package Chess.pieces;

import Chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;
import Chess.Color;

public class Bichop extends ChessPiece {

    public Bichop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];

        Position p = new Position(0,0);

        // NW
        p.setValues(position.getRow()-1,position.getColum()-1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum()-1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // NE

        p.setValues(position.getRow()-1,position.getColum()+1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum()+1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // Se

        p.setValues(position.getRow()+1,position.getColum()+1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum()+1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        // SW

        p.setValues(position.getRow()+1,position.getColum()-1);
        while (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum()-1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
