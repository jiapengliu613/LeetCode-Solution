public class MovingAverage {
    int maxSize;
    int currentSize;
    int sum;
    int pos;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        maxSize = size;
        currentSize = 0;
        sum = 0;
        map = new HashMap<>();
        pos = 0;
    }
    
    public double next(int val) {
        if (currentSize < maxSize) {
            map.put(pos++, val);
            sum += val;
            currentSize++;
            return 1.0 * sum / currentSize;
        } else {
            //int num = map.get(pos - size);
            int num = map.remove(pos - maxSize);
            map.put(pos++, val);
            sum -= num;
            sum += val;
            return 1.0 * sum / maxSize;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */