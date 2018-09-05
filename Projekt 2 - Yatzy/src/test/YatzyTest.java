package test;

import org.junit.Assert;
import org.junit.Test;

import yatzy.Yatzy;

public class YatzyTest {
    private Yatzy yatzy = new Yatzy();

    @Test
    public void testSameFaceValuePoints() {
        int[] values = { 1, 2, 3, 4, 5 };
        yatzy.setValues(values);
        int[] expected = { 0, 1, 2, 3, 4, 5, 0 };
        int[] results = new int[7];
        for (int value = 1; value <= 6; value++) {
            results[value] = yatzy.valueSpecificFace(value);
        }
        Assert.assertArrayEquals(expected, results);

        int[] values1 = { 3, 4, 6, 6, 3 };
        yatzy.setValues(values1);
        int[] expected1 = { 0, 0, 0, 6, 4, 0, 12 };
        int[] results1 = new int[7];
        for (int value = 1; value <= 6; value++) {
            results1[value] = yatzy.valueSpecificFace(value);
        }
        Assert.assertArrayEquals(expected1, results1);
    }

    @Test
    public void testOnePairPoints() {
        int[] values = { 1, 6, 5, 4, 3 };
        yatzy.setValues(values);
        int result = yatzy.valueOnePair();
        Assert.assertEquals(0, result);

        int[] values1 = { 4, 6, 5, 4, 3 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueOnePair();
        Assert.assertEquals(8, result1);

        int[] values2 = { 4, 4, 6, 4, 6 };
        yatzy.setValues(values2);
        int result2 = yatzy.valueOnePair();
        Assert.assertEquals(12, result2);
    }

    @Test
    public void testTwoPairPoints() {
        int[] values = { 1, 2, 3, 5, 6 };
        yatzy.setValues(values);
        int result = yatzy.valueTwoPair();
        Assert.assertEquals(0, result);

        int[] values1 = { 4, 2, 3, 4, 2 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueTwoPair();
        Assert.assertEquals(12, result1);

        int[] values2 = { 5, 5, 6, 6, 5 };
        yatzy.setValues(values2);
        int result2 = yatzy.valueTwoPair();
        Assert.assertEquals(22, result2);
    }

    @Test
    public void testThreeSamePoints() {
        int[] values = { 2, 3, 6, 6, 5 };
        yatzy.setValues(values);
        int result = yatzy.valueThree();
        Assert.assertEquals(0, result);

        int[] values1 = { 6, 3, 6, 6, 5 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueThree();
        Assert.assertEquals(18, result1);

        int[] values2 = { 6, 3, 6, 6, 6 };
        yatzy.setValues(values2);
        int result2 = yatzy.valueThree();
        Assert.assertEquals(18, result2);
    }

    @Test
    public void testFourSamePoints() {
        int[] values = { 1, 2, 5, 6, 3 };
        yatzy.setValues(values);
        int result = yatzy.valueFour();
        Assert.assertEquals(0, result);

        int[] values1 = { 2, 6, 5, 2, 2 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueFour();
        Assert.assertEquals(0, result1);

        int[] values2 = { 2, 2, 5, 2, 2 };
        yatzy.setValues(values2);
        int result2 = yatzy.valueFour();
        Assert.assertEquals(8, result2);
    }

    @Test
    public void testFullHousePoints() {
        int[] values = { 6, 5, 4, 2, 1 };
        yatzy.setValues(values);
        int result = yatzy.valueFullHouse();
        Assert.assertEquals(0, result);

        int[] values1 = { 3, 3, 2, 3, 6 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueFullHouse();
        Assert.assertEquals(0, result1);

        int[] values2 = { 3, 3, 5, 3, 5 };
        yatzy.setValues(values2);
        int result2 = yatzy.valueFullHouse();
        Assert.assertEquals(19, result2);
    }

    @Test
    public void testSmallStraightPoints() {
        int[] values = { 1, 2, 3, 4, 6 };
        yatzy.setValues(values);
        int result = yatzy.valueSmallStraight();
        Assert.assertEquals(0, result);

        int[] values1 = { 1, 3, 5, 2, 4 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueSmallStraight();
        Assert.assertEquals(15, result1);
    }

    @Test
    public void testLargeStraightPoints() {
        int[] values = { 1, 2, 3, 4, 6 };
        yatzy.setValues(values);
        int result = yatzy.valueLargeStraight();
        Assert.assertEquals(0, result);

        int[] values1 = { 6, 3, 5, 2, 4 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueLargeStraight();
        Assert.assertEquals(20, result1);
    }

    @Test
    public void testChancePoints() {
        int[] values = { 3, 6, 2, 3, 4 };
        yatzy.setValues(values);
        int result = yatzy.valueChance();
        Assert.assertEquals(18, result);

        int[] values1 = { 6, 6, 6, 6, 6 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueChance();
        Assert.assertEquals(30, result1);
    }

    @Test
    public void testYatzyPoints() {
        int[] values = { 3, 3, 3, 3, 5 };
        yatzy.setValues(values);
        int result = yatzy.valueYatzy();
        Assert.assertEquals(0, result);

        int[] values1 = { 3, 3, 3, 3, 3 };
        yatzy.setValues(values1);
        int result1 = yatzy.valueYatzy();
        Assert.assertEquals(50, result1);
    }
    
    @Test
    public void testThrowCount() {
        yatzy.throwDice(new boolean[5]);
        yatzy.throwDice(new boolean[5]);
        yatzy.throwDice(new boolean[5]);
        int result = yatzy.getThrowCount();
        Assert.assertEquals(3, result);
        
        yatzy.resetThrowCount();
        result = yatzy.getThrowCount();
        Assert.assertEquals(0, result);
    }
    
    @Test
    public void testThrowHold() {
        int[] values = { 1, 3, 3, 3, 5 };
        yatzy.setValues(values);
        int first = yatzy.getValues()[0];
        int fourth = yatzy.getValues()[3];
        boolean[] holds = {true, false, false, true, false};
        yatzy.throwDice(holds);
        int newFirst = yatzy.getValues()[0];
        int newFourth = yatzy.getValues()[3];
        Assert.assertEquals(first, newFirst);
        Assert.assertEquals(fourth, newFourth);
    }
    
    @Test
    public void testGetResult() {
        int[] values = { 1, 3, 3, 3, 5 };
        yatzy.setValues(values);
        int result = yatzy.getPossibleResults()[14];
        Assert.assertEquals(0, result);
        
        int[] values1 = { 3, 3, 3, 3, 3 };
        yatzy.setValues(values1);
        result = yatzy.getPossibleResults()[14];
        Assert.assertEquals(50, result);
        
        result = yatzy.getPossibleResults()[2];
        Assert.assertEquals(15, result);
    }
    
}
