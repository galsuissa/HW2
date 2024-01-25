package XO;

abstract class Player extends Thread {
    protected PlayerType playerType;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public abstract void makeMove();
}
