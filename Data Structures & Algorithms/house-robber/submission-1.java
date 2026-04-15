class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,0,nums,dp);
    }
    public int helper(int i,int total,int [] nums,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int  take = helper(i+1,total,nums,dp);
        int notTake = nums[i] + helper(i+2,total+nums[i],nums,dp);
        return dp[i] = Math.max(take,notTake);
    }
}
