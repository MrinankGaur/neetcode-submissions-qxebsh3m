class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(0,s);   
    }
    public int helper(int i, String s){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int res = helper(i+1,s);
        if(i<s.length()-1){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                res+=helper(i+2,s);
            }
        }
        return dp[i] = res;
    }
}
