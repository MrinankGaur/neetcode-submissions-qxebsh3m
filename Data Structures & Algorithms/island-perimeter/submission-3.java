class Solution {
    int row;
    int col;
    int[][] grid;
    int[][] vis;
    public int islandPerimeter(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        this.vis = new int[row][col];

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    return dfs(i,j);
                }
            }
        }
        return 0;
    }
    private int dfs(int x, int y){
        if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0){
            return 1;
        }
        if(vis[x][y]==1){
            return 0;
        }
        vis[x][y]=1;
        return dfs(x,y-1) + dfs(x-1,y) + dfs(x,y+1) + dfs(x+1,y);
    }
}