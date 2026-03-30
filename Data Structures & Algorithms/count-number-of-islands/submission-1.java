class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count=0;
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,row,col,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r,int c,int i,int j){
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,r,c,i+1,j);
        dfs(grid,r,c,i-1,j);
        dfs(grid,r,c,i,j+1);
        dfs(grid,r,c,i,j-1);
    }

}
