package Chess.pieces;

import Chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;
import Chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "N";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];

        Position p = new Position(0,0);

        p.setValues(position.getRow()-1, position.getColum()-2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()-2, position.getColum()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()-2, position.getColum()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()-1, position.getColum()+2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()+1, position.getColum()+2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()+2, position.getColum()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()+2, position.getColum()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        p.setValues(position.getRow()+1, position.getColum()-2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
