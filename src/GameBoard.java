import java.util.ArrayList;

public class GameBoard {
    private ArrayList<ArrayList<ArrayList<BoardPosition>>> board;
    private StaticBoard lowerBoard;
    private StaticBoard middleBoard;
    private StaticBoard upperBoard;
    private MovableBoard lowerRightBoard;
    private MovableBoard lowerLeftBoard;
    private MovableBoard upperRightBoard;
    private MovableBoard upperLeftBoard;

    GameBoard (){

    }

    public BoardPosition getPosition(int row, int col, int level){
        return board.get(row).get(col).get(level);
    }

    public ArrayList<ArrayList<ArrayList<BoardPosition>>> getBoard() {
        return board;
    }

    public MovableBoard getLowerLeftBoard() {
        return lowerLeftBoard;
    }

    public MovableBoard getLowerRightBoard() {
        return lowerRightBoard;
    }

    public MovableBoard getUpperLeftBoard() {
        return upperLeftBoard;
    }

    public MovableBoard getUpperRightBoard() {
        return upperRightBoard;
    }

    public StaticBoard getLowerBoard() {
        return lowerBoard;
    }

    public StaticBoard getMiddleBoard() {
        return middleBoard;
    }

    public StaticBoard getUpperBoard() {
        return upperBoard;
    }
}
