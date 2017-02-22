public class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        char[] array = new char[n];
        helper(result, array, 0, n - 1, map);
        return result;
    }
    private void helper(List<String> result, char[] array, int left, int right, Map<Character, Character> map) {
        if (left > right) {
            result.add(new String(array));
            return;
        }
        for (char num : map.keySet()) {
            if (left == 0 && num == '0' && array.length > 1) {
                continue;
            }
            if (left == right && num != '0' && num != '1' && num != '8') {
                continue;
            } else if (left == right){
                array[left] = num;
                helper(result, array, left + 1, right - 1, map);
            } else {
                array[left] = num;
                array[right] = map.get(num);
                helper(result, array, left + 1, right - 1, map);
            }
            
        }
    }
}