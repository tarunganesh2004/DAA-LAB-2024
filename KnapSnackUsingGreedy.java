public class KnapSnackUsingGreedy {
    public static void main(String[] args) {
        int[] weight = { 10, 20, 30 };
        int[] profit = { 60, 100, 120 };
        int capacity = 50;
        System.out.println("Maximum profit: " + knapSnack(weight, profit, capacity));
    }

    public static int knapSnack(int[] w, int[] p, int capacity) {
        int n = w.length;
        int totalProfit = 0;
        double[] ratio = new double[n]; // ratio of profit to weight
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) p[i] / w[i];

        }
        // sort the ratio array in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;

                    int tempProfit = p[i];
                    p[i] = p[j];
                    p[j] = tempProfit;

                    int tempWeight = w[i];
                    w[i] = w[j];
                    w[j] = tempWeight;
                }
            }
        }
        // Add items to knapsnack until capacity is full
        for (int i = 0; i < n; i++) {
            if (capacity >= w[i]) {
                totalProfit = totalProfit + p[i];
                capacity = capacity - w[i];
            } else {
                totalProfit = totalProfit + (int) (capacity * ratio[i]);
                break;
            }
        }
        return totalProfit;
    }
}
