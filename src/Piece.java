import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Serializable {
    protected Player player;
    protected GameBoard gameBoard;
    protected BoardPosition position;
    protected boolean dead;

    Piece(){
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
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

    public BoardPosition getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }

    public void print() {
    }
}
