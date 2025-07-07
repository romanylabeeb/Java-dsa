package dsa.mustafaSaad.sorting;

public class SelectionSort implements ISort {
    @Override
    public void sorting(int[] a) {
        //6 5 2 8 9 4
//        we have two component sorted and unsorted
        // get minval from unsorted and add it in the proper index i in sorted component

        for (int i = 0; i < a.length - 1; i++) {
            int minInd = i; // Assume the smallest element is at the current index 'i'

            // Inner loop to find the index of the smallest element in the unsorted part of the array
            for (int j = i + 1; j < a.length; j++) {
                if (a[minInd] > a[j]) {
                    minInd = j; // Update minInd if a smaller element is found
                }
            }

            // Swap the found smallest element with the element at index 'i'
            if (minInd != i) {
                ISort.swap(a, minInd, i); // Swap only if a smaller element was found
            }

            // Print the array after each outer loop iteration
            System.out.print("Iteration " + (i + 1) + " -> ");
            ISort.print(a); // Assuming ISort.print(a) prints the array
        }

    }
}
