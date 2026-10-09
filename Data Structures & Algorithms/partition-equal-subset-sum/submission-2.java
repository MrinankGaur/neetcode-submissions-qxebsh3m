class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        
        int target = sum/2;
        boolean[][] dp = new boolean[n+1][target+1];
        
        for(int i = 0;i<=n;i++){
            dp[i][0] = true;
        }
        
        for(int i = n-1;i>=0;i--){
            for(int j = 1;j<=target;j++){
                boolean notTake = dp[i+1][j];
                boolean take = (j>=nums[i])?dp[i+1][j-nums[i]]:false;
                dp[i][j] = notTake || take;
            }
        }
        
        return dp[0][target];
    }
}
