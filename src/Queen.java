import java.util.ArrayList;

public class Queen extends Piece{
    ArrayList<BoardPosition> moves;

    Queen(BoardPosition position, Player player, GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.position = position;
        this.player = player;
        this.moves = new ArrayList<>();
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

    ArrayList<BoardPosition> getMoves() {
        for(int r = -1; r <= 1; r++){
            for(int c = -1; c <= 1; c++){
                for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){

                        moves.add(getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l));
                        getMovesRecursive(r,c,l);
                    }
                }
            }
        }
        return this.moves;
    }

    void getMovesRecursive(int offsetR, int offsetC, int offsetL){
        for(int r = -1; r <= 1; r++){
            for(int c = -1; c <= 1; c++){
                for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + r + offsetR, this.getCol() + c + offsetC, this.getLevel() + l + offsetL)
                            && (getGameBoard().getPosition(this.getRow() + r + offsetR, this.getCol() + c + offsetC, this.getLevel() + l + offsetL).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + r + offsetR, this.getCol() + c + offsetC, this.getLevel() + l + offsetL).getPiece().getPlayer() != this.getPlayer())){
                        if(!moves.contains(getGameBoard().getPosition(this.getRow() + r + offsetR, this.getCol() + c + offsetC, this.getLevel() + l + offsetL))) {
                            moves.add(getGameBoard().getPosition(this.getRow() + r + offsetR, this.getCol() + c + offsetC, this.getLevel() + l + offsetL));
                            getMovesRecursive(r + offsetR, c + offsetC, l + offsetL);
                        }
                    }
                }
            }
        }
    }
}
