class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        Set<Integer> vis = new HashSet<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        if(!dfs(0,-1,adj,vis)){
            return false;
        }
        return vis.size()==n;


    }
    public boolean dfs(int node,int parent, List<List<Integer>> adj, Set<Integer> vis){
        if(vis.contains(node)){
            return false;
        }
        vis.add(node);
        for(int next:adj.get(node)){
            if(next==parent) continue;
            if(!dfs(next,node,adj,vis)){
                return false;
            }
        }
        return true;
    }
}
