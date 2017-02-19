public class Solution {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] array = new int[n];
        int fast = 0;
        int slow = 0;
        array[fast++] = 1;
        array[fast++] = 2;
        array[fast++] = 2;
        int current = 1;
        slow = 2;
        while (fast < n) {
            for (int i = 0; fast < n && i < array[slow]; i++) {
                array[fast++] = current;
            }
            if (current == 2) {
                current = 1;
            } else {
                current = 2;
            }
            
            slow++;
            //System.out.println();
        }
        
        int count = 0;
        for (int num : array) {
            //System.out.print(num + " ");
            count += num == 1 ? 1 : 0;
        }
        return count;
    }
}