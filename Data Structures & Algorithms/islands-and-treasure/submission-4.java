class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid[0].length==0) return;
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==0){
                    q.offer(new Pair(i,j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int[] dir : dirs) {
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if (x < 0 || y < 0 || x >= row || y >= col) {
                    continue;
                }
                if (grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[x][y] = grid[curr.x][curr.y] + 1;
                q.offer(new Pair(x, y));
            }
        }
    }
}
class Pair{
    int x;
    int y;
    
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
