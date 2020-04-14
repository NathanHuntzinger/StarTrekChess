import java.util.ArrayList;

public class MovableBoardMove {
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
