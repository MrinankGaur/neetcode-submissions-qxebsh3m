class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        dp = new Boolean[n][(sum/2)+1];
        return helper(0,sum/2,nums);
    }
    public boolean helper(int i,int target, int[] nums){
        if(target==0) return true;
        if(target<0 || i==nums.length) return false;
        if(dp[i][target] != null) return dp[i][target];
        boolean notTake = helper(i+1,target,nums);
        boolean take = helper(i+1,target-nums[i],nums);
        return dp[i][target] = notTake || take;
    }
}
