class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = 0;
        for(int it:nums){
            n++;
            map.put(it,map.getOrDefault(it,0)+1);
        }
        n=n/2;
        for(int it:map.keySet()){
            if(map.get(it)>n) return it;
        }
        return -1;
    }
}