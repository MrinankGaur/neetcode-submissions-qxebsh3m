class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int it:weights){
            max = Math.max(it,max);
            sum += it;
        }
        int s = max,e=sum;
        int ans = Integer.MAX_VALUE;
        while(s<=e){
            int m = s + (e-s)/2;
            if(noOfDays(weights,m)>days) s = m+1;
            else{
                ans = Math.min(ans,m);
                e = m-1;
            }
        }
        return ans;
    }
    public int noOfDays(int[] arr, int capacity){
        int days = 1;
        int weight = 0;

        for(int w : arr){
            if(weight + w > capacity){
                days++;
                weight = w;
            } else {
                weight += w;
            }
        }

        return days;
    }
}