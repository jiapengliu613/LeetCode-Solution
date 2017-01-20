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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        Interval merged = new Interval(newInterval.start, newInterval.end);
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            merged.start = Math.min(merged.start, Math.min(intervals.get(i).start, newInterval.start));
            merged.end = Math.max(merged.end, Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        result.add(merged);
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}