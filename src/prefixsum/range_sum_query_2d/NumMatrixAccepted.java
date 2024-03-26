package prefixsum.range_sum_query_2d;

//https://www.youtube.com/watch?v=KE8MQuwE2yA&t=393s
/*
   0 1 2 3
0  2 2 4 6
1  3 0 4 5
2  1 1 5 1

tinh prefix sum nhu binh thuong o moi dong, nhung se cong them above o tren
   0 1 2 3  4
0  0 0 0 0  0
1  0 2 4 8  14
2  0 5 7 15 26
3  0 6 9 22 34

1,2 2,3  = 3,4 - 1,4 - 3,2 + 1,2
 */

import java.util.Arrays;

public class NumMatrixAccepted {
    public int[][] prefixMatrix;

    public NumMatrixAccepted(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefixMatrix = new int[rows + 1][cols + 1];

        // first for loop access the individual array
        // inside the 2d array
        for (int i = 0; i < rows; i++) {
            int prefix = 0;
            // second for loop access each element inside the row
            for (int j = 0; j < cols; j++) {
                prefix += matrix[i][j];  //prefix sum of row
                int above = prefixMatrix[i][j + 1];
                prefixMatrix[i + 1][j + 1] = prefix + above;
            }
        }

        this.prefixMatrix = prefixMatrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixMatrix[row2 + 1][col2 + 1] //bottom right
                - prefixMatrix[row1][col2 + 1]  //above
                - prefixMatrix[row2 + 1][col1]  //left
                + prefixMatrix[row1][col1];     //top left
    }

    public static void main(String[] args) {
        int[][] array = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrixAccepted numMatrix = new NumMatrixAccepted(array);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)

        int[][] array1 = {
                {-4, -5}
        };
        NumMatrixAccepted numMatrix1 = new NumMatrixAccepted(array1);
        System.out.println(numMatrix1.sumRegion(0,0,0,0));
        System.out.println(numMatrix1.sumRegion(0,0,0,1));
        System.out.println(numMatrix1.sumRegion(0,1,0,1));
    }
}
