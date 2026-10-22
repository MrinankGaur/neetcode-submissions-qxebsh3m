class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Double.compare( dist(a),dist(b)));
        for(int[] point:points){
            pq.add(point);
        }
        for(int i = k-1;i>=0;i--){
            res[i] = pq.poll();
        }
        return res;

    }
    public double dist(int[] x){
        return (double) x[1]*x[1] + (double) x[0]*x[0];
    }
}
