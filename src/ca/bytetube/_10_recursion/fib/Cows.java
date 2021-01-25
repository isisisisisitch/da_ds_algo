package ca.bytetube._10_recursion.fib;

public class Cows {
    
    public static int cows(int n){
        if (n <= 4) return n;
        
       return cows(n - 1) + cows(n - 3);
    }
}
