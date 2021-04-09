/*
Think which data structures are gonna be used
Make HashMap + Doubly Linked List
Make custom class of DLL to store cache in order

Note that since we are storing the cache with
Least Recently Used Order,
Adding the node will always take place right after the head.
But removing the node can take place from anywhere.
*/

import java.util.Map;
import java.util.HashMap;

public class LRUCache {

    Map<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        node.remove();
        node.addHead();
        return node.val;
    }
    
    public void put(int key, int value) {
        
        Node node;

        if (map.containsKey(key)) {
            node = map.get(key);
            node.remove();
            node.val = value;
            count--;
            
        } else {
            node = new Node(key, value);
        }

        node.addHead();
        map.put(key, node);
        count++;

        if (count > capacity) {   
            Node last = tail.prev; 
            map.remove(last.key);
            last.remove();
            count--;
        }
    }

    public class Node {

        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public void addHead() {
            this.prev = head;
            this.next = head.next;
            head.next = this;
            this.next.prev = this;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }

    }
}
