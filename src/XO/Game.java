package XO;
import java.util.ArrayList;
import java.util.List;

abstract class Game {
    protected char[][] gameBoard;
    protected Player currentPlayer;
    protected boolean gameWon;

    public Game() {
        gameBoard = new char[5][5];
        initializeBoard();
        gameWon = false;
    }

    public abstract void playGame();

    protected void initializeBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    protected void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected PlayerType getTurn() {
        return currentPlayer.getPlayerType();
    }

    protected List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '-') {
                    freeCells.add(new Cell(i, j));
                }
            }
        }
        return freeCells;
    }

    protected boolean isBoardFull() { //method check if the board is fully
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean victoryChecker() {
        //Checking rows, if there are at least 4 X or O in a row
        for(int row = 0; row<5;row++){
            if((gameBoard[row][0]=='X'&& gameBoard[row][1]=='X'&& gameBoard[row][2]=='X'&& gameBoard[row][3]=='X')
                    ||(gameBoard[row][0]=='O'&& gameBoard[row][1]=='O'&& gameBoard[row][2]=='O'&& gameBoard[row][3]=='O')){
                return true;
            }
            else if ((gameBoard[row][1]=='X'&& gameBoard[row][2]=='X'&& gameBoard[row][3]=='X' && gameBoard[row][4]=='X')||
                    gameBoard[row][1]=='O'&& gameBoard[row][2]=='O'&& gameBoard[row][3]=='O' && gameBoard[row][4]=='O'){
                return true;
            }
        }
        //Checking columns, if there are at least 4 X or O in a column
        for(int col = 0; col<5;col++){
            if((gameBoard[0][col]=='X'&& gameBoard[1][col]=='X'&& gameBoard[2][col]=='X'&& gameBoard[3][col]=='X')||
                    (gameBoard[0][col]=='O'&& gameBoard[1][col]=='O'&& gameBoard[2][col]=='O'&& gameBoard[3][col]=='O')){
                return true;
            }
            else if ((gameBoard[1][col]=='X'&& gameBoard[2][col]=='X'&& gameBoard[3][col]=='X' && gameBoard[4][col]=='X')||
                    (gameBoard[1][col]=='O'&& gameBoard[2][col]=='O'&& gameBoard[3][col]=='O' && gameBoard[4][col]=='O')){
                return true;
            }
        }
        //Checking diagonals, if there are at least 4 X or O in a diagonal line.
        if((gameBoard[0][0]=='X'&& gameBoard[1][1]=='X'&& gameBoard[2][2]=='X'&& gameBoard[3][3]=='X')||
                (gameBoard[0][0]=='O'&& gameBoard[1][1]=='O'&& gameBoard[2][2]=='O'&& gameBoard[3][3]=='O')){
            return true;
        }
        else if ((gameBoard[1][1]=='X'&& gameBoard[2][2]=='X'&& gameBoard[3][3]=='X' && gameBoard[4][4]=='X')||
                (gameBoard[1][1]=='O'&& gameBoard[2][2]=='O'&& gameBoard[3][3]=='O' && gameBoard[4][4]=='O')){
            return true;
        }
        else if((gameBoard[0][4]=='X'&& gameBoard[1][3]=='X'&& gameBoard[2][2]=='X'&& gameBoard[3][1]=='X')||
                (gameBoard[0][4]=='O'&& gameBoard[1][3]=='O'&& gameBoard[2][2]=='O'&& gameBoard[3][1]=='O'))
            return true;
        else if((gameBoard[1][3]=='X'&& gameBoard[2][2]=='X'&& gameBoard[3][1]=='X' && gameBoard[4][0]=='X')||
                (gameBoard[1][3]=='O'&& gameBoard[2][2]=='O'&& gameBoard[3][1]=='O' && gameBoard[4][0]=='O'))
            return true;
        else if ((gameBoard[0][1]=='X'&& gameBoard[1][2]=='X'&& gameBoard[2][3]=='X'&& gameBoard[3][4]=='X')||
                (gameBoard[0][1]=='O'&& gameBoard[1][2]=='O'&& gameBoard[2][3]=='O'&& gameBoard[3][4]=='O'))
            return true;
        else if((gameBoard[1][0]=='X'&& gameBoard[2][1]=='X'&& gameBoard[3][2]=='X'&& gameBoard[4][3]=='X')||
                (gameBoard[1][0]=='O'&& gameBoard[2][1]=='O'&& gameBoard[3][2]=='O'&& gameBoard[4][3]=='O'))
            return true;
        else if ((gameBoard[0][3]=='X'&& gameBoard[1][2]=='X'&& gameBoard[2][1]=='X'&& gameBoard[3][0]=='X')||
                (gameBoard[0][3]=='O'&& gameBoard[1][2]=='O'&& gameBoard[2][1]=='O'&& gameBoard[3][0]=='O'))
            return true;
        else if((gameBoard[1][4]=='X'&& gameBoard[2][3]=='X'&& gameBoard[3][2]=='X'&& gameBoard[4][1]=='X')||
                (gameBoard[1][4]=='O'&& gameBoard[2][3]=='O'&& gameBoard[3][2]=='O'&& gameBoard[4][1]=='O'))
            return true;
        return false;
    }

    protected void announceWinner(PlayerType winner) {
        System.out.println("Player " + winner + " wins!");
        gameWon = true;
    }
}
