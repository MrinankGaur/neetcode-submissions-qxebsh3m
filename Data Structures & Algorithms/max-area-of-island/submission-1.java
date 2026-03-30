class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1){
                    max = Math.max(bfs(grid,n,m,i,j),max);
                }
            }
        }
        return max;
    }
    public int bfs(int[][] grid,int row, int col,int i,int j){
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        q.offer(new int[]{i,j});
        int size = 1;
        grid[i][j]=0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] arr: dir){
                int dr = r + arr[0];
                int dc = c + arr[1];
                if(dr>=0 && dc>=0 && dr<row && dc<col && grid[dr][dc]==1){
                    q.offer(new int[]{dr,dc});
                    grid[dr][dc]=0;
                    size++;
                }
            }
        }
        return size;
    }
}
