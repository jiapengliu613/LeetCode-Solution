public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int start = 0, end = array.length - 1;
        while (start < end) {
            while (start < end && !set.contains(array[start])) {
                start++;
            }
            while (start < end && !set.contains(array[end])) {
                end--;
            }
            //System.out.println("" + start + " " + end);
            
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
            
        }
        return new String(array);
    }
}