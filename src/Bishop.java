public class Bishop extends Piece{
    Bishop(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("B");
        }
        else{
            System.out.print("b");
        }
    }
}
