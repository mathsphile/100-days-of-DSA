// Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

// PUT x y: sets the value of the key x with value y
// GET x: gets the key of x if present else returns -1.
// The LRUCache class has two methods get() and put() which are defined as follows.

// get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
// put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
// In the constructor of the class the capacity of the cache should be initialized.
class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList dll;

    // Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        dll.moveToHead(node); // Move accessed node to the head of the list (most recently used).
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update value.
            dll.moveToHead(node); // Move the node to the head.
        } else {
            if (cache.size() == capacity) {
                Node tail = dll.removeTail(); // Remove least recently used node.
                cache.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            dll.addToHead(newNode); // Add new node to the head.
            cache.put(key, newNode);
        }
    }

    // Doubly linked list class for managing the LRU order.
    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            Node tailPrev = tail.prev;
            removeNode(tailPrev);
            return tailPrev;
        }
    }

    // Node class for the doubly linked list.
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
