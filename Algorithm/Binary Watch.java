public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num < 0) {
            return result;
        }
        //StringBuilder sb = new StringBuilder();
        helper(num, 0, 0, 0, result);
        return result;
    }
    private int[] hours = {8, 4, 2, 1};
    private int[] minutes = {32, 16, 8, 4, 2, 1};
    private void helper(int numLeft, int hour, int minute, int index, List<String> result) {
        if (numLeft == 0) {
            if (hour <= 11 && minute <= 59) {
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(":");
                if (minute < 10) {
                    sb.append("0");
                }
                sb.append(minute);
                result.add(sb.toString());
            }
            return;
        }
        if (hour > 11 || minute > 59) {
            return;
        }
        if (index == (hours.length + minutes.length)) {
            return ;
        }
        for (int i = index; i < hours.length + minutes.length; i++)
        if (i < hours.length) {
            helper(numLeft - 1, hour + hours[i], minute, i + 1, result);
        } else  {
            helper(numLeft - 1, hour, minute  + minutes[i - hours.length], i + 1, result);
        }
        
        //helper(numLeft - 1, hour, minute + minutes[minuteIndex], hourIndex, minuteIndex + 1, result);
        //helper(numLeft, hour, minute, hourIndex, minuteIndex + 1, result);
    }
}