public class Solution {
    public int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) {
            return 6;
        }
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                hasLower = true;
            }
            if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            }
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
        }
        int typeCnt = (hasLower == true ? 1 : 0) + (hasUpper == true ? 1 : 0) + (hasDigit == true ? 1 : 0);
       
        // Collect cases where repeat >= 3 
        ArrayList<Integer> repeats = new ArrayList<>();
        char c = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                c = s.charAt(i);
                if (count >= 3) {
                    repeats.add(count);
                }
                count = 1;
            }
            
        }
        if (count >= 3) {
            repeats.add(count);
        }
        
        
            
        int result = 0;
        // Case 1 : s.length() < 6
        if (s.length() < 6) {
            if (repeats.size() > 0 && repeats.get(0) == 5) {
                return Math.max(2, 3 - typeCnt);
            } else {
                return Math.max(6 - s.length(), 3 - typeCnt);
            }
        } else {
            int over = Math.max(s.length() - 20, 0), left = 0;
            result += over;
            //
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < repeats.size() && over > 0; i++) {
                    if (repeats.get(i) % 3 != (k - 1)) {
                        continue;
                    }
                    if (over - k >= 0) {
                        repeats.set(i, repeats.get(i) - k);
                        over -= k;
                    } else {
                        repeats.set(i, repeats.get(i) - k + 1);
                        over -= k - 1;
                    }
                    
                }
            }
            //System.out.println("" + over + " " + repeats.size());
            for (int i = 0; i < repeats.size(); i++) {
                //System.out.println("" + repeats.get(i) + " ");
                if (over > 0 && repeats.get(i) >= 3) {
                    int need = repeats.get(i) - 2;
                    repeats.set(i, repeats.get(i) - over);
                    over -= need;
                    
                }
                //System.out.println(repeats.get(i));
                if (repeats.get(i) >= 3) {
                    left += repeats.get(i) / 3;
                }
            }
            
            result += Math.max(left, 3 - typeCnt);
        }
        return result; 
    }
}