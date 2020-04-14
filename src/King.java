public class King extends Piece{
    King(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("K");
        }
        else{
            System.out.print("k");
        }
    }

}
