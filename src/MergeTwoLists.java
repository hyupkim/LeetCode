/*
Use pointer to follow either l1 or l2
*/


public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode();
        ListNode pointer = head;
        while (!(l1 == null || l2 == null)) {
            if (l1.val > l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                pointer.next = l1;
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        if (l1 != null) {
            pointer.next = l1;
        } else if (l2 != null) {
            pointer.next = l2;
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