package dsa.mustafaSaad.sorting;

public interface ISort {
    void sorting(int[] a);

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    static void print(int[]a){
        for(int v: a){
            System.out.print(v+" ");
        }
        System.out.println();
    }
}
