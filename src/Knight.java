import java.util.ArrayList;

public class Knight extends Piece{
    Knight(BoardPosition position, Player player, GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.position = position;
        this.player = player;
        this.dead = false;
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

    ArrayList<BoardPosition> getMoves() {
        if(this.dead){
            return new ArrayList<>();
        }
        ArrayList<BoardPosition> moves = new ArrayList<>();
        for(int iteratorBy1 = -1; iteratorBy1 <= 1; iteratorBy1 += 2){
            for(int iteratorBy2 = -2; iteratorBy2 <= 2; iteratorBy2 += 4){
                for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + iteratorBy1, this.getCol() + iteratorBy2, this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + iteratorBy1, this.getCol() + iteratorBy2, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + iteratorBy1, this.getCol() + iteratorBy2, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){
                        moves.add(getGameBoard().getPosition(this.getRow() + iteratorBy1, this.getCol() + iteratorBy2, this.getLevel() + l));
                    }
                    if(getGameBoard().isValidPosition(this.getRow() + iteratorBy2, this.getCol() + iteratorBy1, this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + iteratorBy2, this.getCol() + iteratorBy1, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + iteratorBy2, this.getCol() + iteratorBy1, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){
                        moves.add(getGameBoard().getPosition(this.getRow() + iteratorBy2, this.getCol() + iteratorBy1, this.getLevel() + l));

                    }
                }
            }
        }
        return moves;
    }
}
