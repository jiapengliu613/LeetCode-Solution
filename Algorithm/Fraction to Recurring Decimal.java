public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        long current = num / denom;
        sb.append(current);
        num = num % denom;
        
        if (num != 0) {
            sb.append(".");
        } else {
            return sb.toString();
        }
        //int n = sb.length();
        //System.out.println(n + " " + numerator + " " + sb.toString());
        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            
            if (map.containsKey(num)) {
                int pos = map.get(num);
                sb.insert(pos, '(');
                sb.append(')');
                return sb.toString();
            } else {
                map.put(num, sb.length());
                num *= 10;
                current = num / denom;
                
                sb.append(current);
                
                num = num % denom;
            }
            
        }
        return sb.toString();
        
    }
}