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
        this.moves = new ArrayList<>();
        for(int iterator1 = -1; iterator1 <= 1; iterator1 ++){
            for(int iterator2 = -1; iterator2 <= 1; iterator2++) {
                for (int l = -1; l <= 1; l++) {
                    if (getGameBoard().isValidPosition(this.getRow() + iterator1, this.getCol() + iterator2, this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + iterator1, this.getCol() + iterator2, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + iterator1, this.getCol() + iterator2, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())) {

                        getMovesRecursive(this.getRow() + iterator1, this.getCol() + iterator2, this.getLevel() + l, iterator1,  iterator2);
                    }
                }
            }
        }

        return this.moves;
    }

    void getMovesRecursive(int row, int col, int level, int rowDirection, int colDirection){
        for(int l = -1; l <= 1; l++) {
            if(getGameBoard().isValidPosition(row, col, level + l)
                    && (getGameBoard().getPosition(row, col, level + l).getPiece() == null
                    || getGameBoard().getPosition(row, col, level + l).getPiece().getPlayer() != this.getPlayer())){

                moves.add(getGameBoard().getPosition(row, col, level + l));
                if(getGameBoard().getPosition(row, col, level + l).getPiece() == null) {
                    getMovesRecursive(row + rowDirection, col + colDirection, level + l, rowDirection, colDirection);
                }
            }
        }

    }
}
