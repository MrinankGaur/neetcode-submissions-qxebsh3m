class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            indeg[arr[1]]++;
            adj.get(arr[0]).add(arr[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indeg[i]==0) q.offer(i);
        }

        int index = 0;
        int[] ans = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            ans[numCourses - index - 1]=node;
            index++;
            for(int next:adj.get(node)){
                indeg[next]--;
                if(indeg[next]==0) q.offer(next);
            }
        }
        return  index==numCourses ? ans : new int[0];   
    }
}
