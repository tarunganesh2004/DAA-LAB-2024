public class mergeSortAlgorithm {
    public static void main(String[] args) {
        int[] arr={10, 7, 9, 2, 8, 3, 5, 4, 6, 1};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1]; // Left array
        int[] R = new int[n2]; // right array

        // Copy elements to left array
        for (int i = 0; i < n1; i++) {
            L[i] = a[low + i];
        }
        // Copy elements to right array
        for (int j = 0; j < n2; j++) {
            R[j] = a[mid + 1 + j];
        }

        // merge the two arrays
        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while (i < n1) {
            a[k++] = L[i++];
        }
        while (j < n2) {
            a[k++] = R[j++];
        }
    }
}
