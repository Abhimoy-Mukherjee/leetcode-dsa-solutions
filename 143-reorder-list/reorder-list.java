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
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second_half=slow.next;
        slow.next=null;
        // ab second_half ko reverse krna hai
        ListNode reverse = null;
        ListNode cur = second_half;
        while(cur!=null)
        {
            ListNode next = cur.next;
            cur.next = reverse;
            reverse=cur;
            cur=next;
        }
        ListNode p1=head;
        ListNode p2=reverse;
        while(p2!=null)
        {
            ListNode p1next = p1.next;
            ListNode p2next = p2.next;
            p1.next=p2;
            if(p1next !=null)
                p2.next=p1next;
            p1=p1next;
            p2=p2next;
        }
    }
}