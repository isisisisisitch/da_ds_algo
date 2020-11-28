package ca.bytetube._00_leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author dal
 */
public class ReverseInteger {
    public static int reverse(int x) {
       long res = 0;
       while (x != 0){
           res = res * 10 + x % 10;
           if (res > Integer.MAX_VALUE) return 0;
           if (res < Integer.MIN_VALUE) return 0;
           x = x/10;
       }

        return (int) res;
    }

    public static int reverse2(int x) {
        int res = 0;
        while (x != 0){
            int prevRes = res;
            res = prevRes * 10 + x %10;
            if ((res-x%10)/10 != prevRes) return 0;

            x = x/10;
        }

        return  res;
    }



    public static void main(String[] args) {
        int val = Integer.MAX_VALUE;
        System.out.println(val);//2147483647 (2^31 − 1)
        System.out.println(reverse2(val));
        //7463847412 ---> 0
    }

}
