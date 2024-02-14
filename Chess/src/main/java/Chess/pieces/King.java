package Chess.pieces;

import Chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;

import java.awt.*;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];

        Position p = new Position(0,0);

        //above

        p.setValues(position.getRow()-1, position.getColum());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //below
        p.setValues(position.getRow()+1, position.getColum());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColum()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColum()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //NW
        p.setValues(position.getRow()-1, position.getColum()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //NE
        p.setValues(position.getRow()-1, position.getColum()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //SW
        p.setValues(position.getRow()+1, position.getColum()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //SE
        p.setValues(position.getRow()+1, position.getColum()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
