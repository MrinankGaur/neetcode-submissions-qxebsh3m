class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
            int area = (r-l)*(Math.min(heights[r],heights[l]));
            max = Math.max(area,max);
            if(heights[l]<heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}
