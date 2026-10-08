class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums);
        
    }
    public int helper(int i,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + helper(i+2,nums);
        int notTake = helper(i+1,nums);
        return dp[i] = Math.max(take,notTake);
    }
}
