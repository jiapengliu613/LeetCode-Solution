public class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result.toArray(new String[0]);
        }
        String[] array = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        int row = 0;
        for (String s : array) {
            
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), row);
            }
            row++;
        }
        //System.out.println(map.entrySet());
        for (String word : words) {
            if (word.length() == 0) {
                result.add(word);
                continue;
            }
            int index = map.get(word.toUpperCase().charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (index != map.get(word.toUpperCase().charAt(i))) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}