package dsa.mustafaSaad.sorting;

public class QuickSort implements ISort {
    @Override
    public void sorting(int[] a) {
        //6 5 2 8 9 4
        // compare each item with the next and swap if current is greater in inner loop
        quickSort(a, 0, a.length - 1);
    }

    /**
     * Base Case:
     *
     * The if (l >= h) condition now correctly handles cases where the subarray has one or zero elements,
     * preventing unnecessary recursive calls.
     * Partition Method:
     *
     * The partition method remains the same, correctly positioning
     * the pivot and ensuring elements less than the pivot are on its left,
     * and greater elements on its right.
     * How It Works:
     * The quickSort method divides the array into smaller subarrays around a pivot
     * and recursively sorts those subarrays.
     * The partition method rearranges the array around the pivot.
     * After running the quickSort function, the entire array will be sorted in place.
     * @param a
     * @param l
     * @param h
     */
    private void quickSort(int[] a, int l, int h) {
        if (l >= h) return;  // Correct base case
        int partitionInd = partition(a, l, h);

        System.out.println("iteration: " + partitionInd);
        ISort.print(a);
        // Sort the left part
        quickSort(a, l, partitionInd - 1);
        // Sort the right part
        quickSort(a, partitionInd + 1, h);
    }

    private int partition(int[] a, int l, int h) {
        int i = l;
        int pivot = a[h];  // Choose the last element as the pivot
        for (int j = l; j < h; j++) {
            if (a[j] < pivot) {
                ISort.swap(a, i++, j);
            }
        }
        ISort.swap(a, i, h);  // Place the pivot in its correct position
        return i;  // Return the index of the pivot
    }

}
