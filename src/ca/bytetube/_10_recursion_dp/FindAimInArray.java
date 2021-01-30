package ca.bytetube._10_recursion_dp;

public class FindAimInArray {
    public static void main(String[] args) {
        int[] arr = {3,7,2,13};
        System.out.println(findAimInArrayByDP(arr,5));
    }

    //    public static boolean findAimByRecursion(int[] arr, int aim) {
//    if (arr == null) return false;
//    return findAim(arr, aim, 0, 0);
//}
//
//    private static boolean findAim(int[] arr, int aim, int i, int sum) {
//        if (i == arr.length) {
//            return sum == aim;
//        }
//
//        int a = (findAim(arr, aim, i + 1, sum)) ? 1 : 0;
//        int b = (findAim(arr, aim, i + 1, sum + arr[i])) ? 1 : 0;
//
//        return a + b > 0;
//    }
    public static boolean findAimInArrayByRecursion(int[] arr,int aim){
        return findAim(arr,0,0,aim);

    }

    private static boolean findAim(int[] arr,int i, int sum, int aim){
        if (i == arr.length) {
            return false;
        }

        if (sum == aim) {
            return true;
        }

        return findAim(arr,i+1,sum,aim)||findAim(arr,i+1,sum+arr[i],aim);


    }



    public static boolean findAimInArrayByDP(int[] arr,int aim){
        boolean[][] dp = new boolean[arr.length +1 ][aim + 1];//false
        for (int i = 0; i < dp.length; i++) {
        dp[i][aim] = true;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1 ; j >= 0 ; j--) {
                dp[i][j] = dp[i+1][j];
                if (arr[i] + j <= aim) {
                    dp[i][j] = dp[i][j] || dp[i+1][arr[i] + j];
                }
            }
        }
        printMatrix(dp);

        return dp[0][0];
    }

    public static void printMatrix(boolean[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length ; j++) {
                System.out.print(dp[i][j]+"   ");
            }

            System.out.println();
        }

    }
}
