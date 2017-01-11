public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array1[0] == array2[0] ? array1[1] - array2[1] : array2[0] - array1[0];
            }
        });
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[people.length][]);
    }
}