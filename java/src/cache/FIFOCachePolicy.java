public class FIFOCachePolicy implements CachePolicy {

    private CircularQueue queue;

    public FIFOCachePolicy(int capacity) {
        queue = new CircularQueue(capacity);
    }
 
    // TODO implementar
    public String get(int key) {
         Pair p = queue.get(key);

        if (!queue.contains(key)) {
            return "null";
        } else {
            return p.getValue();
        }
    }

    // TODO implementar
    public void put(int key, String value) {
        Pair p = new Pair(key, value);

        if (queue.isFull()) {
            queue.removeFirst();
            queue.addLast(p);
        } else {
            queue.addLast(p);
        }
    }

    public String toString() {
        return this.queue.toString();
    }
}
