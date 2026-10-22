class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Double.compare( dist(a[0],a[1]) , dist(b [0],b[1])));
        for(int[] point:points){
            pq.add(point);
        }
        for(int i = k-1;i>=0;i--){
            res[i] = pq.poll();
        }
        return res;

    }
    public double dist(int x,int y){
        return (double) x*x + (double) y*y;
    }
}
