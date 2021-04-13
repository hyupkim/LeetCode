/*
Use Priority Queue to Store the first node
of each linked list
Remember both ways to use lambda expression and
anonymous inner class with comparator
*/

import java.util.Queue;
import java.util.PriorityQueue;

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = new ListNode();
        ListNode pointer = head;
        Queue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        // Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode l1, ListNode l2){
        //         return l1.val - l2.val;
        //     }
        // });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            pointer.next = curr;
            pointer = pointer.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}