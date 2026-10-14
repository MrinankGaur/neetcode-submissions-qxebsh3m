class Solution {
    private int col;
    private int row;
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        row = grid.length;
        col = grid[0].length;
        int max = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    max = Math.max(max,dfs(i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int i, int j){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(i,j+1) + dfs(i,j-1) + dfs(i+1,j) + dfs(i-1,j);
    }
}
