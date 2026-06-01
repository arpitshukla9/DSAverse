package ALGORITHM.HashMapandSet;

import java.util.HashSet; // HashSet -> Unordered collection that does not allow duplicate elements. It is based on the hash code of the elements and provides constant-time performance for basic operations like add, remove, and contains.
import java.util.TreeSet;

public class sets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 10, 2, 3, 4, 5, 6, 6, 6};
        HashSet<Integer> set = new HashSet<>();
        System.out.println("==============================================================");
        System.out.println("        HASHSET DEMO - DUPLICATE REMOVAL but unordered       ");
        System.out.println("==============================================================");
        System.out.println("Length of arr before insert to SET : " + arr.length);
        System.out.println("--------------------------------------------------");

        // Normal For Loop is not suitable for HashSet because it does not maintain the order of elements and hume index nh pata hta.
        for (int i : arr) {
            set.add(i);
        }
        System.out.println("Length of arr after insert to SET : " + set.size());
        System.out.println("--------------------------------------------------");
        System.out.println("Unique values in SET:");
        for (int value : set) {
            System.out.println("   -> " + value);
        }
        System.out.println("==============================================");
        treeSet();

    }
    static void treeSet(){
        //TREESET  -> DERIVE FROM Balanced BST
        //-> A TreeSet is a sorted collection that does not allow duplicate elements. 
        // It is based on a Red-Black tree and provides log(n) time complexity for basic operations like 
        // add, remove, and contains. The elements in a TreeSet are stored in a sorted order, 
        // which allows for efficient retrieval of the minimum and maximum elements.
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] arr = {1, 2, 1, 10, 2, 3, 4, 5, 6, 6, 6};
        System.out.println("==============================================================");
        System.out.println("        TREESET DEMO - DUPLICATE REMOVAL but ordered and sorted      ");
        System.out.println("==============================================================");
        System.out.println("Length of arr before insert to SET : " + arr.length);
        System.out.println("--------------------------------------------------");

        // Normal For Loop is not suitable for TreeSet because it does not maintain the order of elements and hume index nh pata hta.
        for (int i : arr) {
            treeSet.add(i);
        }
        System.out.println("Length of arr after insert to SET : " + treeSet.size());
        System.out.println("--------------------------------------------------");
        System.out.println("Unique values in SET:");
        for (int value : treeSet) {
            System.out.println("   -> " + value);
        }
        System.out.println("==============================================");

    }

}
