public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
            return 0;
        }
        //System.out.print("Im here");
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        //System.out.print("" + v1.length + " " + v2.length);
        int i;
        for (i = 0; i < v1.length || i < v2.length; i++) {
            int first = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int second = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (first > second) {
                return 1;
            } else if (first < second) {
                return -1;
            }
        }
        return 0;
    }
}