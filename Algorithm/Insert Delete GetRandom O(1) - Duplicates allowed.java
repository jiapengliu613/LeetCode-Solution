public class RandomizedCollection {
    private Map<Integer, Set<Integer>> map1;
    private Map<Integer, Integer> map2;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if (!map1.containsKey(val)) {
            flag = true;
            map1.put(val, new HashSet<>());
        }
        int size = map2.size();
        map1.get(val).add(size);
        map2.put(size, val);
        return flag;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map1.containsKey(val)) {
            return false;
        }
        Set<Integer> set = map1.get(val);
        //int size = map2.size();
        int toRemove = set.iterator().next();
        set.remove(toRemove);
        if (set.size() == 0) {
            map1.remove(val);
        }
        int size = map2.size();
        if (toRemove == size - 1) {
            map2.remove(toRemove);
            return true;
        }
        int key = map2.get(size - 1);
        map1.get(key).remove(size - 1);
        map1.get(key).add(toRemove);
        map2.put(toRemove, key);
        map2.remove(map2.size() - 1);
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return map2.get(rand.nextInt(map2.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */