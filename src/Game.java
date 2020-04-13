public class Game {
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;

    Game(){
        gameBoard = new GameBoard();
        player1 = new Player(1);
        player2 = new Player(2);
    }

    public void executeMove (Move move){

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
