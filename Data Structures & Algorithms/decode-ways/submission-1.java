class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i = 2;i<=n;i++){
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(oneDigit>=1){
                dp[i] += dp[i-1];
            }
            if(twoDigit>=10 && twoDigit<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }

    private int helper(int i, String s, Integer[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != null) return dp[i];
        int ways = 0;
        ways += helper(i + 1, s, dp);
        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                ways += helper(i + 2, s, dp);
            }
        }
        return dp[i] = ways;
    }
}