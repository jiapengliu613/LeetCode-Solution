public class MinStack {

    /** initialize your data structure here. */
    
    public MinStack() {
        stackA = new ArrayDeque<Integer>();
        //min=Integer.MAX_VALUE;
        stackB = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        if(stackB.isEmpty() || x <= stackB.peek()){
            //min=x;
            stackB.push(x);
        }
        stackA.push(x);
    }
    
    public void pop() {
        int val1 = stackA.peek();
    	int val2 = stackB.peek();
        if (val1 == val2) {
            stackB.pop();
        }
        stackA.pop();
    }
    
    public int top() {
        return stackA.peek();
     }
    
    public int getMin() {
        return stackB.peek();
    }
    private Deque<Integer> stackA;
    
    private Deque<Integer> stackB;
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */