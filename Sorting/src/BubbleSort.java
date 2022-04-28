public class BubbleSort {

    public static void sort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j + 1] < A[j]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] Arr = { 5, 3, 8, 2, 0, 78, 1, 6 };
        BubbleSort.sort(Arr);
        for (int i = 0; i < Arr.length; i++) {
            System.out.println(Arr[i]);
        }
//        int[] A = new int[100000];
//
//        for (int i = 0; i < 100000; i++) {
//            A[i] = i;
//        }
//        long startTime = System.currentTimeMillis();
//        BubbleSort.sort(A);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time Taken:: " + (endTime - startTime));
    }
}
