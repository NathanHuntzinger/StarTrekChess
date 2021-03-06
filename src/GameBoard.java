import java.io.Serializable;
import java.util.ArrayList;


//GameBoard dimensions: rows: 10, cols: 6, levels: 7
public class GameBoard implements Serializable {
    private ArrayList<ArrayList<ArrayList<BoardPosition>>> board;
    private StaticBoard lowerBoard;
    private StaticBoard middleBoard;
    private StaticBoard upperBoard;

    //assuming that the lower end of the board is "down", may need to rename the boards.

    private MovableBoard lowerRightBoard;
    private MovableBoard lowerLeftBoard;
    private MovableBoard upperRightBoard;
    private MovableBoard upperLeftBoard;

    private ArrayList<MovableBoardPosition> movableBoardPositions; //There are 24 of these positions

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

        movableBoardPositions = new ArrayList<>();

        movableBoardPositions.add(new MovableBoardPosition(0,1,0,1,0,board, 0)); //0
        movableBoardPositions.add(new MovableBoardPosition(0,1,4,5,0,board, 1)); //1
        movableBoardPositions.add(new MovableBoardPosition(4,5,0,1,0,board, 2)); //2
        movableBoardPositions.add(new MovableBoardPosition(4,5,4,5,0,board, 3)); //3

        movableBoardPositions.add(new MovableBoardPosition(0,1,0,1,2,board, 4)); //4 --starting pos
        movableBoardPositions.add(new MovableBoardPosition(0,1,4,5,2,board, 5)); //5 --starting pos
        movableBoardPositions.add(new MovableBoardPosition(4,5,0,1,2,board, 6)); //6
        movableBoardPositions.add(new MovableBoardPosition(4,5,4,5,2,board, 7)); //7

        movableBoardPositions.add(new MovableBoardPosition(2,3,0,1,2,board, 8)); //8
        movableBoardPositions.add(new MovableBoardPosition(2,3,4,5,2,board, 9)); //9
        movableBoardPositions.add(new MovableBoardPosition(6,7,0,1,2,board, 10)); //10
        movableBoardPositions.add(new MovableBoardPosition(6,7,4,5,2,board, 11)); //11

        movableBoardPositions.add(new MovableBoardPosition(2,3,0,1,4,board, 12)); //12
        movableBoardPositions.add(new MovableBoardPosition(2,3,4,5,4,board, 13)); //13
        movableBoardPositions.add(new MovableBoardPosition(6,7,0,1,4,board, 14)); //14
        movableBoardPositions.add(new MovableBoardPosition(6,7,4,5,4,board, 15)); //15

        movableBoardPositions.add(new MovableBoardPosition(4,5,0,1,4,board, 16)); //16
        movableBoardPositions.add(new MovableBoardPosition(4,5,4,5,4,board, 17)); //17
        movableBoardPositions.add(new MovableBoardPosition(8,9,0,1,4,board, 18)); //18
        movableBoardPositions.add(new MovableBoardPosition(8,9,4,5,4,board, 19)); //19

        movableBoardPositions.add(new MovableBoardPosition(4,5,0,1,6,board, 20)); //20
        movableBoardPositions.add(new MovableBoardPosition(4,5,4,5,6,board, 21)); //21
        movableBoardPositions.add(new MovableBoardPosition(8,9,0,1,6,board, 22)); //22 --starting pos
        movableBoardPositions.add(new MovableBoardPosition(8,9,4,5,6,board, 23)); //23 --starting pos


        lowerLeftBoard = new MovableBoard(2,movableBoardPositions.get(4), this);
        lowerRightBoard = new MovableBoard(2,movableBoardPositions.get(5), this);
        upperLeftBoard = new MovableBoard(6,movableBoardPositions.get(22), this);
        upperRightBoard = new MovableBoard(6,movableBoardPositions.get(23), this);


    }

    public boolean isValidPosition(int row, int col, int level){
        if (row >= 0 && row <= 9 && col >= 0 && col <= 5 && level >= 0 && level <= 6){ //check is the position is inside the game board boundaries
            return this.getPosition(row, col, level).isValidSpace();
        }
        return false;
    }

    public boolean isInsideBoard(int row, int col, int level){
        if (row >= 0 && row <= 9 && col >= 0 && col <= 5 && level >= 0 && level <= 6){ //check is the position is inside the game board boundaries
            return true;
        }
        return false;
    }

    public BoardPosition getPosition(int row, int col, int level){
        return board.get(row).get(col).get(level);
    }

    public MovableBoardPosition getBoardPosition(int id){
        return movableBoardPositions.get(id);
    }

    public ArrayList<ArrayList<ArrayList<BoardPosition>>> getBoard() {
        return board;
    }

    public ArrayList<MovableBoardPosition> getMovableBoardPositions() {
        return movableBoardPositions;
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
                        if(board.get(r).get(c).get(l).isValidSpace())
                            System.out.print(".");
                        else
                            System.out.print("X");
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
