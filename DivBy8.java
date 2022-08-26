/*
Q. Divisibility by 8

Problem Description
You are given a number A in the form of a string. Check if the number is divisible by eight or not.

Return 1 if it is divisible by eight else, return 0.

Problem Constraints
1 <= length of the String <= 100000
'0' <= A[i] <= '9'

Input Format
The only argument given is a string A.

Output Format
Return 1 if it is divisible by eight else return 0.

Example Input
Input 1:
A = "16"

Input 2:
A = "123"


Example Output
Output 1:
1

Output 2:
0

Example Explanation
Explanation 1:
 16 = 8 * 2

Explanation 2:
123 = 15 * 8 + 3

*/

import java.util.*;
class Main {
    public void main(String args[]) {
        int a = isModBy8("4758310052942341036336679074241759053154797537802772");
        System.out.println(a);
    }
    
    public int isModBy8(String A) {
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
	
    // Another way
    public int solve(String A) {
        int n = A.length();
      
        if (n == 0)
            return 0;
      
        int ei = (n>2) ? n-3 : 0;
        long res = 0;
        long ans = 1;
        for(int i=n-1; i>=ei; i--) {
            res = res + (((A.charAt(i)-'0' % 8) * ans % 8) % 8);
            res = res % 8;
            ans = (ans*10) % 8;
        }
        return (res % 8 == 0) ? 1 : 0;
    }
}
