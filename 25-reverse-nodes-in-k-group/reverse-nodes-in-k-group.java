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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(!hasNodes(head,k))
            return head;
        ListNode prev = null;
        ListNode cur = head;
        int count = 0;
        while(cur!=null && count<k)
        {
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            count++;
        }
        head.next=reverseKGroup(cur, k);
        return prev;
    }
    public boolean hasNodes(ListNode node, int k){
        int count = 0;
        while(node!=null && count<k){
            node=node.next;
            count++;
        }
        return count==k;
    }
}