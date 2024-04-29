public class binarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = binarysearch(arr, x);
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

    public static int binarysearch(int[] a, int k) {
        int n = a.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == k) {
                return m;
            } else if (a[m] < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
