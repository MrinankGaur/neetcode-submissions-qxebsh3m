class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new Pair(v,t));
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> a.weight-b.weight );
        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;
            if(weight>dist[node]) continue;
            for(Pair it : adj.get(node)){
                int next = it.node;
                int nextWeight = it.weight + weight;
                if(nextWeight < dist[next]){
                    dist[next] = nextWeight;
                    pq.offer(new Pair(next, nextWeight));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            max = Math.max(max,dist[i]);
        }

        return max==Integer.MAX_VALUE ? -1 : max;
        


    }
    private class Pair{
        int node;
        int weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
}
