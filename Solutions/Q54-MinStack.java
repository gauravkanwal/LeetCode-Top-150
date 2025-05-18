class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public MinStack() {
    }
    
    public void push(int val) {
        //insert the val and the minimum value until now:

        int minVal=val;
        if(!stack.isEmpty()){
            minVal=Math.min(minVal,minStack.peek());
        }

        stack.push(val);
        minStack.push(minVal);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */