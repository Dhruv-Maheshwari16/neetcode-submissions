/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp1 = null;
        while(count < left) {
            temp1 = curr;
            curr = curr.next;
            count++;
        }

        ListNode second = curr;

        while(count < right) {
            second = second.next;
            count++;
        }
        
        if(second.next != null) {
            prev = second.next;
            second.next = null;
        }
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if(left > 1) {
            temp1.next = prev;
            return head;
        }
        return prev;
    }
}