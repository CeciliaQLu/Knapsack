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
    public Sample[] GenerateSamples(int size, int MaxValue, int MaxWeight, int MaxSize) {
        //inilize the samples
        Sample[] results = new Sample[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(MaxValue);
            int weight = rand.nextInt(MaxWeight) + 1;
            int MaterialSize = rand.nextInt(MaxSize) + 1;
            String name = String.valueOf(i);
            Sample temp = new Sample(name, value, weight);
            temp.number = MaterialSize;
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
    public Sample[] GenerateSamples(int[] Value, int[] Weight, int[] Number) {
        //inilize the samples
        int size = Value.length;
        Sample[] results = new Sample[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            String name = "Item" + String.valueOf(i);
            Sample temp = new Sample(name, Value[i], Weight[i]);
            temp.number = Number[i];
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
            String temp = "";
            temp += test[i].name + ": ";
            temp += "Value = " + String.valueOf(test[i].value) + " ";
            temp += "Weight = " + String.valueOf(test[i].weight) + " ";
            temp += "Number = " + String.valueOf(test[i].number) + " ";
            System.out.println(temp);
        }
    }

    //calculate the size
    public int CalculateSize(Sample[] samples) {
        int result = 0;
        for (int i = 0; i < samples.length; i++) {
            result += samples[i].number;
        }
        return result;
    }

    //flatten the samples
    public Sample[] Flatten(Sample[] test) {
        int number = CalculateSize(test);
        Sample[] result = new Sample[number];
        int count = 0;
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].number; j++) {
                Sample temp = new Sample(test[i].name, test[i].value, test[i].weight);
                result[count] = temp;
                count++;
            }
        }
        return result;
    }
}
