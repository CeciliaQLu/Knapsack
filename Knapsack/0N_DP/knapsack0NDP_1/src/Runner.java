import java.lang.System;
/**
 * The Runner class implements the main function.
 * It generates an array of items (with value and weight) randomly for complexity calculation;
 * and also takes values and weights of the items to get the result for the 0-1 knapsack problem.
 *
 * @author luqing Student ID: 300363602
 */
public class Runner {
    //run the proposed algorithm
    public static void main(String[] args) {
        //initialize a random sample list
        RandomSample RS = new RandomSample();
        //Sample [] Test = RS.GenerateSamples(10,10,10,1);
        int[] Values = new int[]{15, 12, 8};
        int[] Weights = new int[]{7, 6, 2};
        int[] Numbers = new int[]{2, 1, 2};
        Sample[] Test = RS.GenerateSamples(Values, Weights, Numbers);
        Sample[] flattenTest = RS.Flatten(Test);
        RS.PrintSample(flattenTest);
        int W = 7;
        DynamicProgramming DP = new DynamicProgramming();
        DP.Nknapsack(flattenTest, W);
        System.out.println("Weight capacity: " + W);
        System.out.println("Barometer: " + DP.bar);
    }
}
