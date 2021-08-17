/**
 * This class defines node object.
 */
public class Node implements Comparable<Node> {
    public String title = "";
    public double Weight = 0;
    public double Value = 0;
    public int[] Items;

    /**
     * Constructor.
     * @param n
     */
    Node(int n) {
        Items = new int[n];
    }
    public int compareTo(Node arg0) {
        return (int) ((arg0.Value / arg0.Weight) - (this.Value / this.Weight));
    }
}
