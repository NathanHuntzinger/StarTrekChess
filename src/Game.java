import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;

    Game(){
        this.gameBoard = new GameBoard();
        this.player1 = new Player(gameBoard, 1);
        this.player2 = new Player(gameBoard, 2);
        this.player1.setOpponent(this.player2);
        this.player2.setOpponent(this.player1);
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
        MovableBoardPosition from = gameBoard.getBoardPosition(move.getFromID());
        MovableBoardPosition to = gameBoard.getBoardPosition(move.getToID());
        for (int r = 1; r >= 0; r --){
            for (int c = 0; c <= 1; c++){
                if(from.getBoardSection().get(r).get(c).getPiece() != null) {
                    from.getBoardSection().get(r).get(c).getPiece().setPosition(to.getBoardSection().get(r).get(c));
                }
                to.getBoardSection().get(r).get(c).setPiece(from.getBoardSection().get(r).get(c).getPiece());
                to.getBoardSection().get(r).get(c).setValidSpace(true);
                from.getBoardSection().get(r).get(c).setPiece(null);
                from.getBoardSection().get(r).get(c).setValidSpace(false);
            }
        }
        from.getMovableBoard().setBoard(to.getBoardSection());
        to.setMovableBoard(from.getMovableBoard());
        from.getMovableBoard().setPosition(to);
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
