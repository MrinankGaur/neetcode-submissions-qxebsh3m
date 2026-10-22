class Solution {
    private List<List<Integer>> adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int minHeight = n;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curHgt = dfs(i, -1);
            if (curHgt == minHeight) {
                result.add(i);
            } else if (curHgt < minHeight) {
                result = new ArrayList<>();
                result.add(i);
                minHeight = curHgt;
            }
        }
        return result;
    }
    private int dfs(int node, int parent){
        int hgt = 0;
        for(int next : adj.get(node)){
            if(next==parent){
                continue;
            }
            hgt = Math.max(hgt, 1 + dfs(next,node));
        }
        return hgt;
    }
}