import java.util.ArrayList;

public class Piece {
    protected Player player;
    protected GameBoard gameBoard;
    protected Board board;
    protected BoardPosition position;

    Piece(){

    }

    public int getRow(){
        return this.getPosition().getRow();
    }

    public int getCol(){
        return this.getPosition().getCol();
    }

    public int getLevel(){
        return this.getPosition().getLevel();
    }

    ArrayList<BoardPosition> getMoves(){
        return null; //change this
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Board getBoard() {
        return board;
    }

    public BoardPosition getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void print() {
    }
}
