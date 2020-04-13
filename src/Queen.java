public class Queen extends Piece{
    Queen(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        System.out.print("Q");
    }
}
