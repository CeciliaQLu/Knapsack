import java.util.*;

/**
 * Traversing the graph.
 *
 * @author luqing Student ID: 300363602
 */
public class GraphTraversal {
    public int bar = 0;

    /**
     * Search node.
     * @param test a list of items.
     * @param W weight capacity.
     * @return target node.
     */
    public Node Search(Sample[] test, int W) {
        int size = test.length;
        Node best = new Node(3);
        Stack<Node> fringe = new Stack<Node>();
        Node start = CreateStartnode(test);
        fringe.push(start);
        ArrayList<String> Searched = new ArrayList<String>();
        while (!fringe.empty()) {
            bar++;
            Node use = fringe.pop();
            if (!Searched.contains(use.title)) {
                Searched.add(use.title);
                ArrayList<Node> neighbours = FindNeighbours(test, use, Searched);
                //add neighbour to fringe
                for (int i = 0; i < neighbours.size(); i++) {
                    Node temp = neighbours.get(i);
                    fringe.push(temp);
                    //PrintNode(temp);
                    if ((temp.Weight <= W) && (temp.Value > best.Value)) {
                        best = temp;
                    }
                }
            }
        }
        return best;
    }

    /**
     * Initialise the start node.
     * @param test a list of items
     * @return start node.
     */
    public Node CreateStartnode(Sample[] test) {
        Node start = new Node(test.length);
        for (int i = 0; i < start.Items.length; i++) {
            start.Items[i] = 0;
        }
        start.title = GenerateName(start.Items);
        return start;
    }

    /**
     * Find neighbour nodes.
     * @param test a list of items.
     * @param give a node
     * @param Searched a list of strings
     * @return
     */
    public ArrayList<Node> FindNeighbours(Sample[] test, Node give, ArrayList<String> Searched) {
        ArrayList<Node> neighbour = new ArrayList<Node>();
        //int count=0;
        for (int i = 0; i < test.length; i++) {
            if (test[i].number >= (give.Items[i] + 1)) {
                Node temp = new Node(test.length);
                temp.Weight += test[i].weight + give.Weight;
                temp.Value += test[i].value + give.Value;
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
        return neighbour;
    }

    /**
     * Generate name for nodes.
     * @param item a list of items
     * @return name
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
}
