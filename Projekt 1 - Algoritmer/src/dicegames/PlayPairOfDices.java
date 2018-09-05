package dicegames;

import java.util.Scanner;

public class PlayPairOfDices {

    private int rolls;

    private Scanner scan;

    private PairOfDices die;

    public PlayPairOfDices() {
        die = new PairOfDices();
        scan = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet PairOfDices terning");
    }

    private void gameOver() {
        System.out.println("Tak for spillet du kastede " + rolls + " " + "gange.");
        scan.close();
    }

    private void takeTurn() {
        die.rollBothDices();
        rolls++;
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
            String proceedWithGame = scan.nextLine();
            if (proceedWithGame.equalsIgnoreCase("nej")) {
                finished = true;
            } else {
                takeTurn();
            }
        }

        gameOver();
    }
}
