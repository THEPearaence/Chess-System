package boardgame;

public class Board {

    private int row;
    private int colum;
    private Piece[][] pieces;

    public Board(int row, int colum) {
        this.row = row;
        this.colum = colum;
        pieces = new Piece[row][colum];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public Piece piece(int row, int colum){
        return pieces[row][colum];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColum()];
    }

    public void placePiece(Piece piece,Position position){
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }
}
