class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i = 0,j=0;
        StringBuilder str = new StringBuilder();
        while(i<n || j<m){
            if(i<n)str.append(word1.charAt(i++));
            if(j<m)str.append(word2.charAt(j++));
        }
        return str.toString();
    }
}