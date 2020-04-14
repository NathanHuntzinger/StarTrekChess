public class Queen extends Piece{
    Queen(BoardPosition position, Player player){
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("Q");
        }
        else{
            System.out.print("q");
        }
    }
}
