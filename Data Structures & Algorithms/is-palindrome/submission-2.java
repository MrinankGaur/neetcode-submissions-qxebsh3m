class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       s = s.toLowerCase();
       int i = 0;
       int j = n-1;
       while(i<j){
        char s1 = s.charAt(i);
        char e = s.charAt(j);
        if(!isAN(s1)){
            i++; 
            continue;
        }
        else if(!isAN(e)){
            j--; 
            continue;
        }
        else if(isAN(s1) && isAN(e) && s1!=e){
            return false;
        }
        
        i++;
        j--;
       }
       return true; 
    }
    public boolean isAN(char ch){        
        if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')) return true;
        return false;
    }
}
