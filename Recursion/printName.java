package Recursion;

public class printName{
    public static void main(String[] args) {
        prtName("Arpit", 5);
    }
    public static void prtName(String s, int n){
        if (n == 0) return;
        System.out.println(s);
        prtName(s, n-1);
    }
}