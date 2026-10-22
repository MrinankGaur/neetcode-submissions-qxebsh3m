class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for(int[] dis:dist){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[]{0,0,0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            
            if(x==row-1 && y==col-1) return d;
            if(dist[x][y] < d) continue;
            
            for(int[] dir: dirs){
                int dx = x + dir[0];
                int dy = y + dir[1];
                if(dx<0 || dy<0 || dx>=row || dy>=col) continue;
                int newDiff = Math.max(d,Math.abs(heights[x][y]-heights[dx][dy]));
                if(newDiff<dist[dx][dy]){
                    dist[dx][dy]= newDiff;
                    pq.offer(new int[]{dx,dy,newDiff});
                }
            }

        }
        return 0;
    }
}