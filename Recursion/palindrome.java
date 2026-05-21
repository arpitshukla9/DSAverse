package Recursion;

public class palindrome {
    public static void main(String[] args) {
        String str = "RAAR";
        int left = 0;
        int right = str.length() - 1;
        boolean isPal = checkPalindrome(left, right, str);
        System.out.println(isPal);
    }
    public static boolean checkPalindrome(int l, int r, String s){
        if(l >= r) return true;
        if(s.charAt(l) != s.charAt(r)) return false;
        return checkPalindrome(l + 1, r - 1, s);
    }
    
}
