class Solution {
    public void sortColors(int[] nums) {
        int e = nums.length-1;
        int s = 0, m= 0;
        while(m<=e){
            switch(nums[m]){
                case 0:
                    swap(s,m,nums);
                    s++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(m,e,nums);
                    e--;
                    break;
            }   

        } 
    }
    private void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}