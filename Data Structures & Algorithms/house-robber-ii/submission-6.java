class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(rob2(nums,0,n-1),rob2(nums,1,n));
    }
    public int rob2(int[] nums, int start, int end){
        if(end-start==1) return nums[start];
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start+1],nums[start]);
        for(int i = start+2;i<end;i++){
            int take = nums[i] + prev2;
            int notTake = prev1;
            int curr = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
