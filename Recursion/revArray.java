package Recursion;

public class revArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int left = 0;
        int right = arr.length - 1;
        reverseArr(left, right, arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    static int reverseArr(int l,int r, int[] a){
        if(l >= r) return a[r];
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return reverseArr(l + 1, r - 1, a);
    }
    
}
