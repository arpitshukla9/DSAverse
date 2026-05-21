package Recursion;

public class sumOfno {
    public static void main(String[] args) {
        sumParameterizedway(5, 0);
        System.out.println("---------------------------");
        int res = sumFuncRecursion(3);
        System.out.println(res);
    }
    public static void sumParameterizedway(int a, int sum){
        if(a < 1) {
            System.out.println(sum);
            return;
        }
        sumParameterizedway( a - 1, sum + a);
    }

    public static int sumFuncRecursion(int b){
        if(b == 0) return 0;
        return  b + sumFuncRecursion(b-1);
    }
}
