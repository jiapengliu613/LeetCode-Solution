public class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        //int count = 0;
        for (Integer num : nums) {
            if (num.equals(first) || num.equals(second) || num.equals(third)) {
                continue;
            } else if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
                //count++;
            } else if (second == null || num > second) {
                third = second;
                //count++;
                second = num;
                
            } else if (third == null || num > third) {
                third = num;
                //count++;
            }
            //System.out.println(count);
        }
        
        if (third != null) {
            return third;
        } else {
            return first;
        }
    }
}