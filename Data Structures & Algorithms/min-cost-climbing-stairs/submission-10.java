class Solution {
    //int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        //Arrays.fill(dp,-1);
        //return Math.min(dfs(cost,0),dfs(cost,1));
        for(int i = 2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    // public int dfs(int[] cost, int i){
    //     if(i>=cost.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     return dp[i]=cost[i] + Math.min(dfs(cost,i+1),dfs(cost,i+2));
    // }
}
