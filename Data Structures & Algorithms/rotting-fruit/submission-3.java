class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid[0].length==0) return 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; 
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0;i<row;i++){
            for(int j= 0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int minutes = 0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int dx = curr[0] + dir[0];
                    int dy = curr[1] + dir[1];
                    if(dx<0 || dy<0 || dx>=row || dy>=col || grid[dx][dy]!=1) continue;
                    grid[dx][dy]=2;
                    fresh--;
                    q.add(new int[]{dx,dy});
                }
            }
            minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}
