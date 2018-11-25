package ge200;

import pojo.ListNode;
import utils.LTUtils;

public class LT0206_Reverse_Linked_List
{

    public static void main(String[] args)
    {
        ListNode node = LTUtils.convertIntArray2ListNode(new int [] {1,2,3,4,5});
        
        LTUtils.showListNode(new LT0206_Reverse_Linked_List().Lt0206b(node));
    }

    // 0ms, most are [0, 0]ms.
    private ListNode Lt0206b(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        
        ListNode result = head;
        while (result.next != null)
            result = result.next;
        
        this.recursionb1(head).next = null;
        
        return result;
    }
    
    private ListNode recursionb1(ListNode node)
    {
        if (node.next == null)
            return node;
        else
//        {
//            ListNode next = recursionb1(node.next);
//            next.next = node;
//            return node;
            return (this.recursionb1(node.next).next = node);
//        }
    }
    
    // 0ms
    private ListNode Lt0206a(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        
        ListNode result = null;
        ListNode t1 = head;
        ListNode t2 = head.next;
        head.next = null;
        ListNode t3 = null;
        while (t2 != null)
        {
            t3 = t2.next;
            t2.next = t1;
            t1 = t2;
            t2 = t3;
        }
        result = t1;
        return result;
    }
}
