import java.io.Serializable;
import java.util.ArrayList;

public class StaticBoard implements Serializable {
    private ArrayList<ArrayList<BoardPosition>> board;
    private int level;

    StaticBoard(int rowmin, int rowmax, int colmin, int colmax, int level, ArrayList<ArrayList<ArrayList<BoardPosition>>> positions){
        board = new ArrayList<>();

        for(int r = 0; r <= rowmax - rowmin; r++){
            board.add(new ArrayList<BoardPosition>());
            for(int c = 0; c <= colmax - colmin; c++){
                board.get(r).add(positions.get(r + rowmin).get(c + colmin).get(level));
                positions.get(r + rowmin).get(c + colmin).get(level).setValidSpace(true);
            }
        }

        this.level = level;
    }

    public ArrayList<ArrayList<BoardPosition>> getBoard() {
        return board;
    }

    public int getLevel() {
        return level;
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
    }
}
