package Recursion;

public class print1toNBacktrack {
    
    public static void printNos(int n) {
        print(1, n);
    }
    
    private static void print(int i, int n) {
        // Base case
        if (i > n) {
            return;
        }
        
        // Recursive call first (backtrack)
        print(i + 1, n);
        
        // Print after recursive call (backtracking)
        System.out.println(i);
    }
    
    public static void main(String[] args) {
        printNos(5);
    }
}
