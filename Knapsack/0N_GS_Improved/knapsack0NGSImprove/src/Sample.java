/**
 * This class defines the item object.
 * Each item has its name, value, and weight.
 * Default number of the item is 1.
 *
 * @author luqing Student ID: 300363602
 */
public class Sample implements Comparable<Sample> {
    //name
    public String name = "";
    //value
    public double value = 0;
    //weight
    public double weight = 0;
    //number regarding 0-1 knapsack the number must be one
    public int number = 1;

    Sample(String _name, double _value, double _weight) {
        name = _name;
        value = _value;
        weight = _weight;
    }
    public int compareTo(Sample arg0) {
        return (int) ((arg0.value / arg0.weight) - (this.value / this.weight));
    }
}
