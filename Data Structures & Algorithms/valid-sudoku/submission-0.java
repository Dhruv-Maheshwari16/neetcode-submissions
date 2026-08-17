class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,List<Character>> square_map = new HashMap<>();
        HashMap<Integer,List<Character>> row_map = new HashMap<>();
        HashMap<Integer,List<Character>> col_map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            square_map.put(i+1, new ArrayList<>());
            row_map.put(i+1, new ArrayList<>());
            col_map.put(i+1, new ArrayList<>());
        }

        for(int row = 0 ; row < 9 ; row++) {
            for(int col = 0 ; col < 9 ; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(row_map.get(row + 1).contains(board[row][col]) || 
                    col_map.get(col + 1).contains(board[row][col]) || 
                    square_map.get((row/3) * 3 + (col/3 + 1)).contains(board[row][col])) {
                    return false;
                }
                else {
                    row_map.get(row + 1).add(board[row][col]);
                    col_map.get(col + 1).add(board[row][col]);
                    square_map.get((row/3)*3+(col/3) + 1).add(board[row][col]);
                }
            }
        }
        return true;
    }
}
