class Solution {
    private char[][] grid;
    private int row;
    private int col;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        int islands = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int i, int j){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}
