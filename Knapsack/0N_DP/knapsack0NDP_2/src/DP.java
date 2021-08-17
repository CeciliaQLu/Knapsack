/**
 * THis is the second version of 0-N knapsack problem using dynamic programming.
 *
 * @author luqing Student ID: 300363602
 */
public class DP {
    public int bar = 0;
    public int maxValue(int N, int W, int[] s, int[] v, int[] w) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= v[i]; j--) {
                for (int k = 0; k <= s[i] && j >= k * v[i]; k++) {
                    bar++;
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[W];
    }
}
