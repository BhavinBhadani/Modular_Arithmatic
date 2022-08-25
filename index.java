import java.util.*;
class Main {
	public static void main(String args[]) {
        int a = isModBy8("4758310052942341036336679074241759053154797537802772");
        System.out.println(a);
	}
    
    public static int isModBy8(String A) {
        int n = A.length();
      
        if (n == 0)
            return 0;
      
        if(n>2) {
            int sum_of_digits = 0;
            for(int i=n-1; i>n-3; i--) {
                sum_of_digits += A.charAt(i)-'0';
            }
            return (sum_of_digits % 8 == 0) ? 1 : 0;
        }
        return (Integer.parseInt(A)% 8 == 0) ? 1 : 0;
        
                    int sum_of_digits = 0;
            for(int i=n-1; i>n-3; i--) {
                sum_of_digits += A.charAt(i)-'0';
            }
            return (sum_of_digits % 8 == 0) ? 1 : 0;


        // if (n == 1)
        //     return ((A.charAt(0)-'0')%8 == 0) ? 1 : 0;
      
        // // If there is double digit
        // if (n == 2)
        //     return (((A.charAt(n-2)-'0')*10 + (A.charAt(n-1)-'0'))%8 == 0) ? 1 : 0;
      
        // // If number formed by last three digits is
        // // divisible by 8.
        // int last = A.charAt(n-1) - '0';
        // int second_last = A.charAt(n-2) - '0';
        // int third_last = A.charAt(n-3) - '0';
      
        // return ((third_last*100 + second_last*10 + last) % 8 == 0) ? 1 : 0;
    }
    
    public static int solve(int A) {
        for(int i=1; i<=A; i++) {
            if(i*i == A) {
                return i;
            }
        }
        return -1;
    }


    public static void solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = A.size();
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for(int i=0; i<n; i++) {
            int e = A.get(i);
            e--;
            A.set(i, e);
            System.out.println(i + " --> " + e--);
        }
        for(int i=0; i<n; i++) {
            System.out.println(" --> " + A.get(i));
            int ind = A.get(i) % n;
            System.out.println(ind + " --> " + A.get(ind));
            int e = A.get(ind) + n;
            A.set(ind, e);
            System.out.println(ind + " --> " + e);
        }

        for(int i=0; i<n; i++) {
            int e = A.get(i)/n;
            System.out.println("----" + i + " --> " + e);
            A.set(i, e);
        }





            //         int ele = A.get(i);
            // int count = 0;
            // for(int j=0; j<n; j++) {
            //     if(A.get(j) == ele) {
            //         count++;
            //     }
            // }
            // result.add(count);

        //return A;
    }
    
    public static ArrayList<Integer> solveA(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=A.size()-1; i>=0; i--) {
            System.out.println("----" + i + " --> " + A.get(i));
            res.add(A.get(i));
        }

        // int p1 = 0, p2 = A.size()-1;
        // while(p1<p2) {
        //     res.set(p1, A.get(p2));
        //     res.set(p2, A.get(p1));
        //     ++p1; --p2;
        // }
        return res;
    }


    public static int solveB(ArrayList<Integer> A) {
        ArrayList<Integer> pf = prefixSum(A);
        int N = A.size();
        for(int i=0; i<N; i++) {
            int sumLeft = (i==0) ? 0 : pf.get(i-1);
            System.out.println("----" + i + " --> " + pf.get(i));
            int sumRight = pf.get(N-1) - pf.get(i);
            if(sumRight == sumLeft) return i;
        }
        return -1;
    }

    public static ArrayList<Integer> prefixSum(ArrayList<Integer> A) {
        int sum = 0;
        for(int i=0; i<A.size(); i++) {
            sum += A.get(i);
            A.set(i, sum);
        }
        return A;
    }

    public static ArrayList<Integer> prefixSumA(ArrayList<Integer> A, boolean isEven) {
        int sum = 0;
        for(int i=0; i<A.size(); i++) {
            if(i%2 == 0 && isEven) {
                sum += A.get(i);
            } else if(i%2 != 0 && !isEven){
                sum += A.get(i);
            } 

            A.set(i, sum);
        }
        return A;
    }

}