class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<operations.length;i++){
            String str = operations[i];
            switch(str){
                case "+":
                    if(!st.empty()){
                        int first = st.pop();
                        int second = st.pop();
                        int top = first + second;
                        st.push(second);
                        st.push(first);
                        st.push(top);
                    }
                    break;
                case "C":
                    if(!st.empty()){
                        st.pop();
                    }
                    break;
                case "D":
                    if(!st.isEmpty()){
                        st.push(st.peek()*2);
                    }
                    break;
                default:
                    int x = Integer.parseInt(str);
                    st.push(x);
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
        sum+=st.pop();
        }
        return sum;
    }
}