package ca.bytetube._09_matrix;

public class PrintZ {
    public static void printZ(int[][] matrix){
        //a,b(x,y)
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1){
            printDiagonal(matrix,aR,aC,bR,bC,fromUp);

            //对a,b点做判断
            //只要a点没有来到最后一列时，a的行号不变
            aR = aC == endC ? aR + 1: aR;
            //只要a点没有来到最后一列时，a的列号不断+1，来到最后一列时，a的列号不变
            aC = aC == endC ? aC : aC + 1;
            //只要b点没有来到最后一行时，b的列号不变，来到最后一行时，b的列号+1
            bC = bR == endR ? bC + 1 : bC;
            //只要b点没有来到最后一行时，b的行号不断+1，来到最后一行时，b的行号不变
            bR = bR == endR ? bR: bR + 1;

            fromUp = !fromUp;
        }

    }

    private static void printDiagonal(int[][] matrix, int tR, int tC,
                                      int dR, int dC, boolean fromUp) {
        if (fromUp == true) {//top -->down
            while (tR != dR + 1){
                System.out.print(matrix[tR++][tC--]+" ");
            }

        }else {//down -->top
            while (dR != tR - 1){
                System.out.print(matrix[dR--][dC++]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printZ(matrix);
    }
}
