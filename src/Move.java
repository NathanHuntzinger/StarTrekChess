public class Move {
    private BoardPosition from;
    private BoardPosition to;

    Move(BoardPosition from, BoardPosition to){
        this.from = from;
        this.to = to;
    }

    public BoardPosition getFrom() {
        return from;
    }

    public BoardPosition getTo() {
        return to;
    }
}
