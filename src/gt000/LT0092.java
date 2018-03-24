package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 92. Reverse Linked List II
 * */
public class LT0092
{

    public static void main(String[] args)
    {
        ListNode head = LTUtils.convertIntArray2ListNode(new int[]{1,2,3,4,5});
        
        int m = 1;
        int n = 4;
        
        
        LTUtils.showListNode(Lt0092(head, m, n));
    }
    
    // 有几个new没有意义。
    // 4ms, beats 90%
    public static ListNode Lt0092(ListNode head, int m, int n)
    {
        if(m == n)
            return head;
        
        ListNode zero = new ListNode(-1);
        ListNode tail = new ListNode(-2);
        ListNode t1 = new ListNode(-3);
        ListNode t2 = new ListNode(-4);
        ListNode result = new ListNode(-5);
        zero.next = head;
        result.next = head;
        int i = 0;
        
        for(i = 1; i < m; i++)
        {
            zero = zero.next;
        }
        tail = zero.next;
        t2 = zero.next;
        t1 = null;
        for(; i <= n; i++)
        {
            tail = t2;
            t2 = tail.next;
            tail.next = t1;
            t1 = tail;
        }
        
        zero.next.next = t2;
        zero.next = tail;
        
        if(m == 1)              // ...
        {
            result.next = tail;
        }
        
        return result.next;
    }
}
