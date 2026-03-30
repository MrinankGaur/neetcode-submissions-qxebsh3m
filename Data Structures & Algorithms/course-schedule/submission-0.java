class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            int u = arr[0];
            int v = arr[1];
            indeg[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int x : adj.get(node)){
                indeg[x]--;
                if(indeg[x]==0){
                    q.add(x);
                }
            }
        }
        return finish == numCourses;


    }
}
