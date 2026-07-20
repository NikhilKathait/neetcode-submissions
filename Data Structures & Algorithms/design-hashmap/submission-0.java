class MyHashMap {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] buckets;
    private static final int size = 769;

    public MyHashMap() {
        buckets = new LinkedList[size];
    }

    private int hash(int key) {
        return key % size;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Node node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);

        if (buckets[index] == null) {
            return -1;
        }

        for (Node node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] == null)
            return;

        Iterator<Node> it = buckets[index].iterator();

        while (it.hasNext()) {
            if (it.next().key == key) {
                it.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */