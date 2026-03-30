class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bot = row-1;
        while(top<=bot){
            int mid = top + (bot-top)/2;
            if(matrix[mid][col-1]<target){
                top = mid+1;
            }
            else if(matrix[mid][0]>target){
                bot = mid-1;
            }
            else break;
        }
        if (!(top <= bot)) {
            return false;
        }
        int i = top + (bot-top)/2;
        int left = 0,right = col-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][mid]<target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
