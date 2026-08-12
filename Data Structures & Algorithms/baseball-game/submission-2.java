class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String str : operations) {
            switch (str) {
                case "+":
                    int first = st.pop();
                    int second = st.pop();

                    st.push(second);
                    st.push(first);
                    st.push(first + second);
                    break;

                case "C":
                    st.pop();
                    break;

                case "D":
                    st.push(st.peek() * 2);
                    break;

                default:
                    st.push(Integer.parseInt(str));
            }
        }

        int sum = 0;

        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}