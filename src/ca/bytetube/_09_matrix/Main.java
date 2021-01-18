package ca.bytetube._09_matrix;

public class Main {
    public static void main(String[] args) {
        //格式1
//        int[][] matrix = new int[3][2];
//        System.out.println(matrix);//[[I@61bbe9ba
//        System.out.println(matrix[0]);
//        System.out.println(matrix[1]);
//        System.out.println(matrix[2]);
//        System.out.println(matrix[0][0]);

        //格式2
//        int[][] matrix = new int[3][];
//        matrix[0] = new int[3];
//        matrix[1] = new int[1];
//        matrix[2] = new int[2];

        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
