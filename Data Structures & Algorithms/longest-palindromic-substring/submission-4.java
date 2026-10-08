class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int index = 0;
        int length = 0;
        for(int i = 0;i<n;i++){
            //odd
            int l = i;
            int r = i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>length){
                    index = l;
                    length = r-l+1;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>length){
                    index = l;
                    length = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(index,index+length);
    }
}
