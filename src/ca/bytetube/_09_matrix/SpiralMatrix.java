package ca.bytetube._09_matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * @author dal
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new LinkedList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left<= right){
            //1.left top ----> right top
            for (int i = left; i <= right ; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;

            //2.right top ----> right bottom
            for (int i = top; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            //3.right bottom ----> left bottom
            for (int i = right; i >= left ; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;
            //4.left bottom ----> left top
            for (int i = bottom; i >= top ; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
