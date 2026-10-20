class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] p : pre){
            int u = p[0];
            int v = p[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int[] res = new int[n];
        int index = n-1;
        while(!q.isEmpty()){
            int curr = q.poll();
            res[index--] = curr;
            for(int x:adj.get(curr)){
                indeg[x]--;
                if(indeg[x]==0){
                    q.offer(x);
                }
            }
        }
        return index == -1 ? res : new int[]{};
    }
}
