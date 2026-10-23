class Solution {
    private String s1;
    private String s2;
    private int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int n = s1.length();
        int m = s2.length();

        dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0);
    }
    private int helper(int i, int j){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + helper(i+1,j+1);
        }
        return dp[i][j] = Math.max(helper(i+1,j),helper(i,j+1));
    }
}
