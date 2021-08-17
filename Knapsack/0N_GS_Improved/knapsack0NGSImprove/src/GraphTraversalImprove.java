import java.util.*;
/**
 * Improved graph search algorithm.
 */
public class GraphTraversalImprove {
    public Node best = new Node(1);
    public ArrayList<String> Searched = new ArrayList<String>();
    public int bar = 0; // barometer

    /**
     * Receiving weight capacity and a sequence of items and back track the graph.
     * @param W weight
     * @param test a sequence of items.
     */
    public void Knapsack(double W, Sample[] test) {
        int size = test.length;
        ArrayList<Sample> ranked = Rank(test);
        PrintSample(ranked);
        for (int i = 0; i < size; i++) {
            Node begin = InializeNode(i, ranked);
            Backtrack(begin, W, ranked);
        }
    }

    /**
     * Back track.
     * @param give current node.
     * @param W weight
     * @param test a sequence of items.
     */
    public void Backtrack(Node give, double W, ArrayList<Sample> test) {
        bar++;
        int size = test.size();
        double BestV = Greedy(give, test, W);
        Searched.add(give.title);
        if ((give.Value > best.Value) && (give.Weight <= W)) {
            best = give;
        }
        if ((BestV > best.Value) && (give.Weight <= W)) {
            ArrayList<Node> neighbour = new ArrayList<Node>();
            for (int i = 0; i < size; i++) {
                if (test.get(i).number >= (give.Items[i] + 1)) {
                    Node temp = new Node(size);
                    temp.Weight += test.get(i).weight + give.Weight;
                    temp.Value += test.get(i).value + give.Value;
                    for (int j = 0; j < give.Items.length; j++) {
                        temp.Items[j] = give.Items[j];
                    }
                    temp.Items[i] += 1;
                    temp.title = GenerateName(temp.Items);
                    if (!Searched.contains(temp.title)) {
                        neighbour.add(temp);
                    }
                }
            }
            Collections.sort(neighbour);
            for (Node t : neighbour) {
                Backtrack(t, W, test);
            }
        }
    }

    /**
     * Initialise the node.
     * @param id
     * @param test a sequence of items.
     * @return
     */
    public Node InializeNode(int id, ArrayList<Sample> test) {
        int len = test.size();
        Node temp = new Node(len);
        for (int i = 0; i < temp.Items.length; i++) {
            temp.Items[i] = 0;
        }
        temp.Items[id] = 1;
        temp.title = GenerateName(temp.Items);
        temp.Weight = test.get(id).weight;
        temp.Value = test.get(id).value;
        return temp;
    }

    /**
     * Generate name for items.
     * @param item a sequence of item.
     * @return string - name
     */
    public String GenerateName(int[] item) {
        String temp = "";
        for (int i : item) {
            temp += String.valueOf(i);
        }
        return temp;
    }

    /**
     * Print out node info.
     * @param A node
     */
    public void PrintNode(Node A) {
        String temp = "";
        temp += A.title + ":  ";
        temp += "Weight = " + A.Weight;
        temp += " Value = " + A.Value;
        temp += "\nNumber of each item (same order as above): [ ";
        for (int i : A.Items) {
            temp += i + " ";
        }
        temp += "]";
        System.out.println(temp);
    }

    public ArrayList<Sample> Rank(Sample[] test) {
        ArrayList<Sample> use = new ArrayList<Sample>();
        for (Sample i : test) {
            use.add(i);
        }
        Collections.sort(use);
        return use;
    }

    /**
     * Print out item info.
     * @param test
     */
    public void PrintSample(ArrayList<Sample> test) {
        for (Sample i : test) {
            String temp = "";
            temp += "Item" + i.name + " : ";
            temp += "Weight = " + i.weight;
            temp += " Value = " + i.value;
            System.out.println(temp);
        }
    }

    /**
     * Greedy.
     * @param n node
     * @param Rank a list of items
     * @param W
     * @return double value
     */
    public double Greedy(Node n, ArrayList<Sample> Rank, double W) {
        double value = n.Value;
        double weightR = W - n.Weight;
        int size = Rank.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (Rank.get(i).number - n.Items[i]); j++) {
                if (weightR - Rank.get(i).weight <= 0) {
                    value += weightR * (Rank.get(i).value / Rank.get(i).weight);
                    return value;
                } else {
                    weightR -= Rank.get(i).weight;
                    value += Rank.get(i).value;
                }
            }
        }
        return value;
    }
}
