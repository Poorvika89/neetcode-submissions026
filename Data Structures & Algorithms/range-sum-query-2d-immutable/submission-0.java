class NumMatrix {
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
                    prefixSum = new int[rows + 1][cols + 1];
                                for (int r = 0; r < rows; r++) {
                                                for (int c = 0; c < cols; c++) {
                                                                    prefixSum[r + 1][c + 1] = matrix[r][c] + prefixSum[r][c + 1] + prefixSum[r + 1][c] - prefixSum[r][c];
                                                                                    }
                                                                                                }
                                                                                                        }

                                                                                                                public int sumRegion(int row1, int col1, int row2, int col2) {
                                                                                                                            return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */