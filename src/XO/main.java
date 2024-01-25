package XO;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the game version:");
        System.out.println("1. Self vs Self");
        System.out.println("2. Self vs User");

        int choice = scanner.nextInt();
        //start to activate the game
        //choice 1 is the option of self game
        if (choice == 1) {
            SelfGame selfGame = new SelfGame();
            //playerX and playerO there are the threads.
            SelfPlayer playerX = selfGame.playerX;
            SelfPlayer playerO = selfGame.playerO;
            playerX.setGame(selfGame);
            playerO.setGame(selfGame);

            selfGame.playGame();
            //choice 2 is the option of user game
        } else if (choice == 2) {
            UserGame userGame = new UserGame();
            SelfPlayer selfPlayer = userGame.selfPlayer;
            UserPlayer userPlayer = userGame.userPlayer;
            selfPlayer.setGame(userGame);
            userPlayer.setGame(userGame);

            userGame.playGame();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

