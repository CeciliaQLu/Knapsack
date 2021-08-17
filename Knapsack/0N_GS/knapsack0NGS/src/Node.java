/**
 * This class defines the node object.
 *
 * @author luqing Student ID: 300363602
 */
public class Node {
    public String title = "";
    public int Weight = 0;
    public int Value = 0;
    public int[] Items;
    Node(int n) {
        Items = new int[n];
    }
}
