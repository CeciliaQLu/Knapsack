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
//        Sample [] Test = RS.GenerateSamples(10,10,10,1);
//        int [] Values =  new int [] {15,12,8};
//        int [] Weights = new int [] {7,6,2};
//        int[] Numbers = new int []{2,1,2};
//        int W = 7;

        //int[] Values = new int[]{15,12,8}; 
        //int[] Weights = new int[]{7,6,2}; 
        //int[] Numbers = new int[]{3,3,4};

        //int W=10;

        //int[] Values = new int[]{15,12,8}; 
        //int[] Weights = new int[]{7,6,2}; 
        //int[] Numbers = new int[]{13,3,4};

        //int W=20;

        //int[] Values = new int[]{15,12,8}; 
        //int[] Weights = new int[]{7,6,2}; 
        //int[] Numbers = new int[]{13,13,4};

        //int W=30;

        //int[] Values = new int[]{15,12,8}; 
        //int[] Weights = new int[]{7,6,2}; 
        //int[] Numbers = new int[]{13,13,14};

        //int W=40;

        int[] Values = new int[]{15, 12, 8};
        int[] Weights = new int[]{7, 6, 2};
        int[] Numbers = new int[]{13, 13, 24};
        int W = 50;
        Sample[] Test = RS.GenerateSamples(Values, Weights, Numbers);
        RS.PrintSample(Test);
        GraphTraversal GT = new GraphTraversal();
        Node Result = GT.Search(Test, W);
        System.out.println("Weight capacity: " + W);
        GT.PrintNode(Result);
        System.out.println("Barometer: " + GT.bar);
    }
}
