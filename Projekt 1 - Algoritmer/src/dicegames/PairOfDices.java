package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {

    /**
     * The first die in the pair.
     */
    private Die die1;
    /**
     * The second die in the pair.
     */
    private Die die2;

    private int numOfRolls = 0;
    private int sum = 0;
    private int numOfSixes = 0;
    private int numOfFives = 0;
    private int numOfFours = 0;
    private int numOfThrees = 0;
    private int numOfTwos = 0;
    private int numOfOnes = 0;

    private int getEqualFaceValue = 0;

    private int bestScore = 0;

    /**
     * Constructor for objects of class PairOfDices
     */
    // Programmer en parameterløs constructor, så den opretter de to terninger, dvs.
    // to objekter af Die i felterne die1 og die2.
    // Programmer endnu en constructor. Denne skal have en paramter for antal sider
    // der skal være på terningerne. Så den opretter de to terninger, dvs. to
    // objekter af Die i felterne die1og die2, med det angivne antal sider.

    public PairOfDices() {
        die1 = new Die();
        die2 = new Die();
    }

    // TODO: put the constructor here!
    // Remember, the constructor should initialize die1 and die2.
    public void rollBothDices() {
        die1.roll();
        die2.roll();

        if (die1.getFaceValue() == 1) {
            numOfOnes++;
        } else if (die1.getFaceValue() == 2) {
            numOfTwos++;
        } else if (die1.getFaceValue() == 3) {
            numOfThrees++;
        } else if (die1.getFaceValue() == 4) {
            numOfFours++;
        } else if (die1.getFaceValue() == 5) {
            numOfFives++;
        } else if (die1.getFaceValue() == 6) {
            numOfSixes++;
        }

        else if (die2.getFaceValue() == 2) {
            numOfTwos++;
        } else if (die2.getFaceValue() == 3) {
            numOfThrees++;
        } else if (die2.getFaceValue() == 4) {
            numOfFours++;
        } else if (die2.getFaceValue() == 5) {
            numOfFives++;
        } else if (die2.getFaceValue() == 6) {
            numOfSixes++;
        }
        if (die1.getFaceValue() == die2.getFaceValue()) {
            getEqualFaceValue++;
        }

        System.out.println("Du har slået " + die1.getFaceValue() + " og " + die2.getFaceValue());
        numOfRolls++;
    }

    public int sumOfDices() {
        sum = die1.getFaceValue() + die2.getFaceValue();

        if (sum >= bestScore) {
            bestScore = sum;
        }
        return sum;
    }

    public int numOfRolls() {
        return numOfRolls;
    }

    public int ones() {
        return numOfOnes;
    }

    public int twos() {
        return numOfTwos;
    }

    public int threes() {
        return numOfThrees;
    }

    public int fours() {
        return numOfFours;
    }

    public int fives() {
        return numOfFives;
    }

    public int sixes() {
        return numOfSixes;
    }

    public int getEqualFaceValue() {
        return getEqualFaceValue;
    }

    public int bestScore() {
        return bestScore;
    }

    public void resetPairOfDice() {
        numOfRolls = 0;

        numOfSixes = 0;
        numOfFives = 0;
        numOfFours = 0;
        numOfThrees = 0;
        numOfTwos = 0;
        numOfOnes = 0;

        getEqualFaceValue = 0;
    }
}