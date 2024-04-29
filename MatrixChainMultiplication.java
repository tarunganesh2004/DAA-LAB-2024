public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Number of matrices
        int[][] m = new int[n + 1][n + 1]; // Adjusted dimensions

        // For a single matrix, the cost is 0.
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        // For chains of length 2 to n
        for (int chainLen = 2; chainLen <= n; chainLen++) {
            for (int i = 1; i <= n - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) { // Adjusted loop condition
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }
        return m[1][n]; // Return the minimum number of scalar multiplications needed for the entire
                        // chain
    }

    public static void main(String[] args) {
        int[] p = { 10, 30, 5, 60 }; // Dimensions of matrices: A1(10x30), A2(30x5), A3(5x60)
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(p));
    }
}
