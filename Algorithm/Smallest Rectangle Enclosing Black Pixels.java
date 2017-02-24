public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int m = image.length, n = image[0].length;
        int left = searchLeftCol(image, 0, y, 0, m);
        int right = searchRightCol(image, y, n - 1, 0, m);
        int top = searchTopRow(image, 0, x, 0, n);
        int down = searchBotRow(image, x, m - 1, 0, n);
        //System.out.println(left + " " + right + " " + top + " " + down);
        return (down - top + 1) * (right - left + 1);
    }
    private int searchLeftCol(char[][] image, int left, int right, int top, int bot) {
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int k = top;
            while (k < bot && image[k][mid] == '0') {
                k++;
            }
            if (k < bot && image[k][mid] == '1') {
                right = mid;
            } else {
                left = mid;
            }
        }
        for (int i = top; i < bot; i++) {
            if (image[i][left] == '1') {
                return left;
            }
        }
        return right;
    }
    private int searchRightCol(char[][] image, int left, int right, int top, int bot) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int k = top;
            while (k < bot && image[k][mid] == '0') {
                k++;
            }
            if (k < bot && image[k][mid] == '1') {
                left = mid;
            } else {
                right = mid;
            }
        }
        for (int i = top; i < bot; i++) {
            if (image[i][right] == '1') {
                return right;
            }
        }
        return left;
    }
    private int searchTopRow(char[][] image, int top, int bot, int left, int right) {
        while (top + 1 < bot) {
            int mid = top + (bot - top) / 2;
            int k = left;
            while (k < right && image[mid][k] == '0') {
                k++;
            }
            if (k < right && image[mid][k] == '1') {
                bot = mid;
            } else {
                top = mid;
            }
        }
        for (int i = 0; i < image[0].length; i++) {
            if (image[top][i] == '1') {
                return top;
            }
        }
        return bot;
    }
    private int searchBotRow(char[][] image, int top, int bot, int left, int right) {
        while (top + 1 < bot) {
            int mid = top + (bot - top) / 2;
            int k = left;
            while (k < right && image[mid][k] == '0') {
                k++;
            }
            if (k < right && image[mid][k] == '1') {
                top = mid;
            } else {
                bot = mid;
            }
        }
        for (int i = 0; i < image[0].length; i++) {
            if (image[bot][i] == '1') {
                return bot;
            }
        }
        return top;
    }
}