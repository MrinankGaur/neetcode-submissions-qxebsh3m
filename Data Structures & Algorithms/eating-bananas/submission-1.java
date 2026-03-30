class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int it:piles){
            max = Math.max(it,max);
        } 
        int s = 1,e=max;
        int min = Integer.MAX_VALUE;
        while(s<=e){
            int m = s + (e-s)/2;
            if(time(piles,m)>h) s = m+1;
            else{
                min = Math.min(min,m);
                e = m-1;
            }
        }
        return min;
    }
    public int time(int[] arr,int x){
        int res = 0;
        for(int it:arr){
            if(it%x==0) res+=it/x;
            else res+=(it/x) + 1;
        }
        return res;
    }
}
