public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String[] lessThan20Words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tyWords = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] dexWords = {"Billion", "Million", "Thousand", "Hundred"};
        int[] radix = {1000000000, 1000000, 1000, 100};
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < radix.length; i++) {
            count = num / radix[i];
            if (count == 0) {
                continue;
            }
            sb.append(numberToWords(count)).append(" ");
            sb.append(dexWords[i]).append(" ");
            num = num % radix[i];
        }
        if (num == 0) {
            return sb.toString().trim();
        } else if (num < 20) {
            sb.append(lessThan20Words[num]);
        } else {
            count = num / 10;
            sb.append(tyWords[count - 2]).append(" ");
            sb.append(lessThan20Words[num % 10]);
        }
        return sb.toString().trim();
    }
}