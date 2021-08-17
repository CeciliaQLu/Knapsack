import java.lang.System;
/**
 * This class defines the progress of knapsack 0-1 problem.
 *
 * @author luqing Student ID: 300363602
 */
public class Knap01 {
    int bar = 0; // barometer
    /**
     * It firstly initailise a (size + 1)x(W + 1) table with all values = 0.
     * Then it assigns values dynamically.
     *
     * @param Test a sequence of items.
     * @param W the weight capacity.
     */
    public void RunAlgorithm(Sample[] Test, int W) {
        int size = Test.length;
        Bag[][] results = new Bag[size + 1][W + 1];
        //Initialize the table
        for (int i = 0; i < W + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                Bag tempBag = new Bag();
                results[j][i] = tempBag;
            }
        }

        //begin the algorithm
        for (int i = 0; i < size; i++) {
            for (int weight = 1; weight < W + 1; weight++) {
                if (Test[i].weight > weight) {
                    bar++;
                    results[i + 1][weight] = results[i][weight];
                } else {
                    bar++;
                    results[i + 1][weight] = Max(results[i][weight], results[i][weight - Test[i].weight], Test[i].value, i);
                }
            }
        }
        PrintBags(results);
        System.out.println("Selected Items in the bag: ");
        PrintSelectItem(results[size][W]);
    }

    /**
     * Get the bag object with the maximum value.
     *
     * @param first first bag
     * @param second second bag
     * @param value the value of the item
     * @param ID ID of the item
     * @return bag with greater value.
     */
    public Bag Max(Bag first, Bag second, int value, int ID) {
        if (first.Value > (second.Value + value)) {
            return first;
        } else {
            Bag temp = new Bag();
            temp.Value = second.Value + value;
            for (int it : second.Item) {
                temp.Item.add(it);
            }
            temp.Item.add(ID);
            return temp;
        }
    }

    /**
     * Print out the bag's information.
     * @param Trained
     */
    public void PrintBags(Bag[][] Trained) {
        for (int i = 0; i < Trained.length; i++) {
            String temp = "";
            for (int j = 0; j < Trained[0].length; j++) {
                temp += Trained[i][j].Value + " ";

            }
            System.out.println(temp);
        }
    }

    /**
     * Print out the items' index in the bag.
     * @param Trained bag with items in it.
     */
    public void PrintSelectItem(Bag Trained) {
        String temp = "Value: " + Trained.Value;
        temp += "\nSelected Items: [";
        for (int it : Trained.Item) {
            temp += " " + it;
        }
        temp += " ]";
        System.out.println(temp);
    }
}
