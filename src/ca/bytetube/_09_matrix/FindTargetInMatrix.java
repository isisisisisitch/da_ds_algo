package ca.bytetube._09_matrix;

public class FindTargetInMatrix {
    public static boolean FindTargetInMatrix(int[][] matrix, int target){
        if (matrix == null) return false;

        //从右上角点出发
        int R = 0;
        int C = matrix[0].length - 1;
        while (R <= matrix.length -1 && C >= 0){
            if (matrix[R][C] == target) {
                return true;
            }else if (matrix[R][C] > target) {
                C--;
            }else {
                R++;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(FindTargetInMatrix(matrix,19));
    }
}
