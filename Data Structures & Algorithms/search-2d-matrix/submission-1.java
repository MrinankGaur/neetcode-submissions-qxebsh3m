class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1]){
                int s = 0,e=m-1;
                while(s<=e){
                    int mid = s + (e-s)/2;
                    if(matrix[i][mid]==target) return true;
                    else if(matrix[i][mid]<target) s = mid+1;
                    else e = mid-1;
                }
            }
        }
        return false;
    }
}
