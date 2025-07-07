package dsa.mustafaSaad.sorting;

public class InsertionSort implements ISort {
    @Override
    public void sorting(int[] a) {
        //6 5 2 8 9 4
// we insert into sorted array
        /**
         * first start with  [6] as sorted array
         * second iter i =5 shift with j while 5 <a[j]
         */

        for (int i = 1; i < a.length; i++) {
            int key = a[i];  //keep current val
            int j = i - 1;
            // Shift elements of the sorted part of the array to the right to make space for vi
            while (j > -1 && key < a[j]) { // shift elements to make space for vi
               a[j+1]=a[j];
                j--;
            }
            // Place vi in its correct position
            a[j + 1] = key;
            System.out.print("iteration:" + (i ) + " ->");
            ISort.print(a);
        }

    }

}
