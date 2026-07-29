class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i = 0;i<n;i++){
            map.put(numbers[i],i+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int diff = target-numbers[i];
            if(map.containsKey(diff)){
                list.add(i+1);
                list.add(map.get(diff));
                return list.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
