public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String str1 = input.substring(0, i);
                String str2 = input.substring(i + 1);
                List<Integer> part1 = diffWaysToCompute(str1);
                List<Integer> part2 = diffWaysToCompute(str2);
                for (int a : part1) {
                    for (int b : part2) {
                        int sol = 0;
                        switch(c) {
                            case '+' : sol = a + b;
                                break;
                            case '-' : sol = a - b;
                                break;
                            case '*' : sol = a * b;
                                break;
                            default :
                                break;
                        }
                        result.add(sol);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
            
        }
        return result;
    }
}