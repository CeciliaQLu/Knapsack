import java.lang.System;
/**
 * bruteForce: utilize brute force.
 *
 * @author luqing Student ID: 300363602
 */
public class bruteForce {
    int bar = 0;

    /**
     * Initialise the table.
     *
     * @param samples a list of items.
     * @return 2D array.
     */
    public int[][] InitialTable(Sample[] samples) {
        int number = samples.length;
        int[][] result = new int[(int) Math.pow(2, number)][number];
        for (int i = 0; i < Math.pow(2, number); i++) {
            double value = i;
            double divisor = Math.pow(2, number);
            for (int j = 0; j < number; j++) {
                divisor /= 2;
                bar++;
                if (value >= divisor) {
                    result[i][j] = 1;
                    value -= divisor;
                }
            }
        }
        //PrintCase(result);
        return result;
    }

    /**
     * print for reference.
     * @param cases
     */
    public void PrintCase(int[][] cases) {
        for (int i = 0; i < cases.length; i++) {
            String temp = "";
            for (int j = 0; j < cases[i].length; j++) {
                temp += String.valueOf(cases[i][j]) + " ";
            }
            System.out.println(temp);
        }
    }

    /**
     * Get the best stragegy.
     * @param samples a list of items.
     * @param W weight capacity.
     */
    public void FindStrategy(Sample[] samples, int W) {
        int[][] strategies = InitialTable(samples);
        Bag[] results = new Bag[strategies.length];
        for (int i = 0; i < strategies.length; i++) {
            Bag temp = GetResult(samples, strategies[i]);
            results[i] = temp;
        }
        int best = -1;
        int bestValue = -1;
        for (int i = 0; i < results.length; i++) {
            if (results[i].Weight <= W) {

                if (results[i].Value > bestValue) {
                    best = i;
                    bestValue = results[i].Value;
                }
            }
        }
        System.out.println("given Weight capacity: " + W);
        if (best > -1) {
            PrintResult(strategies[best], results[best], samples);
        } else {
            System.out.println("no appripriate solution exist");
        }
    }

    /**
     * Get the bag with items in it.
     * @param samples a list of items.
     * @param idea list of numbers of items.
     * @return bag with best value.
     */
    public Bag GetResult(Sample[] samples, int[] idea) {
        int weight = 0;
        int value = 0;
        for (int i = 0; i < samples.length; i++) {
            bar++;
            if (idea[i] == 1) {
                weight += samples[i].weight;
                value += samples[i].value;
            }
        }
        Bag b = new Bag();
        b.Weight = weight;
        b.Value = value;
        return b;
    }

    /**
     * Print out result
     * @param idea numbers of each item in the bag
     * @param result bag
     * @param samples a list of items
     */
    public void PrintResult(int[] idea, Bag result, Sample[] samples) {
        String temp = "Select Items: ";
        for (int i = 0; i < idea.length; i++) {
            if (idea[i] == 1) {
                temp += samples[i].name + " ";
            }
        }
        temp += " | Total Weight: " + result.Weight + " ";
        temp += " | Total Value: " + result.Value + " ";
        System.out.println(temp);
    }
}
