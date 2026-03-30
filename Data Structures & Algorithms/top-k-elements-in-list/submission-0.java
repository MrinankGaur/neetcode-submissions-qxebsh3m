class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(map.get(a),map.get((b))));
        for(int key: map.keySet()){
            pq.offer(key);
            if(pq.size()>k)pq.poll();
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
        

    }
}
