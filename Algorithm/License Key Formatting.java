public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) {
            return S;
        }
        String[] array = S.split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        int index = sb.length();
        while (index > K) {
            index = index - K;
            sb.insert(index, '-');
            //index -= K;
        }
        return sb.toString().toUpperCase();
    }
}