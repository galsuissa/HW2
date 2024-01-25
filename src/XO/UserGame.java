package XO;

class UserGame extends Game {
    SelfPlayer selfPlayer;
    UserPlayer userPlayer;

    public UserGame() {
        super();
        selfPlayer = new SelfPlayer(PlayerType.X);
        userPlayer = new UserPlayer(PlayerType.O);
        currentPlayer = selfPlayer;
    }

    @Override
    public void playGame() {
        while (!gameWon && !isBoardFull()) {
            currentPlayer.makeMove();
            printBoard();
            if (victoryChecker()) {
                announceWinner(currentPlayer.getPlayerType());
            } else {
                currentPlayer = (currentPlayer == selfPlayer) ? userPlayer : selfPlayer;
            }
        }

        if (!gameWon) {
            System.out.println("Board is full. It's a draw!");
        }
    }
}