class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        this.minStack.push(this.minStack.isEmpty()?val:Math.min(val,this.minStack.peek()));
    }
    
    public void pop() {
        if(this.stack.isEmpty()) return;
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        if(this.stack.isEmpty()) return 0;
        return this.stack.peek();
    }
    
    public int getMin() {
        if(this.stack.isEmpty()) return 0;
        return this.minStack.peek();
    }
}
