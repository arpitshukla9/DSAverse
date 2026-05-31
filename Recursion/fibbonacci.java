package Recursion;

public class fibbonacci {
    public static void main(String[] args) {
        int res = fib(5);
        System.out.println(res);
    }
    static int fib(int n){
        if(n <= 1) return n;
        int last = fib(n - 1); //jb tk ye return nh krega ans Slast pr move nh krega STack Space yhi wait krega
        int Slast = fib(n - 2);
        return last + Slast;
    }
}
