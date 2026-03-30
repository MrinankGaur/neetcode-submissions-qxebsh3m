class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        int i = 0;
        while(i<n || i<m){
            if(i<n) s1[s.charAt(i)-'a']++;
            if(i<m) s2[t.charAt(i)-'a']++;
            i++;
        }
        for(int j = 0;j<26;j++){
            if(s1[j]!=s2[j]) return false;
        }
        return true;
    }
}
