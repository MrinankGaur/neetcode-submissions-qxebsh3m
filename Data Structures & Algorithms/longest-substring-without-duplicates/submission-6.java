class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l++));
            }
            
        }
        return max;
    }
}
