public class LRUCache {
    
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        maxCap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        //remove cur node from the list
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        //insert it to the tail
        moveToTail(cur);
        return map.get(key).value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == maxCap) {
            // remove least used node, update the hashmap at the same time
            
            Node p = head.next;
            head.next = p.next;
            p.next.prev = p.prev;
            map.remove(p.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }
    
    private void moveToTail(Node cur) {
        //Node prev = tail.prev;
        cur.prev = tail.prev;
        //cur.next = tail;
        tail.prev = cur;
        cur.prev.next = cur;
        cur.next = tail;
    }
    
    
    private HashMap<Integer, Node> map;
    private int maxCap;
    private Node head, tail;
    
}