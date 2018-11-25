package ge200;

import pojo.ListNode;
import utils.LTUtils;

public class LT0203_Remove_Linked_List_Elements
{

    public static void main(String[] args)
    {
        ListNode node = LTUtils.convertIntArray2ListNode(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        int val = 1;
        node = LTUtils.convertIntArray2ListNode(new int[] {1});
        val = 1;
        
        LTUtils.showListNode(new LT0203_Remove_Linked_List_Elements().Lt0203a(node, val));
        
    }

    // 5ms, most are [4, 6]ms
    // 可以用一个超前结点指向head。next 和 next.next 比较。
    private ListNode Lt0203a(ListNode head, int val)
    {
        
        if (head == null)
            return head;
        
        while (head != null && head.val == val)
            head = head.next;
        
        ListNode t1 = head;
        ListNode t2 = head == null ? null : head.next;
        
        while (t2 != null)
        {
            if (t2.val == val)
            {
                t1.next = t2.next;
            }
            else
            {
                t1 = t2;
            }
            t2 = t2.next;
        }
        
        return head;
    }
}
