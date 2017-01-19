public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> yDir;
    private Iterator<Integer> xDir;
    public Vector2D(List<List<Integer>> vec2d) {
        yDir = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return xDir.next();
    }

    @Override
    public boolean hasNext() {
        while ((xDir == null || !xDir.hasNext()) && yDir.hasNext()) {
            xDir = yDir.next().iterator();
        }
        return xDir != null && xDir.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */