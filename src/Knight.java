public class Knight extends Piece{
    Knight(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("N");
        }
        else{
            System.out.print("n");
        }
    }
}
