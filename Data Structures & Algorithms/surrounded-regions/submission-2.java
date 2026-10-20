class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<row;i++){
            if(board[i][col-1]=='O'){
                q.offer(new int[]{i,col-1});
            }
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
            }
        }
        for(int i=0;i<col;i++){
            if(board[row-1][i]=='O'){
                q.offer(new int[]{row-1,i});
            }
            if(board[0][i]=='O'){
                q.offer(new int[]{0,i});
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            board[x][y] = 'M';
            for(int[] dir:dirs){
                int dx = x + dir[0];
                int dy = y + dir[1];
                if(dx<0 || dy<0 || dx>=row || dy>=col || board[dx][dy]!='O') continue;
                q.offer(new int[]{dx,dy});
            }
        }
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='M'){
                    board[i][j]='O';
                }
            }
        }
        
    }
}
