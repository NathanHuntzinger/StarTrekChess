import java.util.ArrayList;


//GameBoard dimensions: rows: 10, cols: 6, levels: 7
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
        board = new ArrayList<>();
        for(int r = 0; r <= 9; r++){
            board.add(new ArrayList<ArrayList<BoardPosition>>());
            for (int c = 0; c <= 5; c++){
                board.get(r).add(new ArrayList<BoardPosition>());
                for (int l = 0; l <= 6; l++){
                    board.get(r).get(c).add(new BoardPosition(r, c, l));
                }
            }
        }
        lowerBoard = new StaticBoard(1, 4, 1, 4, 1, board);
        middleBoard = new StaticBoard(3, 6, 1, 4, 3, board);
        upperBoard = new StaticBoard(5,8,1,4,5, board);

        lowerLeftBoard = new MovableBoard(0,1,0,1,2,board);
        lowerRightBoard = new MovableBoard(0,1,4,5,2, board);
        upperLeftBoard = new MovableBoard(8,9,0,1,6,board);
        upperRightBoard = new MovableBoard(8,9,4,5,6,board);

    }

    public boolean isValidPosition(int row, int col, int level){
        if (row >= 0 && row <= 9 && col >= 0 && col <= 5 && level >= 0 && level <= 6){ //check is the position is inside the game board boundaries
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

    public void printBoard(){
        System.out.println("---------------------------------------");
        upperLeftBoard.printBoard();
        upperRightBoard.printBoard();
        upperBoard.printBoard();
        middleBoard.printBoard();
        lowerBoard.printBoard();
        lowerLeftBoard.printBoard();
        lowerRightBoard.printBoard();
        System.out.println("---------------------------------------");
    }

    public void printVerbose(){
        System.out.println("----------------------------------------");

        for (int l = 6; l >= 0; l--){
            for(int r = 9; r >= 0; r--){
                for (int c = 0; c <= 5; c++){
                    if(board.get(r).get(c).get(l).getPiece() == null){
                        System.out.print(".");
                    }
                    else {
                        board.get(r).get(c).get(l).getPiece().print();
                    }
                }
                System.out.println();
            }
            System.out.println("----------");
        }
        System.out.println("----------------------------------------");
    }
}
