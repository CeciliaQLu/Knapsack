/**
 * This class defines the item object.
 * Each item has its name, value, and weight.
 * Default number of the item is 1.
 *
 * @author luqing Student ID: 300363602
 */
public class Sample {
    //name
    public String name = "";
    //value
    public int value = 0;
    //weight
    public int weight = 0;
    //number regarding 0-1 knapsack the number must be one
    public int number = 1;

    Sample(String _name, int _value, int _weight) {
        name = _name;
        value = _value;
        weight = _weight;
    }
}


