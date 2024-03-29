package Chess.pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;


public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color,ChessMatch chessMatch) {

        super(board, color);
        this.chessMatch = chessMatch;
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];

        Position p = new Position(0,0);

        if (getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
                mat[p.getRow()][p.getColum()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColum());
            Position p2 = new Position(position.getRow() - 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().threIsAPiece(p) && getBoard().positionExists(p2)
                    && !getBoard().threIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColum()] = true;
            }
                p.setValues(position.getRow() - 1, position.getColum()-1);
                if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                    mat[p.getRow()][p.getColum()] = true;
                }
                    p.setValues(position.getRow() - 1, position.getColum() + 1);
                    if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                        mat[p.getRow()][p.getColum()] = true;
                    }


                //Specialmove en passante white
                if (position.getRow() == 3){
                    Position left = new Position(position.getRow(),position.getColum()-1);
                    if (getBoard().positionExists(left)&& isThereOpponentPiece(left)
                            && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                        mat[left.getRow()-1][left.getColum()] = true;
                    }
                    Position right = new Position(position.getRow(),position.getColum()+1);
                    if (getBoard().positionExists(right)&& isThereOpponentPiece(right)
                            && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                        mat[right.getRow()-1][right.getColum()] = true;
                    }
                }

            }

        else {
            p.setValues(position.getRow() + 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().threIsAPiece(p)){
                mat[p.getRow()][p.getColum()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColum());
            Position p2 = new Position(position.getRow() + 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().threIsAPiece(p) && getBoard().positionExists(p2)
                    && !getBoard().threIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColum()] = true;
            }

                p.setValues(position.getRow() + 1, position.getColum() - 1);
                if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                    mat[p.getRow()][p.getColum()] = true;
                }

                    p.setValues(position.getRow() + 1, position.getColum() + 1);
                    if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                        mat[p.getRow()][p.getColum()] = true;
                    }





            //Specialmove en passante black
            if (position.getRow() == 4){
                Position left = new Position(position.getRow(),position.getColum()-1);
                if (getBoard().positionExists(left)&& isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()+1][left.getColum()] = true;
                }
                Position right = new Position(position.getRow(),position.getColum()+1);
                if (getBoard().positionExists(right)&& isThereOpponentPiece(right) &&
                        getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[right.getRow()+1][right.getColum()] = true;
                }
            }
        }
        return mat;
    }
    @Override
    public String toString(){
        return "P";
    }
}

