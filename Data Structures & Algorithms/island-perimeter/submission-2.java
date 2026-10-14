class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] visited = new int[row][col];
        
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = 1;
                    int perimeter = 0;

                    while(!q.isEmpty()){
                    int[] curr = q.poll();
                    int x = curr[0];
                    int y = curr[1];
                        for(int[] dir:dirs){
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if(nx<0 || ny<0 || nx>=row || ny>=col || grid[nx][ny]==0){
                                perimeter++;
                            }else if(visited[nx][ny]==0){
                                visited[nx][ny]=1;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}