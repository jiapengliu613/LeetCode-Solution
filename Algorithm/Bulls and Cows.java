public class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0) {
            return "";
        }
        int n = secret.length();
        int countA = 0, countB = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                int a = secret.charAt(i) - '0';
                int b = guess.charAt(i) - '0';
                if (count[b] > 0) {
                    countB++;
                }
                if (count[a] < 0) {
                    countB++;
                }
                count[a]++;
                count[b]--;
            }
        }
        return countA + "A" + countB + "B";
        
    }
}