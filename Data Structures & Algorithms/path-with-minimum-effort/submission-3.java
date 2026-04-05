class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist = new int[n][m];

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {effort, row, col}
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == m - 1) return effort;

            if (effort > dist[r][c]) continue;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int newEffort = Math.max(
                    effort,
                    Math.abs(heights[r][c] - heights[nr][nc])
                );

                if (newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }
            }
        }

        return 0;
    }
}