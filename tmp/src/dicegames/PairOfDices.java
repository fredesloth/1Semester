package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices
{

   private int sum = 0;

   private int numberOfRolls = 0;

   private int numberOfEqualFaceValues = 0;

   private int biggestRoll = 0;

   /**
    * The first die in the pair.
    */
   private Die die1;
   /**
    * The second die in the pair.
    */
   private Die die2;

   private int numberOfSixes = 0;
   private int numberOfFives = 0;
   private int numberOfFours = 0;
   private int numberOfThrees = 0;
   private int numberOfTwos = 0;
   private int numberOfOnes = 0;

   /**
    * Constructor for objects of class PairOfDices
    */

   public PairOfDices()
   {
      die1 = new Die();
      die2 = new Die();
   }

   public PairOfDices(int sides)
   {
      die1 = new Die(sides);
      die2 = new Die(sides);
   }

   // Rolls both dices, counts the face values and the number of rolls
   public void rollBothDices()
   {
      die1.roll();

      if (die1.getFaceValue() == 6)
      {
         numberOfSixes += 1;
      }
      else if (die1.getFaceValue() == 5)
      {
         numberOfFives += 1;
      }
      else if (die1.getFaceValue() == 4)
      {
         numberOfFours += 1;
      }
      else if (die1.getFaceValue() == 3)
      {
         numberOfThrees += 1;
      }
      else if (die1.getFaceValue() == 2)
      {
         numberOfTwos += 1;
      }
      else if (die1.getFaceValue() == 1)
      {
         numberOfOnes += 1;
      }

      die2.roll();

      if (die2.getFaceValue() == 6)
      {
         numberOfSixes += 1;
      }
      else if (die2.getFaceValue() == 5)
      {
         numberOfFives += 1;
      }
      else if (die2.getFaceValue() == 4)
      {
         numberOfFours += 1;
      }
      else if (die2.getFaceValue() == 3)
      {
         numberOfThrees += 1;
      }
      else if (die2.getFaceValue() == 2)
      {
         numberOfTwos += 1;
      }
      else if (die2.getFaceValue() == 1)
      {
         numberOfOnes += 1;
      }

      if (die1.getFaceValue() == die2.getFaceValue())
      {
         numberOfEqualFaceValues += 1;
      }

      numberOfRolls += 1;
   }

   // Returns the current sum of the face values
   public int sumOfDices()
   {
      sum = die1.getFaceValue() + die2.getFaceValue();
      if (sum >= biggestRoll)
      {
         biggestRoll = sum;
      }
      return sum;
   }

   // Returns the number of "rollBothDices"
   public int numOfRolls()
   {
      return numberOfRolls;
   }

   // Returns the number of sixes
   public int Sixes()
   {
      return numberOfSixes;
   }

   // Returns the number of fives
   public int Fives()
   {
      return numberOfFives;
   }

   // Returns the number of fours
   public int Fours()
   {
      return numberOfFours;
   }

   // Returns the number of threes
   public int Threes()
   {
      return numberOfThrees;
   }

   // Returns the number of twos
   public int Twos()
   {
      return numberOfTwos;
   }

   // Returns the number of ones
   public int Ones()
   {
      return numberOfOnes;
   }

   public int getEqualFaceValues()
   {
      return numberOfEqualFaceValues;
   }

   public void resetPairOfDices()
   {
      numberOfSixes = 0;
      numberOfFives = 0;
      numberOfFours = 0;
      numberOfThrees = 0;
      numberOfTwos = 0;
      numberOfOnes = 0;
      biggestRoll = 0;
      numberOfEqualFaceValues = 0;
      numberOfRolls = 0;
      sum = 0;
   }
}
