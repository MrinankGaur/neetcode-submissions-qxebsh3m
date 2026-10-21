class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Set<Integer> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});
        vis.add(0);
    
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int next:adj.get(node)){
                if(next==parent){
                    continue;
                }
                if(vis.contains(next)){
                    return false;
                }
                vis.add(next);
                q.offer(new int[]{next,node});
            }
        }
        return vis.size() == n;
    }
    
}
