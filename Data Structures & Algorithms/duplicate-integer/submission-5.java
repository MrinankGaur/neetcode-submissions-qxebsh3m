class Solution {
    public boolean hasDuplicate(int[] nums) {
       int n = nums.length;
       if(n==0)  return false;
       HashSet<Integer> set = new HashSet<>();
       set.add(nums[0]);
       for(int i = 1;i<n;i++){
        if(set.contains(nums[i])) return true;
        set.add(nums[i]);
       } 
       return false;
    }
}