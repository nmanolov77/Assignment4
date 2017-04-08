package lab5;

/**
 * Purpose: to write and implement the knapsack algorithm using the data from
 * the values and weight arrays.
 * @author Nick Manolov
 * version 1.0
 * C202
 */
public class Lab5 {

    int[] values = {10, 40, 30, 50, 20, 70, 80, 90}; //items value
    int[] weight = {5, 4, 6, 3, 2, 7, 1, 3}; //items weight

    public int knapSack(int W) {
        int[][] V = new int[values.length + 1][W + 1];
        int[][] keep = new int[values.length + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            V[0][i] = 0;
        }
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= W; j++) {
                if ((weight[i - 1] <= j) && (values[i - 1] + V[i - 1][j - weight[i - 1]]) > V[i - 1][j]) {
                    V[i][j] = values[i - 1] + V[i - 1][j - weight[i - 1]];
                    keep[i][j] = 1;
                } else {
                    V[i][j] = V[i - 1][j];
                    keep[i][j] = 0;
                }
            }
        }
        int K = W;
        for (int i = values.length; i >= 1; i--) {
            if (keep[i][K] == 1) {
                System.out.println(i);
                K = K - weight[i - 1];
            }
        }

        return V[values.length][W];
    }

    public static void main(String[] args) {
        int[] W = {10, 13, 15, 20};
        Lab5 k = new Lab5();
        for (int i = 0; i < W.length; i++) {
            System.out.println("Max weight of " + W[i] + " items in the knapsack is: ");
            System.out.println(k.knapSack(W[i]));
        }

    }

}
