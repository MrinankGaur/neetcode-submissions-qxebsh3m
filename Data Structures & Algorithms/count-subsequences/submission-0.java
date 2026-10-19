class Solution {
    private String s;
    private String t;
    private int[][] dp;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        dp = new int[s.length()+1][t.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if(t.length()>s.length()){
            return 0;
        }
        return dfs(0,0);
    }

    private int dfs(int i, int j){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int notTake = dfs(i+1,j);
        int take = 0;
        if(s.charAt(i)==t.charAt(j)){
            take = dfs(i+1,j+1);
        }
        return dp[i][j] = take + notTake;
    }
}
