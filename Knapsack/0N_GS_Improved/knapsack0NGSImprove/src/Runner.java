import java.lang.System;
/**
 * This class includes some test cases.
 *
 * @author luqing Student ID: 300363602
 */
public class Runner {
    //run the proposed algorithm
    public static void main(String[] args) {
        //initialize a random sample list
        RandomSample RS = new RandomSample();
        //Sample [] Test = RS.GenerateSamples(10,10,10,1);
        double[] Values = new double[]{15.0, 12, 8};
        double[] Weights = new double[]{7.0, 6, 2};
        int[] Numbers = new int[]{2, 1, 2};
        double W = 7;

        //double [] Values =  new double [] {15.0,12,8};
        //double [] Weights = new double [] {7.0,6,2};
        //int[] Numbers = new int []{3,3,4};
        //double W = 10;

        //double [] Values =  new double [] {15.0,12,8};
        //double [] Weights = new double [] {7.0,6,2};
        //int[] Numbers = new int []{13,3,4};
        //double W = 20;

        //double [] Values =  new double [] {15.0,12,8};
        //double [] Weights = new double [] {7.0,6,2};
        //int[] Numbers = new int []{13,23,14};
        //double W = 50;

        Sample[] Test = RS.GenerateSamples(Values, Weights, Numbers);
        //RS.PrintSample(Test);
        GraphTraversalImprove GT = new GraphTraversalImprove();
        GT.Knapsack(W, Test);
        System.out.println("Weight capacity: " + W);
        GT.PrintNode(GT.best);
        System.out.println("Barometer: " + GT.bar);
    }
}
