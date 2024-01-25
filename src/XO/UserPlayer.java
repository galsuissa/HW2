package XO;

import java.util.Scanner;
class UserPlayer extends Player {
    private Game game;
    private Scanner scanner;

    public UserPlayer(PlayerType playerType) {
        super(playerType);
        scanner = new Scanner(System.in);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void makeMove() {
        while (game.getTurn() == playerType && !game.isBoardFull()) {
            System.out.println("Enter row (0-4): ");
            int row = scanner.nextInt();
            System.out.println("Enter column (0-4): ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                game.gameBoard[row][col] = (playerType == PlayerType.X) ? 'X' : 'O';
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5 && game.gameBoard[row][col] == '-';
    }
}
