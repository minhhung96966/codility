package prefixsum.range_sum_query_2d;

public class NumMatrix {
    private int[][] prefixMatrix;

    public NumMatrix(int[][] matrix) {
        int[][] prefixMatrix = new int[matrix.length][matrix[0].length];

        // first for loop access the individual array
        // inside the 2d array
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            // second for loop access each element inside the row
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                prefixMatrix[i][j] = sum;
            }
        }

        this.prefixMatrix = prefixMatrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int preRight = prefixMatrix[i][col2];
            int preLeft = col1 > 0 ? prefixMatrix[i][col1 - 1] : 0;
            sum += (preRight - preLeft);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] array = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(array);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)

        int[][] array1 = {
                {-4, -5}
        };
        NumMatrix numMatrix1 = new NumMatrix(array1);
        System.out.println(numMatrix1.sumRegion(0,0,0,0)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix1.sumRegion(0,0,0,1)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix1.sumRegion(0,1,0,1)); // return 12 (i.e sum of the blue rectangle)
    }
}
