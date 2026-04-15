class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        //Arrays.fill(dp,-1);
        //return helper(n,0,dp);
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int helper(int n, int i,int[] dp){
        if(i>=n) return i==n?1:0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=helper(n,i+1,dp) + helper(n,i+2,dp);

    }
}
