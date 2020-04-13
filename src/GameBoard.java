import java.util.ArrayList;


//GameBoard dimentions: rows: 10, cols: 6, levels: 7
public class GameBoard {
    private ArrayList<ArrayList<ArrayList<BoardPosition>>> board;
    private StaticBoard lowerBoard;
    private StaticBoard middleBoard;
    private StaticBoard upperBoard;

    //assuming that the lower end of the board is "down", may need to rename the boards.

    private MovableBoard lowerRightBoard;
    private MovableBoard lowerLeftBoard;
    private MovableBoard upperRightBoard;
    private MovableBoard upperLeftBoard;

    GameBoard (){
        for(int r = 1; r <= 10; r++){
            board.add(new ArrayList<ArrayList<BoardPosition>>());
            for (int c = 1; c <= 6; c++){
                board.get(r).add(new ArrayList<BoardPosition>());
                for (int l = 1; l <= 7; l++){
                    board.get(r).get(c).add(new BoardPosition(r, c, l));
                }
            }
        }
        lowerBoard = new StaticBoard(2, 5, 2, 5, 2, board);
        middleBoard = new StaticBoard(4, 7, 2, 5, 4, board);
        upperBoard = new StaticBoard(6,9,2,5,6, board);

        lowerLeftBoard = new MovableBoard(1,2,1,2,3,board);
        lowerRightBoard = new MovableBoard(1,2,5,6,3, board);
        upperLeftBoard = new MovableBoard(9,10,1,2,7,board);
        upperRightBoard = new MovableBoard(9,10,5,6,7,board);

    }

    public boolean isValidPosition(int row, int col, int level){
        if (row >= 1 && row <= 10 && col >= 1 && col <= 6 && level >= 1 && level <= 7){ //check is the position is inside the game board boundaries
            return this.getPosition(row, col, level).isValidSpace();
        }
        return false;
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
