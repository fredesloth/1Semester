package dicegames;

import java.util.Scanner;

public class PlayPairOfDice
{
   private Scanner scan;

   private PairOfDices dices;

   public PlayPairOfDice()
   {
      dices = new PairOfDices();
      scan = new Scanner(System.in);
   }

   private void welcomeToGame()
   {
      System.out.println("Velkommen til spillet KAST 2 terninger");
   }

   private void gameOver()
   {
      System.out.println(
            "Tak for spillet du kastede " + dices.numOfRolls() + " gange.");
      scan.close();
   }

   private void takeTurn()
   {
      dices.rollBothDices();
      System.out.println("Du har kastet: " + dices.sumOfDices());
   }

   public void startGame()
   {
      welcomeToGame();

      boolean finished = false;

      while (!finished)
      {
         System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
         String proceedWithGame = scan.nextLine();
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
