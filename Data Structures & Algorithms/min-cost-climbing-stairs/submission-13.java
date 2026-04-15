class Solution {
    //int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        //Arrays.fill(dp,-1);
        //return Math.min(dfs(cost,0),dfs(cost,1));
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 2;i<=n;i++){
            int temp=Math.min(prev1+cost[i-1],prev2+cost[i-2]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
    // public int dfs(int[] cost, int i){
    //     if(i>=cost.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     return dp[i]=cost[i] + Math.min(dfs(cost,i+1),dfs(cost,i+2));
    // }
}
