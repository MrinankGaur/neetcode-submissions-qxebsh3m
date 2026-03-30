class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i =0, j = n-1;
        while(i<j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1!=c2){
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
                // if(s.charAt(i+1)==c2){
                //     i++;
                //     skip--;
                //     continue;
                // }
                // else if(s.charAt(j-1)==c1){
                //     j--;
                //     skip--;
                //     continue;
                // }
                // else{
                //     return false;
                // }
                
            }
            
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}