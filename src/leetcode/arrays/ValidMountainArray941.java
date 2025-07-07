package leetcode.arrays;

public class ValidMountainArray941 {
    public static boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        int lp = 0, n = arr.length, rp = n - 1;
        while (lp < n - 1 && arr[lp + 1] > arr[lp]) lp++;  // increasing 1,2,3,4
        while (rp >lp && arr[rp - 1] > arr[rp]) rp--;   // decreasing  5,4,3,2
        return lp!=0&& rp!=n-1 &&lp == rp;
    }

    public static void main(String[] args) {
        int []a={0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(a));
    }
}
