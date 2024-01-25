package XO;

class SelfGame extends Game {
    SelfPlayer playerX;
    SelfPlayer playerO;

    public SelfGame() {
        super();
        playerX = new SelfPlayer(PlayerType.X);
        playerO = new SelfPlayer(PlayerType.O);
        currentPlayer = playerX;
    }

    @Override
    public synchronized void playGame() {
        //
        while (!gameWon && !isBoardFull()) {
            currentPlayer.makeMove();
            printBoard();
            if (victoryChecker()) {
                announceWinner(currentPlayer.getPlayerType());
            } else {
                if(currentPlayer == playerX){ //change the current player
                    currentPlayer = playerO;
                }
                else {
                    currentPlayer = playerX;
                }
            }
        }

        if (!gameWon) {
            System.out.println("Board is full. It's a draw!");
        }
    }
}
