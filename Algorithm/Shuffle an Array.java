public class Solution {

    public Solution(int[] nums) {
        array = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (array == null) {
            return null;
        }
        int[] a = array.clone();
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(i + 1);
            swap(a, i, j);
            
        }
        return a;
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private int[] array;
    private Random random;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */