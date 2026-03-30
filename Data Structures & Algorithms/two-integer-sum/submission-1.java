class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            int check = target-nums[i];
            if(map.containsKey(nums[i])){
                ans[1] = i;
                ans[0] = map.get(nums[i]);
            }
            map.put(check,i);
        }
        
       
        return ans;
    }
}
