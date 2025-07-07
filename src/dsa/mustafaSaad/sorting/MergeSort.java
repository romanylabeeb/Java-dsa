package dsa.mustafaSaad.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MergeSort implements ISort {
    @Override
    public void sorting(int[] a) {
        //6 5 2 8 9 4
        // compare each item with the next and swap if current is greater in inner loop
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int l, int h) {

        if (l >= h) return;
        int mid = l + (h - l) / 2;
        ;
        mergeSort(a, l, mid); //left
        mergeSort(a, mid + 1, h);  //right

        // merge two parts
        merging(a, l, mid, h);
    }

    private void merging(int[] a, int l, int mid, int h) {

        int[] lArr = Arrays.copyOfRange(a, l, mid + 1);
        int[] rArr = Arrays.copyOfRange(a, mid + 1, h + 1);

        int n1 = lArr.length;
        int n2 = rArr.length;
        int lp = 0;
        int rp = 0;
        int k = l;

        while (lp < n1 && rp < n2) {
            // check left val with right val
            a[k++] = lArr[lp] <= rArr[rp] ? lArr[lp++] : rArr[rp++];
        }
        while (lp < n1) {
            a[k++] = lArr[lp++];
        }

        while (rp < n2) {
            a[k++] = rArr[rp++];
        }

    }

    /**
     * Temporary Array (lArr):
     * <p>
     * You create a temporary array lArr to store the left half of the elements from the array a.
     * Pointers:
     * <p>
     * lp (left pointer) is used to traverse lArr.
     * rp (right pointer) is used to traverse the right half of the original array a.
     * k is the index for placing merged elements back into the original array a.
     * Merging Process:
     * <p>
     * The while loop compares elements from lArr and the right half of a,
     * and places the smaller element into a[k].
     * The pointer for the array from which the element was taken is incremented.
     * After the loop, if there are any remaining elements in lArr, they are copied into a.
     * Handling Remaining Elements:
     * <p>
     * The remaining elements in lArr are copied back into a, as they are already in sorted order.
     * If there are remaining elements in the right half, they are already in their correct place,
     * so no additional operations are needed.
     *
     * @param a
     * @param l
     * @param mid
     * @param h
     */
    private void mergeOnArray(int[] a, int l, int mid, int h) {
        // Create a temporary array for the left half
        int[] lArr = Arrays.copyOfRange(a, l, mid + 1);
        HashMap<Integer,String>f=new HashMap<>();
        f.put(3,"sd");
        int lp = 0; // Pointer for the left array (lArr)
        int rp = mid + 1; // Pointer for the right half in the original array
        int k = l; // Pointer for the original array

        // Merge the left half (from lArr) and the right half
        while (lp < lArr.length && rp <= h) {
            a[k++] = lArr[lp] <= a[rp] ? lArr[lp++] : a[rp++];
        }

        // Copy remaining elements from lArr (if any)
        while (lp < lArr.length) {
            a[k++] = lArr[lp++];
        }
    }


}
