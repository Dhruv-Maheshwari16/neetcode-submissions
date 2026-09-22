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
    public void reorderList(ListNode head) {
        ListNode prev = head;
        if(head.next == null) {
            return;
        }
        ListNode curr = head.next;

        while(curr.next != null) {
            ListNode temp1 = curr.next;
            ListNode temp2 = curr;

            while(temp1.next != null) {
                temp2 = temp1;
                temp1 = temp1.next;
            }

            prev.next = temp1;
            temp1.next = curr;
            temp2.next = null;
            prev = curr;
            if(curr.next == null) {
                break;
            }
            curr = curr.next;
        }
    }
}
