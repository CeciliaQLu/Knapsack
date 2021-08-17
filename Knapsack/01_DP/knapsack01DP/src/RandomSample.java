import java.util.Random;
import java.lang.System;

/**
 * This class can generate a random sample.
 *
 * @author luqing Student ID: 300363602
 */
public class RandomSample {
    /**
     * Generate a sequence of items.
     *
     * @param size number of items
     * @param MaxValue max value
     * @param MaxWeight max weight capacity
     * @return a sequence of items
     */
    public Sample[] GenerateSamples(int size, int MaxValue, int MaxWeight) {
        //inilize the samples
        Sample[] results = new Sample[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(MaxValue);
            int weight = rand.nextInt(MaxWeight) + 1;
            String name = String.valueOf(i);
            Sample temp = new Sample(name, value, weight);
            results[i] = temp;
        }
        return results;
    }

    /**
     * Generate a list of items based on the given values
     *
     * @param Value a sequence of values of items
     * @param Weight a sequence of weights of items
     * @return a sequence of items available
     */
    public Sample[] GenerateSamples(int[] Value, int[] Weight) {
        //inilize the samples
        int size = Value.length;
        Sample[] results = new Sample[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            String name = String.valueOf(i);
            Sample temp = new Sample(name, Value[i], Weight[i]);
            results[i] = temp;
        }
        return results;
    }

    /**
     * Print out the items with their values and weights.
     * @param test a sequence of items.
     */
    public void PrintSample(Sample[] test) {
        for (int i = 0; i < test.length; i++) {
            String temp = "Item ";
            temp += test[i].name + ": ";
            temp += "Value = " + test[i].value + ", ";
            temp += "Weight = " + test[i].weight + " ";
            System.out.println(temp);
        }
    }
}
