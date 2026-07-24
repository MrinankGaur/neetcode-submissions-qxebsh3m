class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length/3;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int it : map.keySet()){
            if(map.get(it)>n){
                list.add(it);
            }
        }
        return list;
    }
}