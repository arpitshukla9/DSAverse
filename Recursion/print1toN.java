package Recursion;

public class print1toN {
    public static void main(String[] args) {
        printNForward(10);
        System.out.println("----------------------------");
        printNBack(10);
    }

    public static void printNForward(int n) {
        // Base case: stop when we hit 0
        if (n == 0) return;
        // Wait! Call the function first with a smaller number
        printNForward(n - 1);
        // Print on the way back out of the recursion
        System.out.println(n);
    }
    public static void printNBack(int n) {
        if (n == 0 ) return;
        System.out.println(n);
        printNBack(n - 1);
    }
}