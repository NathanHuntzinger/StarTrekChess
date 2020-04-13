public class Bishop extends Piece{
    Bishop(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        System.out.print("B");
    }
}
