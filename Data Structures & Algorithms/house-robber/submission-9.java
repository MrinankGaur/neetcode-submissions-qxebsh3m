class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0],nums[1]);
        for(int i = 2;i<n;i++){
            int take = nums[i] + prev2;
            int notTake = prev1;
            int curr = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;   
    }
}
