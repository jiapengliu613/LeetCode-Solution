public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean  eSeen = false, numSeen = false, dotSeen = false;
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(i + " ");
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numSeen = true;
            } else if (c == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (c == '-' || c == '+') {
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numSeen ;
        
        
        
        
        
        
        
        
        /* regex matching solution
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if (s.trim().matches(regex)) {
            return true;
        } else {
            return false;
        }
        */
        
    }
}