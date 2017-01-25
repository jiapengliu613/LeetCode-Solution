public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        helper("JFK", result, map);
        return result;
    }
    private void helper(String airport, LinkedList<String> result, Map<String, PriorityQueue<String>> map) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll(), result, map);
        } 
        result.addFirst(airport);
    }
}