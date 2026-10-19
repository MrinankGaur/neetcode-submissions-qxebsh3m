class Solution {
    private int[][] dp;

    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }

        int target = stoneSum / 2;

        dp = new int[stones.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, stones, stoneSum, target);
    }

    private int dfs(int i, int total, int[] stones,
                    int stoneSum, int target) {
        if (total > target) {
            return Integer.MAX_VALUE;
        }

        if (i == stones.length || total == target) {
            return Math.abs(stoneSum - 2 * total);
        }

        if (dp[i][total] != -1) {
            return dp[i][total];
        }

        int skip = dfs(i + 1, total, stones, stoneSum, target);
        int take = dfs(i + 1, total + stones[i], stones, stoneSum, target);

        return dp[i][total] = Math.min(skip, take);
    }
}