class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0;i<n;i++){
            String code = frequencyCode(strs[i]);
            if(map.containsKey(code)){
                map.get(code).add(strs[i]);
            }
            else{
                map.put(code, new ArrayList<>());
                map.get(code).add(strs[i]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    public String frequencyCode(String str){
        int[] map = new int[26];
        for(char ch:str.toCharArray()){
            map[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<26;i++){
            if(map[i]!=0){
                char ch = (char)('a'+i);
                sb.append(ch);
                sb.append(map[i]);
            }
        }
        return sb.toString();
    }
}
