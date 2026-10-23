class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,n,nums);
    }
    public int helper(int i, int prev, int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][prev]!=-1) return dp[i][prev];
        
        int notTake =  helper(i+1,prev,nums);
        int take = 0;
        
        if(prev==nums.length || nums[i]>nums[prev]){
            take = 1 + helper(i+1,i,nums);
        }
        
        return dp[i][prev] = Math.max(take,notTake);
    }
}
