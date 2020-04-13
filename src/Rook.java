public class Rook extends Piece{
    Rook(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        System.out.print("R");
    }
}
