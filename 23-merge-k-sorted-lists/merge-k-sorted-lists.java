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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        ListNode result = lists[0];
        for(int i = 1; i < lists.length; i++)
        {
            result = mergeList(result, lists[i]);
        }
        return result;
    }
    public ListNode mergeList(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null)
            return null;
        ListNode merge_list = new ListNode();
        ListNode temp = merge_list;
        while(list1 !=null && list2 !=null)
        {
            if(list1.val > list2.val){
                temp.next = list2;
                list2=list2.next;
            }
            else{
                temp.next = list1;
                list1=list1.next;
            }
            temp=temp.next;
        }
        while(list1!=null)
        {
           temp.next = list1;
           list1=list1.next;
           temp=temp.next;
        }
        while(list2!=null)
        {
           temp.next = list2;
           list2=list2.next;
           temp=temp.next;
        }
        return merge_list.next;
    }
}