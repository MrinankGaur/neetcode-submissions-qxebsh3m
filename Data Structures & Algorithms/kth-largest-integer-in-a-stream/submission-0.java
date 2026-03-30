class KthLargest {
    PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(
                                    (x,y)->Integer.compare(y,x)
                                );
        this.k = k;
        for(int it:nums){
            pq.offer(it);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        int[] arr = new int[k];
        for(int i =0;i<k;i++){
            arr[i]=pq.poll();
        }
        for(int it:arr){
            pq.offer(it);
        }
        return arr[k-1];
    }
}
