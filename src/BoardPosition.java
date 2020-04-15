public class BoardPosition {
    private Piece piece;
    private int row;
    private int col;
    private int level;
    private boolean validSpace;

    BoardPosition(){}

    BoardPosition(int row, int col, int level){
        this.row = row;
        this.col = col;
        this.level = level;
        piece = null;
        validSpace = false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setValidSpace(boolean validSpace) {
        this.validSpace = validSpace;
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

    public String toString(){
        return "(" + row + ", " + col + ", " + level + ")";
    }
}
