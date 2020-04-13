import java.util.ArrayList;

public class StaticBoard extends Board{
    private ArrayList<ArrayList<BoardPosition>> board;
    private int level;

    StaticBoard(int rowmin, int rowmax, int colmin, int colmax, int level, ArrayList<ArrayList<ArrayList<BoardPosition>>> positions){
        for(int r = rowmin; r <= rowmax; r++){
            board.add(new ArrayList<BoardPosition>());
            for(int c = colmin; c <= colmax; c++){
                board.get(r).add(positions.get(r).get(c).get(level));
                positions.get(r).get(c).get(level).setValidSpace(true);
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
}
