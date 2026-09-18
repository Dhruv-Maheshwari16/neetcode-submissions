class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;

        while(left <= right) {
            mid = right - (right/2 - left/2);

            if(matrix[mid][0] < target) {
                if(matrix[mid][matrix[mid].length - 1] < target) {
                    left = mid + 1;
                }
                else if(matrix[mid][matrix[mid].length - 1] > target) {
                    break;
                }
                else {
                    return true;
                }
            }
            else if(matrix[mid][0] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        int l = 0;
        int r = matrix[mid].length - 1;
        while(l <= r) {
            int m = r - (r/2 - l/2);
            if(matrix[mid][m] < target) {
                l = m + 1;
            }
            else if(matrix[mid][m] > target) {
                r = m - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
