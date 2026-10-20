
class Solution {
    private int[] nums;
    private int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        this.nums = new int[n+2];

        this.nums[0] = 1;
        this.nums[n+1] = 1;

        for(int i = 0; i < n; i++){
            this.nums[i+1] = nums[i];
        }

        dp = new int[n+2][n+2];

        return helper(1, n);
    }

    private int helper(int left, int right) {
        if(left > right) return 0;

        if(dp[left][right] != 0) return dp[left][right];

        int max = 0;

        for(int i = left; i <= right; i++){
            int coins = nums[left-1] * nums[i] * nums[right+1];

            coins += helper(left, i-1);
            coins += helper(i+1, right);

            max = Math.max(max, coins);
        }

        return dp[left][right] = max;
    }
}
