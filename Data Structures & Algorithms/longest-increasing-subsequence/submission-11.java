class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,-1,nums);
    }
    public int helper(int i, int j, int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        int notTake =  helper(i+1,j,nums);
        int take = 0;
        if(j==-1 || nums[i]>nums[j]){
            take = 1 + helper(i+1,i,nums);
        }
        return dp[i][j+1] = Math.max(take,notTake);
    }
}
