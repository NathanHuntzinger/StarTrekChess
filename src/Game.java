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
        if(move.getTo().getPiece() != null){
            move.getTo().getPiece().setPosition(null);
        }
        move.getFrom().getPiece().setPosition(move.getTo());
        move.getTo().setPiece(move.getFrom().getPiece());
        move.getFrom().setPiece(null);
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
