public class MedianFinder {

    // Adds a number into the data structure.
    private PriorityQueue<Integer> smaller = new PriorityQueue<>();
    private PriorityQueue<Integer> larger = new PriorityQueue<>();
    public void addNum(int num) {
        larger.offer(num);
        smaller.offer(-larger.poll());
        if (smaller.size() > larger.size()) {
            larger.offer(-smaller.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return -smaller.peek() + (larger.peek() + smaller.peek()) / 2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();