package dicegames;

import java.util.Scanner;

public class PigGame {

    private int playerScore1 = 0;
    private int playerScore2 = 0;

    private Scanner scan;

    private Die die;

    public PigGame() {
        die = new Die();
        scan = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet 100 også kaldet pig");
    }

    private void nextUser1() {
        System.out.println("Din score blev: " + playerScore1);
        startGame2();
    }

    private void nextUser2() {
        System.out.println("Din score blev: " + playerScore2);
        startGame1();
    }

    private void takeTurn2() {
        die.roll();
        int roll = die.getFaceValue();
        playerScore2 += die.getFaceValue();
        System.out.println("Du har kastet: " + roll + " din score er nu " + playerScore2);
    }

    private void takeTurn1() {
        die.roll();
        int roll = die.getFaceValue();
        playerScore1 += die.getFaceValue();
        System.out.println("Du har kastet: " + roll + " din score er nu " + playerScore1);
    }

    public void startGame2() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Spiller 2: Vil du kaste en terning? Angiv Ja eller Nej: ");
            String proceedWithGame = scan.nextLine();
            if (proceedWithGame.equalsIgnoreCase("nej")) {
                nextUser2();
            } else {
                takeTurn2();
            }
            if (die.getFaceValue() == 1) {
                System.out.println("Desværre, runden går til spiller 1");
                nextUser2();
            }
            if (playerScore2 >= 100) {
                System.out.println("Du har vundet");
                finished = true;
            }
        }

        nextUser2();
    }

    public void startGame1() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Spiller 1: Vil du kaste en terning? Angiv Ja eller Nej: ");
            String proceedWithGame = scan.nextLine();
            if (proceedWithGame.equalsIgnoreCase("nej")) {
                nextUser1();
            } else {
                takeTurn1();
            }
            if (die.getFaceValue() == 1) {
                System.out.println("Desværre runden går til spilller 2");
                nextUser1();
            }
            if (playerScore1 >= 100) {
                System.out.println("Du har vundet");
                finished = true;
            }
        }

        nextUser1();
    }
}