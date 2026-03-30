class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> cmp = (x,y)->{
            int x1 = x[0];
            int y1 = x[1];
            int x2 = y[0];
            int y2 = y[1];
            int dist1 = x1*x1 + y1*y1;
            int dist2 = x2*x2 + y2*y2;
            return dist1-dist2;
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        for(int[] point:points){
            pq.offer(point);
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;


    }
}
