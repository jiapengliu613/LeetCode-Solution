public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return result;
        }
        int i = 0, j = 0;
        int m = nums1.length, n = nums2.length;
        PriorityQueue<Triple> pq = new PriorityQueue<>(k, new Comparator<Triple>(){
            @Override
            public int compare(Triple a, Triple b) {
                return a.val - b.val;
            }
        });
        Map<Integer, Boolean> map = new HashMap<>();
        pq.offer(new Triple(i, j, nums1[i] + nums2[j]));
        map.put(0, true);
        for (int ite = 1; ite <= k; ite++) {
            Triple top = pq.poll();
            i = top.index1;
            j = top.index2;
            result.add(new int[]{nums1[i], nums2[j]});
            if (i + 1 < m && !map.containsKey((i + 1) * n + j)) {
                pq.offer(new Triple(i + 1, j, nums1[i + 1] + nums2[j]));
                map.put((i + 1) * n + j, true);
            }
            if (j + 1 < n && !map.containsKey(i * n + j + 1)) {
                pq.offer(new Triple(i, j + 1, nums1[i] + nums2[j + 1]));
                map.put(i * n + j + 1, true);
            }
            if (pq.isEmpty()) {
                break;
            }
        }
        return result;
    }
    
    class Triple {
        int index1;
        int index2;
        int val;
        public Triple(int index1, int index2, int val) {
            this.index1 = index1;
            this.index2 = index2;
            this.val = val;
        }
    }
}