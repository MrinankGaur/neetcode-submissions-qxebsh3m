class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
           min = Math.min(min,strs[i].length());
        }
        if(min==0) return "";
        StringBuilder ans = new StringBuilder();
        for(int j =0 ;j<min;j++){
            char ch = strs[0].charAt(j);
            for(int i = 1;i<n;i++){
                if(ch!=strs[i].charAt(j)) return ans.toString();
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}