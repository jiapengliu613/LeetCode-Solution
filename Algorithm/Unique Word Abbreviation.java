public class ValidWordAbbr {
    Map<String, String> map;
    //Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        if (dictionary == null || dictionary.length == 0) {
            return ;
        }
        map = new HashMap<>();
        //set = new HashSet<>();
        for (String word : dictionary) {
            //set.add(word);
            String abbr = getAbbr(word);
            if (!map.containsKey(abbr)) {
                map.put(abbr, word);
            } else {
                if (!map.get(abbr).equals(word)) {
                    map.put(abbr, "");
                }
            }
        }
        System.out.print(map.entrySet());
    }
    
    public boolean isUnique(String word) {
        if (map == null || map.size() == 0) {
            return true;
        }
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr) || map.get(abbr).equals(word)) {
            return true;
        }
        return false;
    }
    
    
    private String getAbbr(String word) {
        if (word.length() <= 2) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */