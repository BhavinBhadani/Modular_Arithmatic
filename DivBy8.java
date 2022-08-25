import java.util.*;
class Main {
    public static void main(String args[]) {
        int a = isModBy8("4758310052942341036336679074241759053154797537802772");
        System.out.println(a);
    }
    
    public static int isModBy8(String A) {
        int n = A.length();
	    
        if (n == 1)
            return ((A.charAt(0)-'0')%8 == 0) ? 1 : 0;
      
        if (n == 2)
            return (((A.charAt(n-2)-'0')*10 + (A.charAt(n-1)-'0'))%8 == 0) ? 1 : 0;
      
        // If number formed by last three digits is
        // divisible by 8.
        int last = A.charAt(n-1) - '0';
        int second_last = A.charAt(n-2) - '0';
        int third_last = A.charAt(n-3) - '0';
      
        return ((third_last*100 + second_last*10 + last) % 8 == 0) ? 1 : 0;
    }
}
