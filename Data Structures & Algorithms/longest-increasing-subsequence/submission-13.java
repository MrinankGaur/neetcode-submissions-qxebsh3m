class Solution {
    private int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,n,nums);
    }
    public int helper(int curr, int prev, int[] nums){
        if(curr==nums.length){
            return 0;
        }

        if(dp[curr][prev]!=-1) return dp[curr][prev];

        int nt = helper(curr+1, prev, nums);
        int t = 0;
        if(prev==nums.length || nums[curr]>nums[prev]){
            t = 1 + helper(curr+1, curr, nums);
        }
        return dp[curr][prev] = Math.max(t,nt);
    }
}
