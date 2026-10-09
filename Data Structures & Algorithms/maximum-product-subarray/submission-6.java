class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            int num = nums[i];
            if(num<0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num,num*max);
            min = Math.min(num,num*min);
            res = Math.max(res,max);
        }
        return res;
    }
}
