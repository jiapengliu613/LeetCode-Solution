public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int bot = Math.max(B, F);
        int top = Math.min(D, H);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int intersect = 0;
        if (bot < top && left < right) {
            intersect = (top - bot) * (right - left);
        }
        return area1 + area2 - intersect;
    }
}