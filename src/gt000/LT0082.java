package gt000;

import pojo.ListNode;
import utils.LTUtils;

/**
 * 82. Remove Duplicates from Sorted List II
 * */
public class LT0082
{

    public static void main(String[] args)
    {
        int[] nums = {1,1,2,3,4,4,5};
        LTUtils.showListNode(Lt0082(LTUtils.convertIntArray2ListNode(nums)));
        
    }

    public static ListNode Lt0082(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode result = new ListNode(-1);
//        result.next = head;
        ListNode tail = result;
        
        int t = head.val;
        int num = 0;
        int i = 0;
        while(head.next != null)
        {
            i++;
            if(head.next.val == t)
            {
                head = head.next;
                continue;
            }
            else
            {
                if(i == num + 1)
                {
                    tail.next = head;
                    tail = tail.next;
                }
                head = head.next;
                t = head.val;
                num = i;
            }
            
        }
        
//        System.out.println(i + ", " + num);
        
        if(i == num)
        {
            tail.next = head;
            tail = tail.next;
        }
        
        tail.next = null;
        return result.next;
    }
}
