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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode result = new ListNode(-101,null);
        ListNode head = result;
        while(curr1 != null && curr2 != null) {
            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;

            if(curr1.val <= curr2.val) {
                result.next = curr1;
                result = result.next;
                curr1 = temp1;
            }
            else {
                result.next = curr2;
                result = result.next;
                curr2 = temp2;
            }
        }

        if(curr1 != null) {
            result.next = curr1;
        }
        if(curr2 != null) {
            result.next = curr2;
        }

        return head.next;

    }
}