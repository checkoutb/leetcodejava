package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 83. Remove Duplicates from Sorted List
 * */
public class LT0083
{

    public static void main(String[] args)
    {
        int[] nums = {1,1};
        
        LTUtils.showListNode(Lt0083(LTUtils.convertIntArray2ListNode(nums)));
    }
    
    // 1ms
    public static ListNode Lt0083(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode result = new ListNode(-1);
        ListNode tail = result;
//        tail.next = head;
//        tail = tail.next;
        int t = head.val;
        while(head.next != null)
        {
            if(head.next.val != t)
            {
                tail.next = head;
                tail = tail.next;
                t = head.next.val;
            }
            head = head.next;
        }
        
        tail.next = head;           // ...
        tail = tail.next;
        tail.next = null;
        return result.next;
    }
    
}
