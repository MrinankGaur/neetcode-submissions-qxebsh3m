class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i = 0;i<n;i++){
            map.put(numbers[i],i+1);
        }
        int[] result = new int[2];
        for(int i = 0;i<n;i++){
            int diff = target-numbers[i];
            if(map.containsKey(diff) && diff!=numbers[i]){
                result[0] = i+1;
                result[1] = map.get(diff);
                return result;
            }
        }
        return result;

    }
}