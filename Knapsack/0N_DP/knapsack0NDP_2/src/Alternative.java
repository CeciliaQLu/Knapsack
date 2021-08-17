/**
 * THis is the second version of 0-N knapsack problem using dynamic programming.
 *
 * @author luqing Student ID: 300363602
 */
class Alternative {

    public static void main(String[] arg) {

        System.out.println("Another way of solving the 0-N knapsack \nproblem using dynamic programming:\n");
//        int[] value = new int[]{15,12,8};
//        int[] weight = new int[]{7,6,2};
//        int[] size = new int[]{2,1,2};
//        int W=7;

        //int[] value = new int[]{15,12,8}; 
        //int[] weight = new int[]{7,6,2}; 
        //int[] size = new int[]{3,3,4};
        //int W=10;

        //int[] value = new int[]{15,12,8}; 
        //int[] weight = new int[]{7,6,2}; 
        //int[] size = new int[]{13,3,4};
        //int W=20;

        //int[] value = new int[]{15,12,8}; 
        //int[] weight = new int[]{7,6,2}; 
        //int[] size = new int[]{13,13,4};
        //int W=30;

        //int[] value = new int[]{15,12,8}; 
        //int[] weight = new int[]{7,6,2}; 
        //int[] size = new int[]{13,13,14};
        //int W=40;

        int[] value = new int[]{15, 12, 8};
        int[] weight = new int[]{7, 6, 2};
        int[] size = new int[]{13, 13, 24};
        int W = 50;

        int N = value.length;
        DP dp = new DP();

        PrintInf(value, "Value:");
        PrintInf(weight, "Weight:");
        PrintInf(size, "Size:");

        System.out.println("Weight capacity = " + W);
        System.out.println("Best Value = " + dp.maxValue(N, W, size, weight, value));
        System.out.println("Barometer = " + dp.bar);
    }

    /**
     * Print for testing.
     * @param value
     * @param title
     */
    private static void PrintInf(int[] value, String title) {
        String temp = "";
        temp += title + "  [ ";
        for (int i : value) {
            temp += i + ",";
        }
        temp += "]";
        System.out.println(temp);
    }
}


