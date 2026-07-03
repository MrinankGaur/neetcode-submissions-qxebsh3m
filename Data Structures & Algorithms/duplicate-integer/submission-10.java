class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int it:nums){
            if(set.contains(it)) return true;
            set.add(it);
        }
        return false;
    }
}