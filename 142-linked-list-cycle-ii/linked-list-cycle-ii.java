/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode pointer = head;
        while(pointer!=null)
        {
            if(set.contains(pointer))
                return pointer;
            set.add(pointer);
            pointer=pointer.next;
        }
        return null;
    }
}
THIS IS A NORMAL APPROACH I TRIED EARLIER, AB ISKE BAAD FLOYD'S APPROACH SE KAISE KRE WO CODE HAI AB
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean loop =false;
        while(fast !=null && fast.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                loop=true;
                break;
            }
        }
        if(loop)
        {
            fast=head;
            while(slow != fast)
            {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}

