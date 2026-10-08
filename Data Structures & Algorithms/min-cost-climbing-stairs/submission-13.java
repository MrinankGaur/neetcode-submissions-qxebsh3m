class Solution {
    public int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    public int helper(int i, int[] cost){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = cost[i] + Math.min(helper(i+1,cost),helper(i+2,cost));
    }
}
