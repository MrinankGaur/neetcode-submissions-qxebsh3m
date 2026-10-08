class Solution {
    public int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(0,n,cost),helper(1,n,cost));
    }
    public int helper(int i, int n, int[] cost){
        if(i==n-1) return cost[n-1];
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = cost[i] + Math.min(helper(i+1,n,cost),helper(i+2,n,cost));
    }
}
