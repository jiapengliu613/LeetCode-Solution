public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        s.trim();
        String[] array = s.split(" ");
        //System.out.println(array.length);
        //for (int i = 0; i < array.length; i++) {
            //System.out.print(" " + array[i]);
        //}
        //System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i>= 0; i--) {
            
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
            
        }
        //System.out.println(sb.toString());
        return sb.length() == 0 ? "" : sb.toString().trim();
    }
}