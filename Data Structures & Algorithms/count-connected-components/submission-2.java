class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        
        }

        int res = 0;
        int[] vis = new int[n];

        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,adj);
                res++;
            }
        }
        return res;
    }
    private void dfs(int node, int[] vis, List<List<Integer>> adj){
        vis[node] = 1;
        for(int next:adj.get(node)){
            if(vis[next]==0){
                dfs(next,vis,adj);
            }
        }
    }
}
