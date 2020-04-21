import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;

    Game(){
        this.gameBoard = new GameBoard();
        this.player1 = new Player(gameBoard, 1);
        this.player2 = new Player(gameBoard, 2);
    }

    public void executeMove (Move move){
        BoardPosition from = gameBoard.getPosition(move.getFromRow(), move.getFromCol(), move.getFromLevel());
        BoardPosition to = gameBoard.getPosition(move.getToRow(), move.getToCol(), move.getToLevel());
        if(to.getPiece() != null){
            to.getPiece().setPosition(null);
        }
        from.getPiece().setPosition(to);
        to.setPiece(from.getPiece());
        from.setPiece(null);
    }

    public void executeMovableBoardMove(MovableBoardMove move){
        for (int r = 1; r >= 0; r --){
            for (int c = 0; c <= 1; c++){
                if(move.getFrom().getBoardSection().get(r).get(c).getPiece() != null) {
                    move.getFrom().getBoardSection().get(r).get(c).getPiece().setPosition(move.getTo().getBoardSection().get(r).get(c));
                }
                move.getTo().getBoardSection().get(r).get(c).setPiece(move.getFrom().getBoardSection().get(r).get(c).getPiece());
                move.getTo().getBoardSection().get(r).get(c).setValidSpace(true);
                move.getFrom().getBoardSection().get(r).get(c).setPiece(null);
                move.getFrom().getBoardSection().get(r).get(c).setValidSpace(false);
            }
        }
        move.getFrom().getMovableBoard().setBoard(move.getTo().getBoardSection());
        move.getTo().setMovableBoard(move.getFrom().getMovableBoard());
        move.getFrom().getMovableBoard().setPosition(move.getTo());
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
