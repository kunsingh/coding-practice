public class InsertionSort {
    public static void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] A = { 5, 3, 8, 2, 0, 78, 1, 6 };
        InsertionSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}