class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            int[] vis = new int[n+1];
            if (dfs(u, -1, adj, vis)) {
                return edge;
            }
        }
        return new int[0];
    }
    private boolean dfs(int node, int parent, List<List<Integer>> adj, int[] vis){
        if(vis[node]==1){
            return true;
        }
        vis[node]=1;
        for(int next:adj.get(node)){
            if(next==parent) continue;
            if(dfs(next,node,adj,vis)){
                return true;
            }
        }
        return false;
    }
}
