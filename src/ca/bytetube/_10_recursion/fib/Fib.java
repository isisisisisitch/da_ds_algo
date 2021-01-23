package ca.bytetube._10_recursion.fib;

public class Fib {
    public static int fib0(int n){//2^n
        if (n <= 1)  return n;

        return fib0(n-1)+ fib0(n-2);
        
    }

    public static int fib1(int n){
        if (n <= 1)  return n;
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 1;
       return fib1(array,n);

    }

    private static int fib1(int[] array,int n){
        if (array[n] == 0) {//说明第n项的值没有求过
            array[n] = fib1(array,n-1) + fib1(array,n-2);
        }
        return array[n];
    }


    /*
     * 滚动数组
     *fib(3)---> n = 3     3%2 = 1
     * fib(4)---> n = 4    4%2 = 0
     *
     * fib(5)---> n = 5  5% 2 = 1
     * fib(6) ---> n = 6 6% 2 = 0
     *
     */
    public static int fib2(int n){
        if (n <= 1)  return n;
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 1;
        for (int i = 3; i <= n ; i++) {
            array[i&1] = array[(i-1)&1] + array[(i-2)&1];
        }

        return array[n%2];
    }

    public static void main(String[] args) {
        fib2(3);
    }
}
