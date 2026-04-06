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
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[1];
            int c = curr[2];
            int diff = curr[0];
            if(r==n-1 && c==m-1) return diff;
            if(dist[r][c]<diff) continue;
            for(int[] dir: directions){
                int dr = r + dir[0];
                int dc = c + dir[1];
                if(dr<0 || dc<0 || dr>=n || dc>=m) continue;
                int newDist = Math.max(diff, Math.abs(heights[r][c]-heights[dr][dc]));
                if(newDist<dist[dr][dc]){
                    dist[dr][dc]=newDist;
                    pq.offer(new int[]{newDist,dr,dc});
                }
            }
        }
        return 0;
    }
}