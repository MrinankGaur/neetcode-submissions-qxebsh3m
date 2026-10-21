
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] que) {
        int[] indeg = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : pre){
            int u = p[0];
            int v = p[1];
            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        boolean[][] isPre = new boolean[n][n];

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : adj.get(curr)){
                isPre[curr][next] = true;

                for(int i = 0; i < n; i++){
                    if(isPre[i][curr]){
                        isPre[i][next] = true;
                    }
                }

                indeg[next]--;
                if(indeg[next] == 0){
                    q.offer(next);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] qu : que){
            int u = qu[0];
            int v = qu[1];
            res.add(isPre[u][v]);
        }

        return res;
    }
}
