public class King extends Piece{
    King(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        System.out.print("K");
    }

}
