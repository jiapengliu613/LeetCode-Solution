public class ZigzagIterator {
    int flag = 0;
    int index1 = 0;
    int index2 = 0;
    int length1, length2;
    List<Integer> v1, v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        length1 = v1.size();
        length2 = v2.size();
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (flag == 0) {
            flag = 1 - flag;
            if (index1 < length1) {
                return v1.get(index1++);
            } else {
                return v2.get(index2++);
            }
        } else {
            flag = 1 - flag;
            if (index2 < length2) {
                return v2.get(index2++);
            } else {
                return v1.get(index1++);
            }
        }
        
    }

    public boolean hasNext() {
        return (index1 < length1 || index2 < length2);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */