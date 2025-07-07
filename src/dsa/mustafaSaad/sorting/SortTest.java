package dsa.mustafaSaad.sorting;

public class SortTest {
    public static void main(String[] args) {
        System.out.println("bubble sort");
        int[] a = {6, 5, 2, 8, 9, 4};
        ISort sortObj = new BubbleSort();
        sortObj.sorting(a);

        System.out.println("selection sort");

        a = new int[]{6, 5, 2, 8, 9, 4};
        sortObj = new SelectionSort();
        sortObj.sorting(a);

        System.out.println("insertion sort");
        a = new int[]{6, 5, 2, 8, 9, 4};
        sortObj = new InsertionSort();
        sortObj.sorting(a);

        System.out.println("Quick sort");
        a = new int[]{6, 5, 2, 8, 9, 4};
        sortObj = new QuickSort();
        sortObj.sorting(a);

        System.out.println("Merge sort");
        a = new int[]{6, 5, 2, 8, 9, 4};
        sortObj = new MergeSort();
        sortObj.sorting(a);
//        ISort.print(a);
    }
}
