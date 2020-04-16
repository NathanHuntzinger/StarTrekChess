import java.io.Serializable;

public class MovableBoardMove implements Serializable {
    private MovableBoardPosition from;
    private MovableBoardPosition to;

    MovableBoardMove(MovableBoardPosition from, MovableBoardPosition to){
        this.from = from;
        this.to = to;
    }

    public MovableBoardPosition getFrom() {
        return from;
    }

    public MovableBoardPosition getTo() {
        return to;
    }
}
