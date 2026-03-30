class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:trust){
            int u = arr[0]-1;
            int v = arr[1]-1;
            adj.get(u).add(v);
        }
        int judge = 0;
        for(int i = 0;i<adj.size();i++){
            if(adj.get(i).size()==0) judge = i;
        }
        for(int i = 0;i<adj.size();i++){
            if(i==judge) continue;
            if(!adj.get(i).contains(judge)) return -1;
        }
        return judge+1;

    }
}