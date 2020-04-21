import java.io.Serializable;

public class MovableBoardMove implements Serializable {
    private int fromID;
    private int toID;
//    private int fromRow;
//    private int fromCol;
//    private int fromLevel;
//    private int toRow;
//    private int toCol;
//    private int toLevel;

    MovableBoardMove(MovableBoardPosition from, MovableBoardPosition to){
            this.fromID = from.getId();
            this.toID = to.getId();
//        this.fromRow = from.getRow();
//        this.fromCol = from.getCol();
//        this.fromLevel = from.getLevel();
//
//        this.toRow = to.getRow();
//        this.toCol = to.getCol();
//        this.toLevel = to.getLevel();
    }

    public int getFromID() {
        return fromID;
    }

    public int getToID() {
        return toID;
    }
    //    public int getFromRow() {
//        return fromRow;
//    }
//
//    public int getFromCol() {
//        return fromCol;
//    }
//
//    public int getFromLevel() {
//        return fromLevel;
//    }
//
//    public int getToRow() {
//        return toRow;
//    }
//
//    public int getToCol() {
//        return toCol;
//    }
//
//    public int getToLevel() {
//        return toLevel;
//    }
}
