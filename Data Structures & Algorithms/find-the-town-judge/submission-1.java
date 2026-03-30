class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] t : trust){
            int u = t[0] - 1;
            int v = t[1] - 1;

            outdegree[u]++;
            indegree[v]++;
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == n - 1 && outdegree[i] == 0){
                return i + 1;
            }
        }

        return -1;
    }
}