
    /*
     * LRU (Least Recently Used) Cache is a data structure that stores a fixed number of key-value pairs.
        When the cache reaches its limit and a new item is added, the least recently used item
            (one that hasn’t been accessed for the longest time) is removed.

        Expected operations:
        get(key) → Return value if key exists, else return -1.
        put(key, value) → Insert/update key-value pair. If full, remove least recently used item.

        Using a HashMap + Doubly Linked List
        HashMap → Provides O(1) lookup for key-value pairs.
        Doubly Linked List → Maintains order of usage (Most Recently Used at end, Least Recently Used at front).
        Logic:
        Accessing (get) → Move key to end (mark as recently used).
        Inserting (put) → Add to end, remove front if full.

     */


import java.util.*;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node); // Move to end (most recent)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) remove(map.get(key));

        if (map.size() == capacity) {
            map.remove(head.next.key); // Remove LRU element
            remove(head.next);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(1)); // Output: 10
        lru.put(3, 30); // Removes key 2
        System.out.println(lru.get(2)); // Output: -1
    }
}
