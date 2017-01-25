public class MyStack {
    private Deque<Integer> queue;
    private int size;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
        size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }
        size--;
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }
        int result = queue.peek();
        queue.offer(queue.poll());
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */