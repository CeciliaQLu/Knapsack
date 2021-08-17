import java.lang.System;

/**
 * This class processes the dynamic programming.
 *
 * @author luqing Student ID: 300363602
 */

public class DynamicProgramming {
    public int bar = 0;

    /**
     * 0-N knapsack
     * @param Test a sequence of items
     * @param W weight capacity of the knapsack
     */
    public void Nknapsack(Sample[] Test, int W) {
        int size = Test.length;
        Bag[][] results = new Bag[size + 1][W + 1];
        //Initialize the table
        for (int i = 0; i < W + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                Bag temp = new Bag();
                results[j][i] = temp;
            }
        }

        //begin the algorithm
        for (int i = 0; i < size; i++) {
            for (int weight = 1; weight < W + 1; weight++) {
                bar++;
                if (Test[i].weight > weight) {
                    results[i + 1][weight] = results[i][weight];
                } else {
                    results[i + 1][weight] = Max(results[i][weight], results[i][weight - Test[i].weight], Test[i].value, Test[i].name);
                }
            }
        }
        PrintBags(results);
        System.out.print("Selected Items: ");
        PrintSelectItem(results[size][W]);
    }

    /**
     * Get the bag object with the maximum value.
     * @param A one knapsack
     * @param B another knapsack
     * @param value sum of value
     * @param name name of item
     * @return knapsack
     */
    public Bag Max(Bag A, Bag B, int value, String name) {
        if (A.Value > (B.Value + value)) {
            return A;
        } else {
            Bag temp = new Bag();
            temp.Value = B.Value + value;
            for (int i = 0; i < B.Items.size(); i++) {
                temp.Items.add(B.Items.get(i));
            }
            temp.Items.add(name);
            return temp;
        }
    }

    /**
     * Print the info of knapsack.
     * @param Trained
     */
    public void PrintBags(Bag[][] Trained) {
        for (int i = 0; i < Trained.length; i++) {
            String temp = "";
            for (int j = 0; j < Trained[0].length; j++) {
                temp += String.valueOf(Trained[i][j].Value) + " ";

            }
            System.out.println(temp);
        }
    }

    /**
     * Print items in the knapsack.
     * @param Trained current knapsack.
     */
    public void PrintSelectItem(Bag Trained) {
        String temp = "[";
        for (String it : Trained.Items) {
            temp += " " + it;
        }
        temp += " ]";
        System.out.println(temp);
    }
}
