package DP;

public class BasicsOfDP {

    // Recursive Fibonacci
   public static int fibonacci(int n) {
       if (n <= 1) return n;
       return fibonacci(n - 1) + fibonacci(n - 2);
   }

   // Memoized Fibonacci
   public static int fibonacciMemo(int n, int[] memo) {
       if (n <= 1) return n;
       if (memo[n] != 0) return memo[n];
       memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
       return memo[n];
   }

   // Tabulated Fibonacci
   public static int fibonacciTab(int n) {
       if (n <= 1) return n;
       int[] dp = new int[n + 1];
       dp[1] = 1;
       for (int i = 2; i <= n; i++) {
           dp[i] = dp[i - 1] + dp[i - 2];
       }
       return dp[n];
   }

   public static void main(String[] args) {
       int n = 10;
       System.out.println("Fibonacci (Recursive): " + fibonacci(n));
       System.out.println("Fibonacci (Memoization): " + fibonacciMemo(n, new int[n + 1]));
       System.out.println("Fibonacci (Tabulation): " + fibonacciTab(n));
   }
}
