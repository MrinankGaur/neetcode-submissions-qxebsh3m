class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indeg[i]==0) q.offer(i);
        }
        int  size = q.size();
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next:adj.get(node)){
                indeg[next]--;
                if(indeg[next]==0){
                    size++;
                    q.offer(next);
                }
            }
        }
        return size==n;


    }
}
