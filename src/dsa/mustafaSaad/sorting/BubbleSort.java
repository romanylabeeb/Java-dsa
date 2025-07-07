package dsa.mustafaSaad.sorting;

public class BubbleSort implements ISort {
    @Override
    public void sorting(int[] a) {
        //6 5 2 8 9 4
        // compare each item with the next and swap if current is greater in inner loop
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 1; j < a.length-i; j++) {
                if (a[j - 1] > a[j]) {
                    ISort.swap(a, j - 1, j);
                }
            }
            System.out.print("iteration:"+(i+1)+" ->");
            ISort.print(a);
        }
    }
}
