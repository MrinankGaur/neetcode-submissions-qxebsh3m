class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int s = 0,e=n-1;
        int ans = nums[0];
        while(s<=e){
            if(nums[s]<nums[e]){
                ans = Math.min(nums[s],ans);
                break;
            }
            int mid = s + (e-s)/2;
            ans = Math.min(nums[mid],ans); 
            if(nums[mid]>=nums[s]) s = mid+1;
            else e = mid-1;
        }
        return ans;
    }
}
