class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int r = 0;r<n;r++){
            sum+=nums[r];
            if(sum>=target){
                while(l<=r && sum>=target){
                    min = Math.min(min,r-l+1);
                    sum-=nums[l++];
                   
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }   
}