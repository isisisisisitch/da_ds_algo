package ca.bytetube._10_recursion_dp.hanoi;

public class MinPath {
    public static void main(String[] args) {
        int[][] matrix = {{3,1,0,2},{4,3,2,1},{5,2,1,0}};
        System.out.println(minPath(matrix));
    }

    /**
     *这个方法的作用：求从（i，j）点开始到右下角点的最小路径和
     */
    public static int minPath(int[][] matrix,int i,int j){//i,j表示起点的坐标
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }

        //1.最后一行的点
        if (i == matrix.length - 1) {
           return matrix[i][j] + minPath(matrix,i,j+1);
        }
        //2.最后一列的点
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPath(matrix,i+1,j);
        }
        //3.普通的点

        int right = minPath(matrix,i,j+1);
        int down = minPath(matrix,i+1,j);
        return matrix[i][j] + Math.min(right , down);

    }

    public static int minPath(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {//第一列
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {//第一行
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }

        //普通位置
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
               dp[i][j] =  Math.min(dp[i][j - 1] , dp[i - 1][j] )+matrix[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }

}
