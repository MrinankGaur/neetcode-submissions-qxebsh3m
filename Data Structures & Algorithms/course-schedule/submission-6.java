class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] pre:prerequisites){
            int u = pre[0];
            int v = pre[1];
            if(adj.get(v).add(u));
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            finish++;
            for(int x:adj.get(curr)){
                indeg[x]--;
                if(indeg[x]==0){
                    q.offer(x);
                }
            }
        }
        return finish == n;
    }
}
