class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
         int min = minStack.isEmpty()
                ? val
                : Math.min(val, minStack.peek());

        this.minStack.push(min);
    }
    
    public void pop() {
        if(this.stack.isEmpty()) return;
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
