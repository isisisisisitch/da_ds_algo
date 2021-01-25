package ca.bytetube._10_recursion.hanoi;

public class MinPath {
    public static void main(String[] args) {
        int[][] matrix = {{3,1,0,2},{4,3,2,1},{5,2,1,0}};
        System.out.println(minPath(matrix,0,1));
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
}
