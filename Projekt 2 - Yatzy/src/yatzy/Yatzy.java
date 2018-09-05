package yatzy;

import java.util.Random;

/**
 * Models a game of Yatzy.
 */
public class Yatzy {
    /**
     * Face values of the 5 dice. <br/>
     * 1 <= values[i] <= 6.
     */
    private int[] values = new int[5];

    /**
     * Number of times the 5 dice have been thrown. <br/>
     * 0 <= throwCount <= 3.
     */
    private int throwCount = 0;

    /**
     * Random number generator.
     */
    private Random random = new Random();

    /**
     * Rolls the 5 dice. <br/>
     * Only roll dice that are not hold. <br/>
     * Requires: holds contain 5 boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < values.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(6) + 1;
            }
        }
        this.throwCount++;
    }

    /**
     * Returns the number of times the five dice have been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Get current dice values
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the current dice values
     */
    public void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Returns all results possible with the current face values. <br/>
     * The order of the results is the same as on the score board.
     */
    public int[] getPossibleResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = valueSpecificFace(i + 1);
        }
        results[6] = valueOnePair();
        results[7] = valueTwoPair();
        results[8] = valueThree();
        results[9] = valueFour();
        results[10] = valueFullHouse();
        results[11] = valueSmallStraight();
        results[12] = valueLargeStraight();
        results[13] = valueChance();
        results[14] = valueYatzy();
        return results;
    }

    /**
     * Returns an int[7] containing the frequency of face values. <br/>
     * Frequency at index v is the number of dice with the face value v, 1 <= v <=
     * 6. <br/>
     * Index 0 is not used.
     */
    private int[] freqFaceValue() {
        int[] current = new int[7];
        for (int face = 1; face <= 6; face++) {
            for (int value = 0; value < values.length; value++) {
                if (this.values[value] == face) {
                    current[face]++;
                }
            }
        }

        return current;
    }

    /**
     * Returns the total value for the dice currently showing the given face value
     *
     * @param face
     *            the face value to return values for
     */
    public int valueSpecificFace(int face) {
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == face) {
                counter += face;
            }
        }
        return counter;
    }

    /**
     * Returns the maximum value for n-of-a-kind for the given n. <br/>
     * For example, valueManyOfAKind(3) returns the maximum value for 3 of-a-kind.
     * <br/>
     * Requires: 1 <= faceValue and faceValue <= 6
     *
     * @param n
     *            number of kind
     */
    public int valueManyOfAKind(int n) {
        int[] current = freqFaceValue();
        int place = 0;
        for (int i = 0; i < freqFaceValue().length; i++) {
            if (current[i] >= n) {
                place = i;
            }
        }
        int sum = place * n;
        return sum;
    }

    /**
     * The current value if you try to score the current face values as Yatzy.
     */
    public int valueYatzy() {
        int points = 0;
        int[] current = freqFaceValue();
        for (int i = 0; i < freqFaceValue().length; i++) {
            if (current[i] == 5) {
                points = 50;
            }
        }
        return points;
    }

    /**
     * Returns the current score if used as "chance".
     */
    public int valueChance() {
        int change = 0;
        for (int i = 0; i < values.length; i++) {
            change += values[i];
        }

        return change;
    }

    /**
     * Returns the current score for one pair.
     */
    public int valueOnePair() {
        int sum = 0;
        int[] current = freqFaceValue();
        for (int i = 0; i < current.length; i++) {

            if (current[i] >= 2) {
                sum = i * 2;
            }
        }
        return sum;
    }

    /**
     * Returns the current score for two pairs.
     */
    public int valueTwoPair() {
        int sum = 0;
        int counter = 0;
        int[] current = freqFaceValue();
        for (int i = 0; i < current.length; i++) {
            if (current[i] >= 2) {
                sum += (i * 2);
                counter++;

            }

        }
        if (counter != 2) {
            sum = 0;
        }
        return sum;
    }

    /**
     * Returns the current score for three of a kind.
     */
    public int valueThree() {

        return valueManyOfAKind(3);
    }

    /**
     * Returns the current score for four of a kind.
     */
    public int valueFour() {
        return valueManyOfAKind(4);
    }

    /**
     * Returns the value of a small straight with the current face values.
     */
    public int valueSmallStraight() {
        int sum = 0;
        int[] current = freqFaceValue();
        boolean small = true;
        for (int i = 1; i < current.length - 1; i++) {
            if (current[i] != 1) {
                small = false;
            }

        }
        if (small) {
            sum = 15;
        }
        return sum;
    }

    /**
     * Returns the value of a large straight with the current face values.
     */
    public int valueLargeStraight() {
        int sum = 0;
        int[] current = freqFaceValue();
        boolean large = true;
        for (int i = 2; i < current.length; i++) {
            if (current[i] != 1) {
                large = false;
            }

        }
        if (large) {
            sum = 20;
        }
        return sum;
    }

    /**
     * Returns the value of a full house with the current face values.
     */
    public int valueFullHouse() {
        int[] current = freqFaceValue();
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 1; i < current.length; i++) {
            if (current[i] == 2) {
                sum2 = (i * 2);
            } else if (current[i] == 3) {
                sum3 = (i * 3);
            }
            if (sum2 != 0 && sum3 != 0) {
                sum = sum2 + sum3;
            }
        }

        return sum;
    }

}
