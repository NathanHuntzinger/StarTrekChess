import java.io.Serializable;
import java.util.ArrayList;

public class MovableBoard implements Serializable {
    private ArrayList<ArrayList<BoardPosition>> board;
    private int level;
    private MovableBoardPosition position;

    MovableBoard( int level, MovableBoardPosition movableBoardPosition){
        this.board = movableBoardPosition.getBoardSection();
        for (int i = 0; i < this.board.size(); i++){
            for (int j = 0; j < this.board.get(i).size(); j++){
                this.board.get(i).get(j).setValidSpace(true);
            }
        }

        this.position = movableBoardPosition;
        this.level = level;
        position.setMovableBoard(this);
    }

    public ArrayList<ArrayList<BoardPosition>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<BoardPosition>> board) {
        this.board = board;
    }

    public void setPosition(MovableBoardPosition position) {
        this.position = position;
    }

    public int getLevel() {
        return level;
    }

    public MovableBoardPosition getPosition() {
        return position;
    }

    public void printBoard(){
        System.out.print("Positions: ");
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                System.out.print(board.get(i).get(j).toString() + "; ");
            }
        }
        System.out.println();
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                if(board.get(i).get(j).getPiece() == null) {
                    System.out.print(".");
                }
                else{
                    board.get(i).get(j).getPiece().print();
                }
            }
            System.out.println();
        }
        System.out.println();
//        printVerbose();
    }

    public void printVerbose(){
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                if(board.get(i).get(j).getPiece() == null) {
                    System.out.print(".");
                    System.out.print(": " + board.get(i).get(j).toString() + "; ");
                }
                else{
                    board.get(i).get(j).getPiece().print();
                    System.out.print(": " + board.get(i).get(j).toString() + "; ");
                }
                System.out.println();
            }
        }
    }
}
