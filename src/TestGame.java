public class TestGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.getGameBoard().printBoard();
        game.getPlayer1().print();
        game.getPlayer2().print();

//        game.getGameBoard().printVerbose();
    }
}
