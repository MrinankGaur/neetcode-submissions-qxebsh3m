class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return helper(0, s, dp);
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