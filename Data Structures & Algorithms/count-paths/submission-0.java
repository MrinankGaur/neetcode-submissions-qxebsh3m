class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(m-1,n-1);
    }
    public int helper(int m,int n){
        if(m==0 && n==0){
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int up = 0;
        if(m-1>=0) up = helper(m-1,n);
        int left = 0;
        if(n-1>=0) left = helper(m,n-1);
        return dp[m][n] = up + left;
    }
}
