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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left,right);
    }
    public ListNode mergeList(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null)
            return null;
        ListNode merge_list = new ListNode();
        ListNode temp = merge_list;
        while(list1 !=null && list2 !=null)
        {
            if(list1.val > list2.val){
                temp.next = new ListNode(list2.val);
                list2=list2.next;
            }
            else{
                temp.next = new ListNode(list1.val);
                list1=list1.next;
            }
            temp=temp.next;
        }
        while(list1!=null)
        {
           temp.next = new ListNode(list1.val);
           list1=list1.next;
           temp=temp.next;
        }
        while(list2!=null)
        {
           temp.next = new ListNode(list2.val);
           list2=list2.next;
           temp=temp.next;
        }
        return merge_list.next;
    }
}