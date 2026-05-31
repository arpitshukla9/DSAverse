package Recursion;

import java.util.ArrayList;

public class subsequence {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        sub(0, arr, new ArrayList<>());
    }
    static void sub(int idx, int[] arr, ArrayList<Integer> result){
        if(idx >= arr.length){
            System.out.println(result);
            return;
        }
        result.add(arr[idx]); 
        sub(idx + 1, arr, result); //ye line jab execute hogi to result me idx pr element add ho jayega aur fir sub function call hoga aur idx + 1 krke next element pr move kr jayega
        result.remove(result.size() - 1);
        sub(idx + 1, arr, result); //ye line jab execute hogi to result me idx pr element remove ho jayega aur fir sub function call hoga aur idx + 1 krke next element pr move kr jayega
    }
}


// Output:
// [3, 1, 2]
// [3, 1]
// [3, 2]
// [3]
// [1, 2]
// [1]
// [2]
// []

// Recursive tree:
//                            (idx=0)
//                           /      \
//                    [3](idx=1)    (idx=1)
//                      /    \       /    \
//                  [3,1]  [3]      [1]   []
//                  (idx=2) (idx=2) (idx=2) (idx=2)
//                   / \     / \     / \     / \
//              [3,1,2] [3,1] [3,2] [3] [1,2] [1] [2] []
//              (idx=3) (idx=3) (idx=3) (idx=3) (idx=3) (idx=3) (idx=3) (idx=3)