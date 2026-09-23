class LRUCache {

    Map<Integer, Node> map;

    int length;
    int count;

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node lr_pointer;  // LRU
    Node mr_pointer;  // MRU

    public LRUCache(int capacity) {
        this.length = capacity;
        this.count = 0;
        map = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Already MRU
        if (node == mr_pointer) {
            return node.val;
        }

        // Remove node from its current position
        removeNode(node);

        // Add it at MRU
        addAtMRU(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.val = value;

            // Move to MRU
            if (node != mr_pointer) {
                removeNode(node);
                addAtMRU(node);
            }

            return;
        }

        // New node
        Node newNode = new Node(key, value);

        map.put(key, newNode);
        count++;

        // First node
        if (count == 1) {
            lr_pointer = newNode;
            mr_pointer = newNode;
            return;
        }

        // Add to MRU
        addAtMRU(newNode);

        // Capacity exceeded
        if (count > length) {

            Node oldLRU = lr_pointer;

            lr_pointer = lr_pointer.next;
            lr_pointer.prev = null;

            map.remove(oldLRU.key);

            count--;
        }
    }

    private void removeNode(Node node) {

        // Node is LRU
        if (node == lr_pointer) {
            lr_pointer = node.next;

            if (lr_pointer != null) {
                lr_pointer.prev = null;
            }

            return;
        }

        // Node is somewhere after LRU
        node.prev.next = node.next;

        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private void addAtMRU(Node node) {

        node.prev = mr_pointer;
        node.next = null;

        mr_pointer.next = node;
        mr_pointer = node;
    }
}