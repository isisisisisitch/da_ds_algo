package ca.bytetube._10_recursion_dp.fib;

public class ClimbStairs {
    public static int climbStairs0(int n){//2^n
        if (n <= 1)  return n;
        return climbStairs0(n-1)+ climbStairs0(n-2);
        
    }

    public static int climbStairs1(int n){
        if (n <= 1)  return n;
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 1;
       return climbStairs1(array,n);

    }

    private static int climbStairs1(int[] array,int n){
        if (array[n] == 0) {//说明第n项的值没有求过
            array[n] = climbStairs1(array,n-1) + climbStairs1(array,n-2);
        }
        return array[n];
    }


    /*
     * 滚动数组
     *climbStairs(3)---> n = 3     3%2 = 1
     * climbStairs(4)---> n = 4    4%2 = 0
     *
     * climbStairs(5)---> n = 5  5% 2 = 1
     * climbStairs(6) ---> n = 6 6% 2 = 0
     *
     */
    public static int climbStairs2(int n){
        if (n <= 1)  return n;
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 1;
        for (int i = 3; i <= n ; i++) {
            array[i&1] = array[(i-1)&1] + array[(i-2)&1];
        }

        return array[n&1];
    }

    public static int climbStairs(int n){
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        //n表示整个累加的过程
        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }

    public static void main(String[] args) {
        climbStairs(3);
    }
}
