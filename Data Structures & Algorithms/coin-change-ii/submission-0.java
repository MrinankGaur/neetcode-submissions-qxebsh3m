class Solution {
    private int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,amount,coins);
    }
    private int dfs(int index, int amount, int[] coins){
        if(amount==0) return 1;
        if(index==coins.length) return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int notTake = dfs(index+1,amount,coins);
        int take = 0;
        if(coins[index]<=amount){
            take = dfs(index,amount-coins[index],coins);
        }
        return dp[index][amount] = notTake + take;
    }
}
