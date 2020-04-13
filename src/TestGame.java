public class TestGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.getGameBoard().printBoard();
        game.getPlayer1().print();
        game.getPlayer2().print();

        Move myMove = new Move(game.getPlayer1().getPieces().get(0).getPosition(), game.getGameBoard().getPosition(5,3,5));
        game.executeMove(myMove);

        game.getGameBoard().printBoard();

//        game.getGameBoard().printVerbose();
    }
}
