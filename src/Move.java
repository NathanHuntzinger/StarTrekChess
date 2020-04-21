import java.io.Serializable;

public class Move implements Serializable {
    private int fromRow;
    private int fromCol;
    private int fromLevel;
    private int toRow;
    private int toCol;
    private int toLevel;

    Move(BoardPosition from, BoardPosition to){
        this.fromRow = from.getRow();
        this.fromCol = from.getCol();
        this.fromLevel = from.getLevel();

        this.toRow = to.getRow();
        this.toCol = to.getCol();
        this.toLevel = to.getLevel();
    }

    public int getFromRow() {
        return fromRow;
    }

    public int getFromCol() {
        return fromCol;
    }

    public int getFromLevel() {
        return fromLevel;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToCol() {
        return toCol;
    }

    public int getToLevel() {
        return toLevel;
    }
}
