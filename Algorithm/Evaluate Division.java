public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations.length == 0 || queries.length == 0) {
            return new double[0];
        }
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuePairs = new HashMap<>();
        int index = 0;
        for (String[] equation : equations) {
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                valuePairs.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                valuePairs.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuePairs.get(equation[0]).add(values[index]);
            valuePairs.get(equation[1]).add(1 / values[index]);
            index++;
        }
        //System.out.println(valuePairs.keySet());
        //System.out.println(valuePairs.values());
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            String[] query = queries[i];
            String start = query[0];
            String end = query[1];
            if (i == 0) {
                //System.out.println(start + " " + end);
            }
            Set<String> visited = new HashSet<>();
            visited.add(start);
            result[i] = helper(pairs, valuePairs, start, end, visited, 1.0);
            //System.out.println(result[i]);
            if (result[i] == 0) {
                result[i] = -1.0;
            }
        }
        return result;
    }
    
    private double helper(Map<String, List<String>> pairs, Map<String, List<Double>> valuePairs, String current, String end, Set<String> visited, double value) {
        //System.out.println(value);
        if (!pairs.containsKey(end)) {
            return 0;
        }
        if (!pairs.containsKey(current)) {
            //System.out.println("im here when current is " + current);
            return 0;
        }
        if (current.equals(end)) {
            //System.out.println("im here");
            return value;
        }
        double result = 0;
        for (int i = 0; i < pairs.get(current).size(); i++) {
            String next = pairs.get(current).get(i);
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            double weight = valuePairs.get(current).get(i);
            
            result = helper(pairs, valuePairs, next, end, visited, value * weight);
            visited.remove(next);
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}