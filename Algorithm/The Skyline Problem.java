public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<int[]>();
        }
        List<int[]> result = new ArrayList<>();
        ArrayList<Height> heights = new ArrayList<Height>();
        for (int[] building : buildings) {
            heights.add(new Height(building[0], -building[2]));
            heights.add(new Height(building[1], building[2]));
        }
        Collections.sort(heights, new Comparator<Height>() {
            @Override
            public int compare(Height a, Height b) {
                if (a.pos == b.pos) {
                    return a.height - b.height;
                }
                return a.pos - b.pos;
            }
        });
        //for (Height height : heights) {
            //System.out.println("" + height.pos + " " + height.height);
        //}
        PriorityQueue<Integer> pq = new PriorityQueue<>(10000, Collections.reverseOrder());
        int prev = 0;
        pq.offer(0);
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i).height < 0) {
                pq.offer(- heights.get(i).height);
            } else {
                pq.remove(heights.get(i).height);
            }
            int current = pq.peek();
            if (current != prev) {
                int[] part = new int[2];
                part[0] = heights.get(i).pos;
                part[1] = current;
                result.add(part);
                prev = current;
            }
            
        }
        return result;
        
    }
    class Height {
        int pos;
        int height;
        public Height(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
}