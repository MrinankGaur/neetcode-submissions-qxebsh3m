class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int curr : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && curr < 0 && st.peek() > 0) {
                int top = st.peek();

                if (top < Math.abs(curr)) {
                    st.pop();
                } else if (top == Math.abs(curr)) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(curr);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}