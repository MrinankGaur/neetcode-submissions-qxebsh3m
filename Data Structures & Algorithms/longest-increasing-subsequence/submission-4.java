class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake = dp[i+1][j+1];
                int take = 0;
                if(j==-1 || nums[i]>nums[j]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take,notTake);
            }

        }
        return dp[0][0];
    }
    public int helper(int i, int j, int[] nums){
        if(i == nums.length) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        int notTake = helper(i+1,j,nums);
        int take = 0;
        if(j==-1 || nums[i]>nums[j]){
            take = 1 + helper(i+1,i,nums);
        }
        return dp[i][j+1]=Math.max(take,notTake);
    }
}
