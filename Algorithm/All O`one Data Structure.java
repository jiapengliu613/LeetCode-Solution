public class AllOne {
    class Bucket {
        Set<String> set;
        Bucket prev;
        Bucket next;
        int count;
        public Bucket(int count) {
            this.count = count;
            set = new HashSet<>();
            prev = null;
            next = null;
        }
    }
    Bucket head;
    Bucket tail;
    Map<String, Integer> keyMap;
    Map<Integer, Bucket> bucketMap;
    
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(0);
        tail = new Bucket(0);
        head.next = tail;
        tail.prev = head;
        keyMap = new HashMap<>();
        bucketMap = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            change(key, 1);
        } else {
            keyMap.put(key, 1);
            if (!bucketMap.containsKey(1)) {
                addBucket(new Bucket(1), head);
                bucketMap.put(1, head.next);
            }
            head.next.set.add(key);
            //System.out.println(keyMap.toString());
        }
        
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyMap.containsKey(key)) {
            return ;
        }
        int count = keyMap.get(key);
        if (count == 1) {
            keyMap.remove(key);
            removeKeyFromBucket(bucketMap.get(1), key);
        } else {
            change(key, -1);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
        return head.next == tail ? "" : (String)tail.prev.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String)head.next.set.iterator().next();
    }
    
    private void change(String key, int offset) {
        int count = keyMap.get(key);
        keyMap.put(key, count + offset);
        Bucket newBucket;
        if (bucketMap.containsKey(count + offset)) {
            newBucket = bucketMap.get(count + offset);
        } else {
            newBucket = new Bucket(count + offset);
            bucketMap.put(count + offset, newBucket);
            addBucket(newBucket, offset == 1 ? bucketMap.get(count) : bucketMap.get(count).prev);
        }
        newBucket.set.add(key);
        removeKeyFromBucket(bucketMap.get(count), key);
    }
    
    private void addBucket(Bucket newBucket, Bucket oldBucket) {
        newBucket.prev = oldBucket;
        newBucket.next = oldBucket.next;
        oldBucket.next.prev = newBucket;
        oldBucket.next = newBucket;
        
    }
    
    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.set.remove(key);
        if (bucket.set.size() == 0) {
            bucketMap.remove(bucket.count);
            removeBucketFromList(bucket);
        }
    }
    
    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */