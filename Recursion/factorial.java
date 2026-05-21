package Recursion;

public class factorial {
    public static void main(String[] args) {
        int res = factRecFun(5);
        System.out.println(res);
    }
    static int factRecFun(int a){
        if(a == 0) return 1;
        return a * factRecFun( a - 1);
    }
}
