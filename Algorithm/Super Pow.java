public class Solution {
    public int superPow(int a, int[] b) {
        if (a == 0 || b == null || b.length == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (a > 1337) {
            return superPow(a % 1337, b);
        }
        ArrayList<Integer> list = findPattern(a);
        int pos = findPosition(list.size(), b);
        pos = pos == 0 ? list.size() : pos;
        //System.out.println(pos);
        return  list.get(pos - 1);
    }
    private ArrayList<Integer> findPattern(int a) {
        Set<Integer> set = new HashSet<>();
        int reminder = a % 1337;
        ArrayList<Integer> result = new ArrayList<>();
        while (set.add(reminder)) {
            result.add(reminder);
            reminder = reminder * a % 1337;
        }
        return result;
    }
    private int findPosition(int size, int[] b) {
        int reminder = 0;
        for (int i = 0; i < b.length; i++) {
            reminder = (reminder * 10 + b[i]) % size;
        }
        return reminder;
    }
}