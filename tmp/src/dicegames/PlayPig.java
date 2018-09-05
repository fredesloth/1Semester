package dicegames;

import java.util.Scanner;

public class PlayPig
{
   private int rolls1;
   private int rolls2;

   private int points1;
   private int points2;

   private Scanner scan;

   private Die die;

   private int maxpoints;

   private String ai;

   private boolean aion;

   private boolean mainPlayer = true;

   private boolean player1 = true;
   private boolean player2 = true;

   private String proceedWithGame;

   public PlayPig()
   {
      die = new Die();

      scan = new Scanner(System.in);
   }

   private void welcomeToGame()
   {
      System.out.println("Velkommen til spillet PIG");
      System.out.println("Hvor mange points vil I gerne spille til?");
      maxpoints = scan.nextInt();

   }

   private void gameOver()
   {
      System.out.println("Tak for spillet, \n Spiller1 kastede: " + rolls1
            + " gange. \n Spiller2 kastede: " + rolls2 + " gange."
            + "\n Spiller1 fik " + points1 + " points. \n Spiller2 fik: "
            + points2 + " points.");

      if (points1 > points2)
      {
         System.out.println("Tillykke til Spiller1! Du har vundet!");
      }
      else if (points1 < points2)
      {
         System.out.println("Tillykke til Spiller2! Du har vundet!");
      }

   }

   private void takeTurn()
   {
      if (mainPlayer == true)
      {
         die.roll();
         int roll = die.getFaceValue();
         rolls1++;
         System.out.println("Spiller1 har kastet: " + roll);
         if (roll == 1)
         {
            player1 = false;
         }
         else
         {
            points1 = points1 + roll;
         }
         if (player2 == false)
         {

         }
         else
         {
            mainPlayer = false;
         }
      }
      else if (mainPlayer == false)
      {
         die.roll();
         int roll = die.getFaceValue();
         rolls2++;
         System.out.println("Spiller2 har kastet: " + roll);
         if (roll == 1)
         {
            player2 = false;
         }
         else
         {
            points2 = points2 + roll;
         }
         if (player1 == false)
         {

         }
         else
         {
            mainPlayer = true;
         }

      }

      if (points1 >= maxpoints || points2 >= maxpoints)
      {
         this.gameOver();
      }

      if (player1 == false && player2 == false
            || player1 == false && proceedWithGame.equals("nej")
            || player2 == false && proceedWithGame.equals("nej"))
      {
         this.gameOver();
      }

   }

   public void startGame()
   {
      welcomeToGame();

      System.out.println("Vil du spille mod Computeren?");
      ai = scan.next();

      if (ai.equals("ja"))
      {
         aion = true;
      }
      else
      {
         aion = false;
      }

      boolean finished = false;

      while (!finished)
      {
         if (mainPlayer == true)
         {
            System.out.println(
                  "Vil Spiller1 kaste en terning? Angiv Ja eller Nej: ");
            proceedWithGame = scan.nextLine();
         }
         else if (mainPlayer == false && aion == false)
         {
            System.out.println(
                  "Vil Spiller2 kaste en terning? Angiv Ja eller Nej: ");
            proceedWithGame = scan.nextLine();
         }
         else if (mainPlayer == false && aion == true)
         {
            System.out.println(
                  "Vil Spiller2 kaste en terning? Angiv Ja eller Nej: ");
            int aiChoice = (int) (Math.random() * 2) + 1;
            if (aiChoice == 1)
            {
               proceedWithGame = "ja";
            }
            else if (aiChoice == 2)
            {
               proceedWithGame = "nej";
            }
         }

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
