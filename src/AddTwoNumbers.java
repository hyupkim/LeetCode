/*
Use two pointers to loop over the nodes.
*/

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode();
        ListNode pointer = head;
        int carry = 0;

        while (!(l1 == null && l2 == null)) {
            
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = (num1 + num2 + carry);
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        if (carry == 1) {
            pointer.next = new ListNode(1);
        }

        return head.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }
    
}