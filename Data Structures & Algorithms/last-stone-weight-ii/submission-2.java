class Solution {
    private int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for(int stone:stones){
            stoneSum+=stone;
        }
        int target = (stoneSum + 1)/2;
        dp = new int[stones.length][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,0,stones,stoneSum,target);
    }
    private int dfs(int i, int total, int[] stones, int stoneSum, int target) {
        if(total>=target || i==stones.length){
            return Math.abs(total-(stoneSum-total));
        }
        if(dp[i][total]!=-1) return dp[i][total];
        return dp[i][total] = Math.min(
            dfs(i+1,total,stones,stoneSum,target),
            dfs(i+1,total+stones[i],stones,stoneSum,target)
        );
    }

}