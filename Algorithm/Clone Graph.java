/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //BFS
        if (node == null) {
            return null;
        }
        if (node.neighbors == null || node.neighbors.size() == 0) {
            return new UndirectedGraphNode(node.label);
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node.label, start);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, newNode);
                    queue.offer(neighbor);
                }
                map.get(current.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return start;
        
  
        
        /*
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode next = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, next);
                    queue.offer(neighbor);
                    
                    //continue;
                }
                map.get(current.label).neighbors.add(map.get(neighbor.label));
                //map.get(current.label).neighbors.add(next);
            }
        }
        return newNode;
       /*
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
        
    }
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label, cloned);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloned.neighbors.add(helper(neighbor, map));
        }
        return cloned;
        */
    }
}