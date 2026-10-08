class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob2(Arrays.copyOfRange(nums,0,nums.length-1)),rob2(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int rob2(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[1],nums[0]);
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
