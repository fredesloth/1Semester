package dicegames;

import java.util.Scanner;

public class CrapsPlay
{
   private Scanner scan;

   private PairOfDices dices;

   private boolean victory;

   private int points = 0;

   private boolean firstRoll = true;

   private int victories = 0;

   private int defeats = 0;

   private String proceedWithGame;

   public CrapsPlay()
   {
      dices = new PairOfDices();
      scan = new Scanner(System.in);
   }

   private void welcomeToGame()
   {
      System.out.println("Velkommen til spillet CRAPS");
   }

   private void gameOver()
   {
      if (proceedWithGame.equals("nej"))
      {

         System.out.println("Antal vundende spil: " + victories
               + "\n Antal tabte spil: " + defeats);
         scan.close();
      }
      else
      {

         if (victory == true)
         {
            System.out.println("Tillykke! Du har vundet!");
            victories += 1;
         }
         else if (victory == false)
         {

            System.out.println("ØV! Du tabte...");
            defeats += 1;
         }
      }
   }

   private void takeTurn()
   {

      if (firstRoll == true)
      {
         dices.rollBothDices();
         System.out.println("Du har kastet: " + dices.sumOfDices());
         if (dices.sumOfDices() == 7 || dices.sumOfDices() == 11)
         {
            victory = true;
            this.gameOver();
            firstRoll = true;
            points = 0;
         }
         else if (dices.sumOfDices() == 2 || dices.sumOfDices() == 3
               || dices.sumOfDices() == 12)
         {
            victory = false;
            this.gameOver();
            firstRoll = true;
            points = 0;
         }
         else
         {
            points = dices.sumOfDices();
         }

         firstRoll = false;
      }
      else
      {
         dices.rollBothDices();
         System.out.println("Du har kastet: " + dices.sumOfDices());
         if (dices.sumOfDices() == points)
         {
            victory = true;
            this.gameOver();
            firstRoll = true;
         }
         else if (dices.sumOfDices() == 7)
         {
            victory = false;
            this.gameOver();
            firstRoll = true;
         }

      }

   }

   public void startGame()
   {
      welcomeToGame();

      boolean finished = false;

      while (!finished)
      {
         System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
         proceedWithGame = scan.nextLine();
         if (proceedWithGame.equalsIgnoreCase("nej"))
         {
            finished = true;
         }

         else
         {

            takeTurn();
         }

      }

      gameOver();

   }
}
