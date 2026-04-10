class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap<>();
        for(List<String> list:tickets){
            String src = list.get(0);
            String dest = list.get(1);
            adj.putIfAbsent(src,new ArrayList<>());
        } 
        tickets.sort((a,b)->a.get(1).compareTo(b.get(1)));
        for(List<String> list:tickets){
            adj.get(list.get(0)).add(list.get(1));
        }
        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        if (dfs("JFK", ans, adj, tickets.size() + 1)) {
            return ans;
        }
        return new ArrayList<>(); 
    }
    private boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int targetLen) {
        if (res.size() == targetLen) {
            return true;
        }

        if (!adj.containsKey(src)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if (dfs(v, res, adj, targetLen)) return true;
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
