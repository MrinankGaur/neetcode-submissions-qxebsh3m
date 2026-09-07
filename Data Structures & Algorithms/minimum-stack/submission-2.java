class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
    }
    
    public void push(int val) {
        stack.push(val);
        pq.offer(val);
    }
    
    public void pop() {
        int val = stack.pop();
        pq.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}
