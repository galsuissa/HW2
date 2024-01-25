package XO;

import java.util.List;
import java.util.Random;

class SelfPlayer extends Player {
    private Game game;

    //Initialize the class by using inherit from the thread player
    public SelfPlayer(PlayerType playerType) {
        super(playerType);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void makeMove() {
        //the thread will sleep 500 milliseconds
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (game.getTurn() == playerType && !game.isBoardFull()) { //
            List<Cell> freeCells = game.getFreeCells();
            if (!freeCells.isEmpty()) {
                Random random = new Random();
                //using with random class to choose a cell
                Cell selectedCell = freeCells.get(random.nextInt(freeCells.size()));
                char type;
                if (playerType == PlayerType.X) {
                    type = 'X';
                } else {
                    type = 'O';
                }
                game.gameBoard[selectedCell.getRow()][selectedCell.getCol()] = type;//placement in the board
            }
        }
    }
}
