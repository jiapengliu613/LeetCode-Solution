public class Solution {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        /*
        int count = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, true);
        }
        for (int ite = 2; ite <= n; ite++) {
            for (int key : map.keySet()) {
                if (key % ite == 0) {
                    map.put(key, !map.get(key));
                }
            }
        }
        for (boolean on : map.values()) {
            if (on == true) {
                count++;
            }
        }
        return count;
        */
        /*
        boolean flag = false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            flag = false;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    flag = !flag;
                }
            }
            if (flag == true) {
                count++;
            }
        }
        return count;
        */
        return (int)Math.sqrt(n);
    }
}