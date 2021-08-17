import java.lang.System;

/**
 * The Runner class implements the main function.
 * It generates an array of items (with value and weight) randomly for complexity calculation;
 * and also takes values and weights of the items to get the result for the 0-1 knapsack problem.
 *
 * @author luqing Student ID: 300363602
 *
 */
public class Runner {
    //run the proposed algorithm
    public static void main(String[] args) {
        // initialize a random sample list
        RandomSample RS = new RandomSample();
        // Sample [] Test = RS.GenerateSamples(20,10,10); // call this for complexity.
        int[] Values = new int[]{3, 15, 12, 8, 8};
        int[] Weights = new int[]{6, 7, 7, 2, 2};
        Sample[] Test = RS.GenerateSamples(Values, Weights);
        RS.PrintSample(Test);
        int W = 6;
        Knap01 worker = new Knap01();
        worker.RunAlgorithm(Test, W);
        System.out.println("=======================\nn = " + Test.length);
        System.out.println("Weight capacity = " + W);
        System.out.println("Barometer " + worker.bar);
    }
}
