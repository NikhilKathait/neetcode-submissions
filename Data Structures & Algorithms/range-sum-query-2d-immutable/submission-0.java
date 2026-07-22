class NumMatrix {

    private int[][] pSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        pSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                pSum[i][j] = matrix[i - 1][j - 1]
                            + pSum[i - 1][j]
                            + pSum[i][j - 1]
                            - pSum[i - 1][j- 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        row1++;
        col1++;
        row2++;
        col2++;

        return pSum[row2][col2]
                - pSum[row1 - 1][col2]
                - pSum[row2][col1 - 1]
                + pSum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */