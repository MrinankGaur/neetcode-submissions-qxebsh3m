public class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;
    int ROWS;
    int COLS;
    private int dfs(int[][] matrix, int r, int c, int prevVal) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != -1) return dp[r][c];

        int res = 1;
        for (int[] d : directions) {
            res = Math.max(res, 1 + dfs(matrix, r + d[0],c + d[1], matrix[r][c]));
        }
        return dp[r][c] = res;
    }

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dp = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dp[i][j] = -1;
            }
        }
        int LIP = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                LIP = Math.max(LIP, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }
        return LIP;
    }
}