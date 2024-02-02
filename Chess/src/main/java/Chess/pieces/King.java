package Chess.pieces;

import Chess.ChessPiece;
import boardgame.Board;

import java.awt.*;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }
}
