package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException
                    ("Error creating Board: There must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRow() {
        return rows;
    }

    public int getColum() {
        return columns;
    }

    public Piece piece(int row, int colum){
        if (!positionExists(row,colum)){
            throw new BoardException("Position not on the floor");
        }
        return pieces[row][colum];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the floor");
        }
        return pieces[position.getRow()][position.getColum()];
    }

    public void placePiece(Piece piece,Position position){
        if (threIsAPiece(position)){
            throw new BoardException("There is already a piece on position "+position);
        }
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }
    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the floor");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColum()] = null;
        return aux;
    }



    private boolean positionExists(int row,int colum){
        return row >= 0 && row < rows && colum >=0 && colum < columns;
    }

    public boolean positionExists(Position position){
     return positionExists(position.getRow(),position.getColum());
    }

    public boolean threIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the floor");
        }
        return piece(position) != null;
    }

}
