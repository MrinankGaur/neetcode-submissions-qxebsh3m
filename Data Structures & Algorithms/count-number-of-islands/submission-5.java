class Solution {
    private int[][] vis;
    private char[][] grid;
    private int row;
    private int col;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        this.vis = new int[row][col];
        int islands = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int i, int j){
        if(i<0 || j<0 || i>=row || j>=col || vis[i][j]==1 || grid[i][j]=='0') return;
        vis[i][j]=1;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}
