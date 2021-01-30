package ca.bytetube._10_recursion_dp.hanoi;

public class PrintSubsequence {
    public static void main(String[] args) {
        printSubsequence("abc",0,"");
    }

    public static void printSubsequence(String s, int i,String res){
        if (i == s.length()) {
            System.out.println(res);
            return;
        }

        printSubsequence(s, i+1,res);
        printSubsequence(s, i+1,res+ s.charAt(i));

    }
}
