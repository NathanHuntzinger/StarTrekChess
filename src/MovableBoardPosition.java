import java.io.Serializable;
import java.util.ArrayList;

public class MovableBoardPosition implements Serializable {
    private ArrayList<ArrayList<BoardPosition>> boardSection;
    private MovableBoard movableBoard;
    private int level;
    private int col;
    private int row;
    private int id;

    MovableBoardPosition(){}

    MovableBoardPosition(int rowmin, int rowmax, int colmin, int colmax, int level, ArrayList<ArrayList<ArrayList<BoardPosition>>> positions, int id){
        this.id = id;
        boardSection = new ArrayList<>();
        this.level = level;
        this.col = colmin;
        this.row = rowmin;

        for(int r = 0; r <= rowmax - rowmin; r++){
            boardSection.add(new ArrayList<BoardPosition>());
            for(int c = 0; c <= colmax - colmin; c++){
                boardSection.get(r).add(positions.get(r + rowmin).get(c + colmin).get(level));
            }
        }
        this.movableBoard = null;
    }

    public MovableBoard getMovableBoard() {
        return movableBoard;
    }

    public ArrayList<ArrayList<BoardPosition>> getBoardSection() {
        return boardSection;
    }

    public void setMovableBoard(MovableBoard movableBoard) {
        this.movableBoard = movableBoard;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovableBoardPosition{" +
                "boardSection=" + boardSection +
                ", movableBoard=" + movableBoard +
                '}';
    }
}
