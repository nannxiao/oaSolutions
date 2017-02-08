# reverse 2nd half of linked list

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        // in case that the number of elements is odd, we need to reverse from the middle of linked list
        // add linked list dummy
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // find the middle point slow, start reversing the right half of the linked list

        ListNode pre = null;
        ListNode cur = slow.next;

        while(cur != null){
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return head;
    }
}
