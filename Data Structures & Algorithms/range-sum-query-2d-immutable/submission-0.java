class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        sumMatrix = new int[rows + 1][cols + 1];

        for(int i = 0;i < rows;i++) {
            int prefix = 0;
            for(int j = 0; j < cols ; j++) {
                prefix += matrix[i][j];
                int above = sumMatrix[i][j+1];
                sumMatrix[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalsum = sumMatrix[row2 + 1][col2 + 1];
        int subSum1 = sumMatrix[row1][col2 + 1];
        int subSum2 = sumMatrix[row2 + 1][col1];
        int topleft = sumMatrix[row1][col1];

        return (totalsum - subSum1 - subSum2 + topleft);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */