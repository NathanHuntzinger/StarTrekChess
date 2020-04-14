public class Rook extends Piece{
    Rook(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("R");
        }
        else{
            System.out.print("r");
        }
    }
}
