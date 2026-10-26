class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0;i<=n;i++){
            int cnt = 0;
            int curr = i;
            while(curr>0){
                int x = curr&1;
                if(x==1){
                    cnt++;
                }
                curr=curr>>1;
            }
            res[i] = cnt;
        }
        return res;
    }
}
