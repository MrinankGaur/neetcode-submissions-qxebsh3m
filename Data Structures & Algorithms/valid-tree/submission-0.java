class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1){
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis = new int[n];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        if(!dfs(0,-1,adj,vis)){
            return false;
        }
        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                return false;
            }
        }
        return true;


    }
    public boolean dfs(int node,int parent, List<List<Integer>> adj, int[] vis){
        if(vis[node]==1){
            return false;
        }
        vis[node]=1;
        for(int next:adj.get(node)){
            if(next==parent) continue;
            if(!dfs(next,node,adj,vis)){
                return false;
            }
        }
        return true;
    }
}
