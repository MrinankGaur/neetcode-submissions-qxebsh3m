class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n,0,dp);
    }
    public int helper(int n, int i,int[] dp){
        if(i>=n) return i==n?1:0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=helper(n,i+1,dp) + helper(n,i+2,dp);

    }
}
