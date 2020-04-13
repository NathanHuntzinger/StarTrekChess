public class BoardPosition {
    private Piece piece;
    private int row;
    private int col;
    private int level;
    private boolean validSpace;

    BoardPosition(){

    }

    public Piece getPiece() {
        return piece;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getLevel() {
        return level;
    }

    public boolean isValidSpace(){
        return validSpace;
    }
}
