class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int it: asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && it<0){
                if(Math.abs(it)>st.peek()){
                    st.pop();
                    continue;
                }
                else if(Math.abs(it)==st.peek()) st.pop();
                destroyed = true;
                break;
            }
            if(!destroyed) st.push(it);
        }
        int n = st.size();
        int[] ans = new int[n];
        for(int i = n-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
        
    }
}