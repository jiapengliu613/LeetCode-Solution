/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        int n = intervals.length;
        int[] starts = new int[n];
        int [] ends = new int[n];
        int pos = 0;
        for (Interval interval : intervals) {
            starts[pos] = interval.start;
            ends[pos] = interval.end;
            pos++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 1; i < n; i++) {
            if (starts[i] < ends[i - 1]) {
                return false;
            }
        }
        return true;
    }
}