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
    public  int noOfDays(int[] arr,int x){
        int res = 1;
        int weight = 0;
        for(int i=0;i<arr.length;i++){
            if(weight+arr[i]>x){
                res++;
                weight= arr[i];
            }
            else{
                weight+=arr[i];
            }
        }
        return res;
    }
}