package dicegames;

import java.util.Scanner;

public class CrapsPlay {

    private int rolls;
    private Scanner scan;
    private PairOfDices die;
    private boolean victory;
    private int points = 0;
    private String proceedWithGame;
    private int victories;
    private int defeat;

    public CrapsPlay() {
        die = new PairOfDices();
        scan = new Scanner(System.in);
    }

    /*
     * Lav en metode welcomeToGame() der indeholder kommunikation med brugeren inden
     * spillet startes
     */

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet Craps, kast din terning og test dit held");
    }

    /*
     * Lav en metode gameOver() der udskriver information til brugeren om hvorvidt
     * spillet er vundet. Til dette kan du lave en attribut af typen boolean, der er
     * true hvis spilleren har vundet og er false ellers.
     */

    private void gameOver() {
        System.out.println("Tak for spillet du kastede " + rolls + " " + "gange.");

        if (proceedWithGame.equals("nej")) {
            System.out.println("Du har vundet " + victories + " gange og tabt " + defeat);
        } else {
            if (victory == true) {
                System.out.println("Tillykke du har vundet");
                victories++;
            } else {
                System.out.println("Du har desværre tabt");
                defeat++;
            }
            scan.close();
        }
    }

    private void takeTurn() {

        die.rollBothDices();
        int roll = die.sumOfDices();
        System.out.println(roll);
        rolls++;
        System.out.println("Du har kastet: " + roll);

        if (die.sumOfDices() == 7 || die.sumOfDices() == 11) {
            victory = true;
            victories++;
        } else if (die.sumOfDices() == 2 || die.sumOfDices() == 3 || die.sumOfDices() == 12) {
            victory = false;
            defeat++;
        } else {
            points = roll;
        }
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
            proceedWithGame = scan.nextLine();
            if (proceedWithGame.equalsIgnoreCase("nej")) {
                finished = true;
            } else {
                takeTurn();
            }
        }
        gameOver();
    }

}
