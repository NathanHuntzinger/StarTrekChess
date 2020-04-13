public class Knight extends Piece{
    Knight(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        System.out.print("N");
    }
}
