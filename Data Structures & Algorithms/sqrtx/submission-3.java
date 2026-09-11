class Solution {
    public int mySqrt(int x) {
        int s = 0;
        int e = x;
        int ans = 0;
        while(s<=e){
            int m = s + (e-s)/2;
            if((long)m*m>x){
                e=m-1;
            }
            else if((long)m*m<x){
                s = m+1;
                ans = m;
            }
            else{
                return m;
            }
        }
        return ans;
    }
}