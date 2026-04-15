class Solution {
    public int tribonacci(int n) {
        //int[] dp = new int[n+1];
        if(n<=2){
            if(n==0) return 0;
            return 1;
        }
        int prev3 = 0;
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 3;i<=n;i++){
            int temp = prev1+prev2+prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;

    }
}