import java.util.Arrays;

public class MergeSort {
    static int invCount = 0;

    public static void mergeSort(int[] A) {
        if (A.length > 1) {
            int mid = A.length / 2;

            int[] leftArray = Arrays.copyOfRange(A, 0, mid);
            int[] rightArray = Arrays.copyOfRange(A, mid, A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A, leftArray, rightArray);
        }
    }

    public static void merge(int[] a, int[] l, int[] r) {

        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < l.length) {
            a[k++] = l[i++];
        }
        while (j < r.length) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 8, 5, 7, 6, 10};
        MergeSort.mergeSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}